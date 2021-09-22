package com.solarexsoft.visitor

import kotlin.math.abs
import kotlin.random.Random

fun main(args: Array<String>) {
    val alphabet = mutableListOf<Char>()
    for (i in 0..25) {
        alphabet.add('A' + i)
    }
    println(alphabet)
    val random = Random(26)
    for (i in 0..2) {
        val sb = StringBuilder()
        for (j in 0..137) {
            sb.append(alphabet[abs(random.nextInt()) % 25])
        }
        println(sb)
    }
}