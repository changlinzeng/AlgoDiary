package data.structure.stack

import java.util.Stack

class KtRemoveDuplicateLetters_316 {
    fun removeDuplicateLetters(s: String): String {
        val count: MutableMap<Char, Int> = HashMap()
        s.forEach { count[it] = count.getOrDefault(it, 0) + 1 }

        val maxStack = Stack<Char>()
        s.forEach { c ->
            if (maxStack.contains(c)) {
                count[c] = count[c]!! - 1
            } else {
                // discard duplicates
                while (maxStack.isNotEmpty() && maxStack.peek() >= c && count[maxStack.peek()]!! > 1) {
                    count[maxStack.peek()] = count[maxStack.peek()]!! - 1
                    maxStack.pop()
                }
                maxStack.push(c)
            }
        }

        return maxStack.joinToString("")
    }
}

fun main() {
    val remove = KtRemoveDuplicateLetters_316()
    println(remove.removeDuplicateLetters("bcabc"))
    println(remove.removeDuplicateLetters("cbacdcbc"))
    println(remove.removeDuplicateLetters("bbcaac"))
}