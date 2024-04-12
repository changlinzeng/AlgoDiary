package data.structure.stack

import java.util.Stack

class KtReverseSubstringsBetweenEachPairOfParentheses_1190 {
    fun reverseParentheses(s: String): String {
        val stack = Stack<Char>()
        s.forEach { c ->
            when (c) {
                ')' -> {
                    val list: MutableList<Char> = mutableListOf()
                    while (stack.isNotEmpty()) {
                        val ch = stack.pop()
                        if (ch == '(') {
                            list.forEach { stack.push(it) }
                            break
                        }
                        list.add(ch)
                    }
                }
                else -> {
                    stack.push(c)
                }
            }
        }
        return stack.joinToString("")
    }
}

fun main() {
    val reverse = KtReverseSubstringsBetweenEachPairOfParentheses_1190()
    println(reverse.reverseParentheses("(abcd)"))
    println(reverse.reverseParentheses("(u(love)i)"))
    println(reverse.reverseParentheses("(ed(et(oc))el)"))
}