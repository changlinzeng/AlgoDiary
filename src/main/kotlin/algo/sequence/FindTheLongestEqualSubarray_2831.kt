package algo.sequence

import java.util.Queue

class KtFindTheLongestEqualSubarray_2831 {
    fun longestEqualSubarray(nums: List<Int>, k: Int): Int {
        val count: MutableMap<Int, MutableList<Int>> = mutableMapOf() // num -> indices of num
        var maxLen = 0
        nums.indices.forEach { i ->
            val num = nums[i]
            count.getOrPut(num) {ArrayDeque()}.add(i)
            val q = count[num]!!

            // from the first index of num to current index i, there are i - q.peek() + 1 elements
            // we need to make sure there are no more than k numbers other than num in this range
            while (q.isNotEmpty() && i - q.first() + 1 - q.size > k) {
                q.removeFirst()
            }
            maxLen = maxLen.coerceAtLeast(q.size)
        }
        return maxLen
    }
}