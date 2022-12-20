package com.solarexsoft.asm

import jdk.internal.org.objectweb.asm.*
import java.io.FileInputStream


/*
 * Created by Solarex on 2022/12/20 15:31
 */

data class Asm1(private val age: Int, private val name: String)

fun main() {
    val classPath = getClassFilePath(Asm1::class.java)
    val classReader = ClassReader(FileInputStream(classPath))
    val classVisitor = object : ClassVisitor(Opcodes.ASM5) {
        override fun visitField(
            access: Int,
            name: String?,
            descriptor: String?,
            signature: String?,
            value: Any?
        ): FieldVisitor {
            println("visit field $name --> $descriptor")
            // exception throw
            return super.visitField(access, name, descriptor, signature, value)
        }

        override fun visitMethod(
            access: Int,
            name: String?,
            descriptor: String?,
            signature: String?,
            exceptions: Array<out String>?
        ): MethodVisitor {
            println("visit method $name --> $descriptor")
            return super.visitMethod(access, name, descriptor, signature, exceptions)
        }
    }
    classReader.accept(classVisitor, 0)
}