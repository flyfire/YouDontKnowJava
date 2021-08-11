package com.solarexsoft.visitor

interface ResourceFile {
    fun accept(visitor: Visitor)
}

class PdfFile : ResourceFile {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class WordFile : ResourceFile {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class PptFile : ResourceFile {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}
interface Visitor {
   fun visit(pdfFile: PdfFile)
   fun visit(wordFile: WordFile)
   fun visit(pptFile: PptFile)
}

class ExtractText : Visitor {
    override fun visit(pdfFile: PdfFile) {
        println("extract text from pdf")
    }

    override fun visit(wordFile: WordFile) {
        println("extract text from word")
    }

    override fun visit(pptFile: PptFile) {
        println("extract text from ppt")
    }

}

class Compressor : Visitor {
    override fun visit(pdfFile: PdfFile) {
        println("compress pdf")
    }

    override fun visit(wordFile: WordFile) {
        println("compress word")
    }

    override fun visit(pptFile: PptFile) {
        println("compress ppt")
    }

}

fun main() {
    val files = listOf<ResourceFile>(WordFile(), PdfFile(), PptFile())
    val extractor = ExtractText()
    files.forEach {
        it.accept(extractor)
    }
    val compressor = Compressor()
    files.forEach {
        it.accept(compressor)
    }
}
