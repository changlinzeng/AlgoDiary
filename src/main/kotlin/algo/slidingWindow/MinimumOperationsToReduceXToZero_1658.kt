package algo.slidingWindow

class KtMinimumOperationsToReduceXToZero_1658 {
    // this equals to find max length of subarray with sum equals total - x
    fun minOperations(nums: IntArray, x: Int): Int {
        val target = nums.sum() - x
        var left = 0; var right = 0
        var maxLen = Int.MIN_VALUE
        var sum = 0
        if (target == 0) {
            return nums.size
        }
        while (right < nums.size) {
            sum += nums[right]
            if (sum == target) {
                maxLen = maxLen.coerceAtLeast(right - left + 1)
            } else if (sum > target) {
                while (left < right && sum > target) {
                    sum -= nums[left]
                    left++
                }
                if (sum == target) {
                    maxLen = maxLen.coerceAtLeast(right - left + 1)
                }
            }
            right++
        }
        return if (maxLen == Int.MIN_VALUE) -1 else nums.size - maxLen
    }
}

fun main() {
    val op = KtMinimumOperationsToReduceXToZero_1658()
    println(op.minOperations(intArrayOf(1,1,4,2,3), 5))
    println(op.minOperations(intArrayOf(3,2,20,1,1,3), 10))
}