package data.structure.stack

import java.util.Stack

class KtNextGreaterElement_II_503 {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { -1 }
        val minStack = Stack<Int>()
        // loop twice
        for (i in 0..<nums.size * 2) {
            val idx = i % nums.size
            val num = nums[idx]
            while (minStack.isNotEmpty() && nums[minStack.peek()] < num) {
                result[minStack.pop()] = num
            }
            minStack.push(idx)
        }
        return result
    }
}

fun main() {
    val nextGreater = KtNextGreaterElement_II_503()
    println(nextGreater.nextGreaterElements(intArrayOf(1,2,1)).toList())
    println(nextGreater.nextGreaterElements(intArrayOf(1,2,3,4,3)).toList())
    println(nextGreater.nextGreaterElements(intArrayOf(1,1,1,1)).toList())
    println(nextGreater.nextGreaterElements(intArrayOf(1,2,3,2,1)).toList())
}