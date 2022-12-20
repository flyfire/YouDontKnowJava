package com.solarexsoft

import jdk.internal.org.objectweb.asm.ClassReader
import jdk.internal.org.objectweb.asm.Opcodes
import jdk.internal.org.objectweb.asm.tree.ClassNode

import java.io.File
import java.io.FileInputStream


/*
 * Created by Solarex on 2022/12/20 15:01
 */
fun getClassFilePath(clazz: Class<*>): String {
    val buildDir = clazz.protectionDomain.codeSource.location.file
    val fileName = "${clazz.simpleName}.class"
    val packagePath = clazz.`package`.name.replace("[.]".toRegex(), "/")
    println(buildDir)
    println(fileName)
    println(packagePath)
    val file = File("${buildDir}${packagePath}/${fileName}")
    return file.absolutePath
}

class Asm0(private val hello: Int, private var world: String) {
    fun hi(a: Int) = Unit
    fun hello() = "world"
}

fun main() {
    val classPath = getClassFilePath(Asm0::class.java)
    println(classPath)
    val classReader = ClassReader(FileInputStream(classPath))
    val classNode = ClassNode(Opcodes.ASM5)
    classReader.accept(classNode, 0)

    val methods = classNode.methods
    println("methods: ")
    methods.forEach {
        println("${it.name} --> ${it.desc}")
    }
    val fields = classNode.fields
    println("fields: ")
    fields.forEach {
        println("${it.name} --> ${it.desc}")
    }
}