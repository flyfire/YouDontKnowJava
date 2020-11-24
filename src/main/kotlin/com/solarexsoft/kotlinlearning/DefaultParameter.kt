package com.solarexsoft.kotlinlearning

/**
 * Created by Solarex on 2020/11/24/11:38 AM
 * Desc:
 */
interface IView {
    fun show(reportShowing: Boolean = true)
}

class AView: IView {
    override fun show(reportShowing: Boolean) {
        println("show $reportShowing")
    }
}

fun main() {
    val a = AView()
    a.show()
}