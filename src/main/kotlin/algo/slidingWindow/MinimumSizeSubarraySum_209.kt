package algo.slidingWindow

class KtMinimumSizeSubarraySum_209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0; var right = 0
        var sum = 0
        var minLen = Int.MAX_VALUE
        while (right < nums.size) {
            sum += nums[right]
            if (sum >= target) {
                while (left < right && sum - nums[left] >= target) {
                    sum -= nums[left]
                    left++
                }
                minLen = minLen.coerceAtMost(right - left + 1)
            }
            right++
        }
        return if (minLen == Int.MAX_VALUE) 0 else minLen;
    }
}

fun main() {
    val subarray = KtMinimumSizeSubarraySum_209()
//    println(subarray.minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
//    println(subarray.minSubArrayLen(4, intArrayOf(1,4,4)))
    println(subarray.minSubArrayLen(11, intArrayOf(1,2,3,4,5)))
}