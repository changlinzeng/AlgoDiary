package algo.twoPointers

class KtShortestUnsortedContinuousSubarray_581 {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val len = nums.size
        var low = 0; var high = len - 1

        // find increasing sequence from left
        while (low < len - 1 && nums[low] <= nums[low + 1]) {
            low++
        }
        // already sorted
        if (low == len - 1) {
            return 0
        }

        // find decreasing sequence from right
        while (high > 0 && nums[high] >= nums[high - 1]) {
            high--
        }

        // find min/max from low to high
        var min = nums[low]; var max = nums[high]
        for (i in low..high) {
            min = min.coerceAtMost(nums[i])
            max = max.coerceAtLeast(nums[i])
        }

        // find the lower bound
        while (low >= 0 && nums[low] > min) {
            low--;
        }

        // find the upper bound
        while (high < len && nums[high] < max) {
            high++
        }

        return high - low - 1
    }
}

fun main() {
    val unsorted = KtShortestUnsortedContinuousSubarray_581()
    println(unsorted.findUnsortedSubarray(intArrayOf(2,6,4,8,10,9,15)))
}