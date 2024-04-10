package algo.sequence

class KtNextPermutation_31 {
    fun nextPermutation(nums: IntArray): Unit {
        // find the peak backward from end and then swap the peak element with prev one
        // and then make it ascending from peak to end
        var peak = nums.size - 1
        while (peak > 0 && nums[peak - 1] >= nums[peak]) {
            peak--
        }

        // sequence is in descending order so return the reverse
        if (peak == 0) {
            reverse(nums, 0, nums.size - 1)
            return
        }

        // find the smallest element that is greater than nums[peak - 1] and swap
        // and then make it ascending from peak to end
        var i = peak
        while (i < nums.size && nums[i] > nums[peak - 1]) {
            i++
        }
        val tmp = nums[peak - 1]
        nums[peak - 1] = nums[i - 1]
        nums[i - 1] = tmp

        reverse(nums, peak, nums.size - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int): Unit {
        var i = start; var j = end
        var tmp: Int
        while (i < j) {
            tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            i++
            j--
        }
    }
}

fun main() {
    val next = KtNextPermutation_31()
//    val arr = intArrayOf(1,2,3)
    val arr = intArrayOf(1,3,2)
    next.nextPermutation(arr)
    println(arr.toList())
}