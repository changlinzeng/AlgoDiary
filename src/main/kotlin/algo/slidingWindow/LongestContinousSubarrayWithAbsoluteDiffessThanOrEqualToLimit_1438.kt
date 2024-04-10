package algo.slidingWindow

import kotlin.math.absoluteValue

class KtLongestContinousSubarrayWithAbsoluteDiffessThanOrEqualToLimit_1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        var left = 0; var right = 0
        // min and max value in the window
        var min = Int.MAX_VALUE; var max = Int.MIN_VALUE
        var diff = 0
        var maxLen = 0
        while (right < nums.size) {
            min = min.coerceAtMost(nums[right])
            max = max.coerceAtLeast(nums[right])
            diff = max - min
            if (diff <= limit) {
                maxLen = maxLen.coerceAtLeast(right - left + 1)
            } else {
                // find min/max and left boundary backward
                left = right
                min = nums[left]
                max = nums[left]
                while (left > 0 && (nums[left - 1] - nums[right]).absoluteValue <= limit) {
                    left--
                    min = min.coerceAtMost(nums[left])
                    max = max.coerceAtLeast(nums[left])
                }
            }
            right++
        }
        return maxLen
    }
}

fun main() {
    val subarray = KtLongestContinousSubarrayWithAbsoluteDiffessThanOrEqualToLimit_1438()
    println(subarray.longestSubarray(intArrayOf(8,2,4,7), 4))
    println(subarray.longestSubarray(intArrayOf(10,1,2,4,7,2), 5))
    println(subarray.longestSubarray(intArrayOf(4,2,2,2,4,4,2,2), 0))
    println(subarray.longestSubarray(intArrayOf(1,5,6,7,8,10,6,5,6), 4))
}