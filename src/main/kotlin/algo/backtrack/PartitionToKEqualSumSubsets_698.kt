package algo.backtrack

class KtPartitionToKEqualSumSubsets_698 {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val total = nums.sum()
        if (total % k != 0) {
            return false
        }
        val target = total / k

        fun backtrack(nums: IntArray, sum: Int, subsetNum: Int, bitmask: Int, dp: Array<IntArray>): Int {
            if (sum == total && subsetNum == k) {
                return 1
            }
            if (dp[subsetNum][bitmask] != 0) {
                return dp[subsetNum][bitmask]
            }
            val currentSum = sum % target
            for (i in nums.indices) {
                val pos = 1 shl (nums.size - i)
                if (pos and bitmask != 0) {
                    continue
                }
                val nextSum = currentSum + nums[i]
                if (nextSum > target) {
                    continue
                }
                val nextSubsetNum = if (nextSum == target) subsetNum + 1 else subsetNum
                val res = backtrack(nums, sum + nums[i], nextSubsetNum, pos xor bitmask, dp)
                dp[subsetNum][bitmask] = res
                if (res == 1) {
                    break
                }
                dp[subsetNum][bitmask] = -1
            }
            return dp[subsetNum][bitmask]
        }

        val dp = Array(k + 1) { IntArray(1 shl (nums.size + 1)) {0} }
        return backtrack(nums, 0, 0, 0, dp) == 1
    }
}

fun main() {
    val kpartition = KtPartitionToKEqualSumSubsets_698()
    println(kpartition.canPartitionKSubsets(intArrayOf(4,3,2,3,5,2,1), 4))
    println(kpartition.canPartitionKSubsets(intArrayOf(1,2,3,4), 3))
}