package com.solarexsoft.kotlinlearning

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Solarex on 2020/4/27/5:04 PM
 * Desc:
 */
open class ByRef {
    val realObj: Any = Any()

    var hello: Boolean by ReadWriteByBoolean(false)
}
class ReadWriteByBoolean(
        private val defaultValue:Boolean = false
): ReadWriteProperty<ByRef,Boolean>{
    override fun getValue(thisRef: ByRef, property: KProperty<*>): Boolean {
        println("get --> ${property.name}")
        return false
    }

    override fun setValue(thisRef: ByRef, property: KProperty<*>, value: Boolean) {
        println("set --> ${property.name}")
    }
}

object HiRef: ByRef() {
    var world: Boolean by ReadWriteByBoolean(false)
}

fun main() {
    val byRef = ByRef()
    println(byRef.hello)
    byRef.hello = true
    println(HiRef.world)
    HiRef.world = true
}