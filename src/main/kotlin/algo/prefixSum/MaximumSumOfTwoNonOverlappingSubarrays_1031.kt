package algo.prefixSum

class KtMaximumSumOfTwoNonOverlappingSubarrays_1031 {
    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        val prefixSum = IntArray(nums.size + 1)
        var sum = 0
        nums.indices.forEach { idx ->
            sum += nums[idx]
            prefixSum[idx + 1] = sum
        }
        return maxSum(prefixSum, firstLen, secondLen).coerceAtLeast(maxSum(prefixSum, secondLen, firstLen))
    }

    private fun maxSum(prefixSum: IntArray, firstLen: Int, secondLen: Int): Int {
        var mid = firstLen  // mid divides the array into two parts
        var maxSum = 0
        while (mid < prefixSum.size - secondLen) {
            // find max sum in first part
            var lsum = 0
            for (i in firstLen..mid) {
                lsum = lsum.coerceAtLeast(prefixSum[i] - prefixSum[i - firstLen])
            }
            // find max sum in second part
            var rsum = 0
            for (i in mid + secondLen..<prefixSum.size) {
                rsum = rsum.coerceAtLeast(prefixSum[i] - prefixSum[i - secondLen])
            }
            maxSum = maxSum.coerceAtLeast(lsum + rsum)
            mid++
        }
        return maxSum
    }
}

fun main() {
    val overlap = KtMaximumSumOfTwoNonOverlappingSubarrays_1031()
    println(overlap.maxSumTwoNoOverlap(intArrayOf(0,6,5,2,2,5,1,9,4), 2, 1))
    println(overlap.maxSumTwoNoOverlap(intArrayOf(3,8,1,3,2,1,8,9,0), 3, 2))
}