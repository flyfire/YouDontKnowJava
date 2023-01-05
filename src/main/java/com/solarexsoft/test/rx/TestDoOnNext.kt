package com.solarexsoft.test.rx

import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers


/*
 * Created by Solarex on 2023/01/05 11:56
 */
data class ZHResult(val name: String, val others: String)
data class ZHTransResult(val zh: String, val en: String)

fun main() {
    Single.create<ZHResult>(SingleOnSubscribe {
        Thread.sleep(1000)
        println("thread = ${Thread.currentThread().name} zhResult")
        it.onSuccess(ZHResult("hello", "world"))
    }).subscribeOn(Schedulers.io())
        .observeOn(Schedulers.newThread())
        .doOnSuccess {
            println("thread = ${Thread.currentThread().name}, zhResult = ${it}")
        }.observeOn(Schedulers.io()).flatMap {
            Thread.sleep(1000)
            println("thread = ${Thread.currentThread().name}, translating")
            Single.just(ZHTransResult(it.name, "translated"))
        }
        .observeOn(Schedulers.newThread())
        .subscribe(
            {
                println("thread = ${Thread.currentThread().name}, transResult = $it")
            },
            {
                println("thread = ${Thread.currentThread().name}, error = ${it.message}")
            }
        )
    Thread.sleep(10000)
}