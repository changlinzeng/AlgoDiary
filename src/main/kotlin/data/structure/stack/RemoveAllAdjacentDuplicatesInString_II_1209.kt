package data.structure.stack

import java.util.Stack

class KtRemoveAllAdjacentDuplicatesInString_II_1209 {
    fun removeDuplicates(s: String, k: Int): String {
        val stack = Stack<CharCount>()
        s.forEach { c ->
            if (stack.isNotEmpty() && stack.peek().char == c) {
                val top = stack.peek()
                if (top.count == k - 1) {
                    stack.pop()
                } else {
                    top.count++
                }
            } else {
                stack.push(CharCount(c, 1))
            }
        }
        return stack.joinToString("") { it.char.toString().repeat(it.count) }
    }

    data class CharCount(val char: Char, var count: Int)
}

fun main() {
    val remove = KtRemoveAllAdjacentDuplicatesInString_II_1209()
    println(remove.removeDuplicates("abcd", 2))
    println(remove.removeDuplicates("deeedbbcccbdaa", 3))
    println(remove.removeDuplicates("pbbcggttciiippooaais", 2))
}