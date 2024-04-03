package algo.backtrack

class KtSplitArrayWithSameAverage_805 {
    fun splitArraySameAverage(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return false
        }
        val total: Double = nums.sum().toDouble()
        val avg: Double = total / nums.size

        fun backtrack(nums: IntArray, target: Double, group: MutableList<Int>, bitmask: IntArray, dp: Array<IntArray>): Int {
            val average = group.average()
            if (average.compareTo(target) == 0 && group.size < nums.size) {
                return 1
            }
            val (mask1, mask2) = bitmask
            if (dp[mask1][mask2] != 0) {
                return dp[mask1][mask2]
            }
            for (i in nums.indices) {
                val mid = (nums.size - 1) / 2
                val section = if (i <= mid) 0 else 1
                val offset = if (section == 0) mid - i + 1 else nums.size - i
                val pos = 1 shl (offset)
                if (section == 0 && pos and mask1 != 0 || section == 1 && pos and mask2 != 0) {
                    continue
                }
                group.add(nums[i])
                val newMasks = intArrayOf(mask1, mask2)
                if (section == 0) {
                    newMasks[0] = newMasks[0] xor pos
                } else {
                    newMasks[1] = newMasks[1] xor pos
                }
                val res = backtrack(nums, target, group, newMasks, dp)
                group.removeLast()
                dp[mask1][mask2] = res
                if (res == 1) {
                    break
                }
                dp[mask1][mask2] = -1
            }
            return dp[mask1][mask2]
        }

        val arrSize = 1 shl (nums.size / 2 + 1)
        return backtrack(nums, avg, mutableListOf(), intArrayOf(0, 0), Array(arrSize) { IntArray(arrSize) {0} }) == 1
    }
}

fun main() {
    val split = KtSplitArrayWithSameAverage_805()
//    println(split.splitArraySameAverage(intArrayOf(1,2,3,4,5,6,7,8)))
//    println(split.splitArraySameAverage(intArrayOf(3,1)))
    // TODO
    println(split.splitArraySameAverage(intArrayOf(60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30)))
}