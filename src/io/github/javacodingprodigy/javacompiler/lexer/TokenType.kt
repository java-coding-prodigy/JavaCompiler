package io.github.javacodingprodigy.javacompiler.lexer

enum class TokenType(val regex: Regex, val keyword: Boolean = false) {

    IF("if"), ELSE("else"), SWITCH("swtch"),
    WHILE("while"), FOR("for"), DO("do"),

    NEW_LINE('\n')
    ;

    constructor(keyword: String) : this(keyword.toRegex(), true)
    constructor(ch: Char) : this(ch.toString().toRegex())

}
