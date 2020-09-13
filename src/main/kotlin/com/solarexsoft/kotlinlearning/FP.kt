package com.solarexsoft.kotlinlearning

/**
 * Created by Solarex on 2020/4/27/6:21 PM
 * Desc:
 */
fun play(onLoading: (curVideoId:Int)->Unit, onFinish: () -> Unit) {
    onLoading(1)
    onFinish.invoke()
}
fun setProgress(onLoading: (curVideoId: Int) -> Unit, onFinish: () -> Unit) {
    onLoading.invoke(2)
    onFinish.invoke()
}

fun onLoading(curVideoId: Int): Unit {
    println(curVideoId)
}

fun onFinish():Unit {

}

fun main() {
    var a = 60_000L
    println(a)
    a = 60_000_000_000L
    println(a)
    play(::onLoading, ::onFinish)
    setProgress(::onLoading) { println("hi") }
}