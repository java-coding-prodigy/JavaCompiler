package io.github.javacodingprodigy.javacompiler.lexer

data class Token(
    val content: String,
    val type: TokenType,
    val lineIdx: Int,
    val index: Int,
    val line: String,
    val file: String
)
