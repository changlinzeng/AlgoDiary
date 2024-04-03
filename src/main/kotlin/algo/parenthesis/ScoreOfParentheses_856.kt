package algo.parenthesis

import java.util.*

class KtScoreOfParentheses_856 {
    fun scoreOfParentheses(s: String): Int {
        val stack = Stack<Int>()
        s.forEach {
            when (it) {
                '(' -> stack.push(0)
                ')' -> {
                    var sum = 0
                    while (stack.isNotEmpty()) {
                        val e = stack.pop()
                        sum += e
                        if (e == 0) {
                            break
                        }
                    }
                    stack.push(if (sum == 0) 1 else sum * 2)
                }
            }
        }
        return stack.sum()
    }
}

fun main() {
    val score = KtScoreOfParentheses_856()
    println(score.scoreOfParentheses("()"))
    println(score.scoreOfParentheses("(())"))
    println(score.scoreOfParentheses("()()"))
}