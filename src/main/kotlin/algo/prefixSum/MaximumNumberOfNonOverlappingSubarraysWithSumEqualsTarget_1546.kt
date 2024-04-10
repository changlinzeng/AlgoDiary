package algo.prefixSum

class KtMaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget_1546 {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        val prefixSum: MutableSet<Int> = mutableSetOf()
        var count = 0
        var sum = 0
        nums.indices.forEach { i ->
            sum += nums[i]
            if (sum == target || prefixSum.contains(sum - target)) {
                count++
                sum = 0
                prefixSum.clear()
            }
            prefixSum.add(sum)
        }
        return count
    }
}

fun main() {
    val subarray = KtMaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget_1546()
    println(subarray.maxNonOverlapping(intArrayOf(1,1,1,1,1), 2))
    println(subarray.maxNonOverlapping(intArrayOf(-1,3,5,1,4,2,-9), 6))
}