package algo.parenthesis

import java.util.Stack

class KtLongestValidParentheses_32 {
    fun longestValidParentheses(s: String): Int {
        val stack = Stack<String>()
        var leftParen = 0; var rightParen = 0
        s.forEach { c ->
            if (c == '(') {
                stack.push("(")
                leftParen++
            } else {
                var str = ")"
                if (rightParen < leftParen) {
                    while (stack.isNotEmpty()) {
                        val e = stack.pop()
                        str = e + str
                        if (e == "(") {
                            break
                        }
                    }
                    rightParen++
                }
                stack.push(str)
            }
        }

        var len = 0
        var longest = 0
        stack.forEach {
            if (it == "(" || it == ")") {
                longest = longest.coerceAtLeast(len)
                len = 0
            } else {
                len += it.length
            }
        }
        longest = longest.coerceAtLeast(len)
        return longest
    }
}

fun main() {
    val valid = KtLongestValidParentheses_32()
    println(valid.longestValidParentheses("(()"))
    println(valid.longestValidParentheses(")()())"))
    println(valid.longestValidParentheses(""))
    println(valid.longestValidParentheses(")()())()()("))
}