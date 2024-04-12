package data.structure.stack

import java.util.Stack

class KtRemoveKDigits_402 {
    // the same as FindTheMostCompetitiveSubsequence_1673
    fun removeKdigits(num: String, k: Int): String {
        val maxStack = Stack<Char>()
        val len = num.length - k  // keep len digits in final result
        if (len == 0) {
            return "0"
        }
        num.indices.forEach { i ->
            val c = num[i]
            while (maxStack.isNotEmpty() && maxStack.peek() > c && maxStack.size + num.length - i > len) {
                maxStack.pop()
            }
            if (maxStack.size < len) {
                maxStack.push(c)
            }
        }

        val digits = maxStack.joinToString("")
        var start = 0
        while (start < digits.length && digits[start] == '0') {
            start++
        }
        // return "0" if all digits are 0
        return if (start == digits.length) "0" else digits.substring(start)
    }
}

fun main() {
    val remove = KtRemoveKDigits_402()
    println(remove.removeKdigits("1432219", 3))
    println(remove.removeKdigits("10200", 1))
    println(remove.removeKdigits("10", 2))
}