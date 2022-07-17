package io.github.javacodingprodigy.javacompiler.lexer

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun tokens(file: String) : List<Token>{
    val lines = Path(file).readLines()
    val tokens = mutableListOf<Token>()
    lines.forEachIndexed{ lineNo, line ->
        var index = 0
        while(index < line.length) {
            val content = line.substring(index)
            if(TokenType.values().find { type ->
              val match = type.regex.find(content)
                if(match != null){
                    val token = match.groupValues.first()
                    tokens.add(
                        Token(token, type,lineNo, index,line,file)
                    )
                    index += token.length
                }
              match != null
            } == null){
                throw IllegalArgumentException("Invalid token at $lineNo:$index\n$line\n ")
            }
        }
        tokens.add(Token("\n",TokenType.NEW_LINE,lineNo,index,"?",file))
    }
    return tokens
}