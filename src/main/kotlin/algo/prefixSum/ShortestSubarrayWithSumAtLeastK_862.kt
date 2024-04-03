package algo.prefixSum

class KtShortestSubarrayWithSumAtLeastK_862 {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val prefixSum = LongArray(nums.size + 1)
        nums.indices.forEach { idx ->
            prefixSum[idx + 1] = nums[idx] + prefixSum[idx]
        }

        // maintain an increasing sequence of prefix sum and check the diff between two sums
        val maxQ = ArrayDeque<Int>()
        var minLen = Int.MAX_VALUE
        prefixSum.indices.forEach { idx ->
            val value = prefixSum[idx]
            while (maxQ.isNotEmpty() && prefixSum[maxQ.last()] > value) {
                maxQ.removeLast()
            }
            maxQ.addLast(idx)
            while (maxQ.isNotEmpty() && value - prefixSum[maxQ.first()] >= k) {
                val e = maxQ.removeFirst()
                minLen = minLen.coerceAtMost(idx - e)
            }
        }
        return if (minLen == Int.MAX_VALUE) -1 else minLen
    }
}

fun main() {
    val subarray = KtShortestSubarrayWithSumAtLeastK_862()
    println(subarray.shortestSubarray(intArrayOf(1), 1))
    println(subarray.shortestSubarray(intArrayOf(1,2), 4))
    println(subarray.shortestSubarray(intArrayOf(2,-1,2), 3))
}