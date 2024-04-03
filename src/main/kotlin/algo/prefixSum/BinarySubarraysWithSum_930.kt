package algo.prefixSum

class KtBinarySubarraysWithSum_930 {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        val sums: MutableMap<Int, Int> = mutableMapOf()  // sum -> number of sums
        var sum = 0
        var count = 0
        nums.indices.forEach { idx ->
            val num = nums[idx]
            sum += num
            if (sum == goal) {
                count++
            }
            sums[sum - goal]?.also { count += it }
            sums[sum] = sums.getOrDefault(sum, 0) + 1
        }
        return count
    }
}

fun main() {
    val subarray = KtBinarySubarraysWithSum_930()
    println(subarray.numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2))
    println(subarray.numSubarraysWithSum(intArrayOf(0,0,0,0,0), 0))
    println(subarray.numSubarraysWithSum(intArrayOf(0,1,1,1,1), 3))
    println(subarray.numSubarraysWithSum(intArrayOf(0,0,0,0,0,0,1,0,0,0), 0))
}