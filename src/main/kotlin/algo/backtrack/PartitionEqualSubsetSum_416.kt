package algo.backtrack

class KtPartitionEqualSubsetSum_416 {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 != 0) {
            return false
        }
        val half = total / 2

        fun backtrack(nums: IntArray, target: Int, start: Int, dp: Array<IntArray>): Int {
            if (target == 0) {
                return 1
            }
            if (dp[start][target] != 0) {
                return dp[start][target]
            }
            for (i in start..<nums.size) {
                val remain = target - nums[i]
                if (remain >= 0) {
                    val res = backtrack(nums, remain, i + 1, dp)
                    dp[start][target] = res
                    if (res == 1) {
                        break
                    }
                    dp[start][target] = -1
                }
            }
            return dp[start][target]
        }

        return backtrack(nums, half, 0, Array(nums.size + 1){IntArray(half + 1) {0} }) == 1
    }
}

fun main() {
    val partition = KtPartitionEqualSubsetSum_416()
    println(partition.canPartition(intArrayOf(1,5,11,5)))
    println(partition.canPartition(intArrayOf(1,2,3,5)))
}