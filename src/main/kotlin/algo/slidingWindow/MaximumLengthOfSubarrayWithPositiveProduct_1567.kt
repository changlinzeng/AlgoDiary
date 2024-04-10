package algo.slidingWindow

class KtMaximumLengthOfSubarrayWithPositiveProduct_1567 {
    fun getMaxLen(nums: IntArray): Int {
        // there must be even number of negative numbers if we want the product to be positive
        var maxLen = 0
        var firstNeg = -1; var lastNeg = -1; var negCount = 0
        var start = 0
        nums.indices.forEach { i ->
            if (nums[i] < 0) {
                negCount++
                if (firstNeg == -1) {
                    firstNeg = i
                }
                lastNeg = i
            }
            if (nums[i] == 0) {
                if (i > 0 && nums[i - 1] != 0) {
                    //check subarray from start to i
                    if (negCount % 2 == 0) {
                        maxLen = maxLen.coerceAtLeast(i - start)
                    } else {
                        val max = (i - firstNeg - 1).coerceAtLeast(lastNeg - start)
                        maxLen = maxLen.coerceAtLeast(max)
                    }
                    firstNeg = -1
                    lastNeg = -1
                    negCount = 0
                }
                start = i + 1
            } else if (i == nums.size - 1) {
                if (negCount % 2 == 0) {
                    maxLen = maxLen.coerceAtLeast(i - start + 1)
                } else {
                    val max = (i - firstNeg).coerceAtLeast(lastNeg - start)
                    maxLen = maxLen.coerceAtLeast(max)
                }
            }
        }
        return maxLen
    }
}

fun main() {
    val subarray = KtMaximumLengthOfSubarrayWithPositiveProduct_1567()
    println(subarray.getMaxLen(intArrayOf(1,-2,-3,4)))
    println(subarray.getMaxLen(intArrayOf(0,1,-2,-3,-4)))
    println(subarray.getMaxLen(intArrayOf(-1,-2,-3,0,1)))
    println(subarray.getMaxLen(intArrayOf(1,2,3,5,-6,4,0,10)))
}