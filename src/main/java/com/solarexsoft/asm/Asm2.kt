package com.solarexsoft.asm

import jdk.internal.org.objectweb.asm.ClassReader
import jdk.internal.org.objectweb.asm.ClassVisitor
import jdk.internal.org.objectweb.asm.ClassWriter
import jdk.internal.org.objectweb.asm.Opcodes
import java.io.FileInputStream
import java.io.FileOutputStream


/*
 * Created by Solarex on 2022/12/20 16:05
 */

class Asm2 {
    fun m() {
        Thread.sleep(2000)
    }
}

class AddTimerClassVisitor(val api: Int, val classVisitor: ClassVisitor) : ClassVisitor(api, classVisitor) {
    override fun visitEnd() {
        if (cv != null) {
            cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "timer", "J", null, null)?.visitEnd()
            cv.visitEnd()
        }
    }
}

fun main() {
    val classPath = getClassFilePath(Asm2::class.java)
    val classReader = ClassReader(FileInputStream(classPath))
    val classWriter = ClassWriter(0)
    val addTimerVisitor = AddTimerClassVisitor(Opcodes.ASM5, classWriter)
    classReader.accept(addTimerVisitor, 0)

    val bytes = classWriter.toByteArray()
    val fos = FileOutputStream("D:\\workspace\\repos\\YouDontKnowJava\\src\\main\\java\\com\\solarexsoft\\asm\\Asm2Copy.class")
    fos.write(bytes)
    fos.flush()
    fos.close()
}