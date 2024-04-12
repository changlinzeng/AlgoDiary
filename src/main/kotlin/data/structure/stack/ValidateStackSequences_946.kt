package data.structure.stack

import java.util.Stack

class KtValidateStackSequences_946 {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var i = 0
        pushed.forEach { p ->
            stack.push(p)
            while (stack.isNotEmpty() && i < popped.size && stack.peek() == popped[i]) {
                stack.pop()
                i++
            }
        }
        return i == popped.size
    }
}

fun main() {
    val validate = KtValidateStackSequences_946()
    println(validate.validateStackSequences(intArrayOf(1,2,3,4,5), intArrayOf(4,5,3,2,1)))
}