package com.solarexsoft.kotlinlearning

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Solarex on 2020/4/27/4:47 PM
 * Desc:
 */
interface MMKVOwner {
    val mmkv: MMKVImpl
}
class MMKVImpl {
    fun encodeBool(key: String, value: Boolean) {

    }
    fun decodeBool(key: String, defaultValue: Boolean): Boolean {
        return false
    }
}
class ReadWriteBoolean(
        private val defaultValue: Boolean = false
):ReadWriteProperty<MMKVOwner, Boolean>{
    override fun getValue(thisRef: MMKVOwner, property: KProperty<*>): Boolean {
        println(property.name)
        return thisRef.mmkv.decodeBool(property.name, defaultValue)
    }

    override fun setValue(thisRef: MMKVOwner, property: KProperty<*>, value: Boolean) {
        println(property.name)
        thisRef.mmkv.encodeBool(property.name, value)
    }
}

object GlobalStorage: MMKVOwner{
    override val mmkv: MMKVImpl
        get() = MMKVImpl()
    var login: Boolean by ReadWriteBoolean(false)
}

fun main() {
    GlobalStorage.login = true
}