package com.solarexsoft.kotlinlearning

/**
 * Created by houruhou on 2019/9/25.
 * Desc:
 */
class Outer {
    fun hi() {
        val inner = Inner()
//        inner.a
    }
    class Inner {
        private val a = 0;
    }
}

fun main() {
    
}