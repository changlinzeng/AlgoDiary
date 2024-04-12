package data.structure.stack

import java.util.Stack

class KtFindTheMostCompetitiveSubsequence_1673 {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val maxStack = Stack<Int>()  // maintain the sequence in max stack
        val len = nums.size
        nums.indices.forEach { i ->
            val num = nums[i]
            // need to make sure we have enough elements left
            while (maxStack.isNotEmpty() && maxStack.peek() > num && maxStack.size + len - i > k) {
                maxStack.pop()
            }
            if (maxStack.size < k) {
                maxStack.push(num)
            }
        }
        return maxStack.toIntArray()
    }
}

fun main() {
    val competitive = KtFindTheMostCompetitiveSubsequence_1673()
    println(competitive.mostCompetitive(intArrayOf(3,5,2,6), 2).toList())
    println(competitive.mostCompetitive(intArrayOf(2,4,3,3,5,4,9,6), 4).toList())
}