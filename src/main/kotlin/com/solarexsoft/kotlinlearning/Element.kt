package com.solarexsoft.kotlinlearning

fun main() {
    val list = mutableListOf<Int>()
    for (i in 1..12) {
        list.add(i)
    }
    println(list.indexOf(11))
}