package algo.twoPointers

class KtRemoveDuplicatesFromSortedArray_II_80 {
    // Use two pointers
    // One pointer iterates the array and count the duplicates
    // The other pointer record the end of the result
    fun removeDuplicates(nums: IntArray): Int {
        val maxDuplicates = 2
        var end = 0
        var count = 1
        for (i in 1..nums.size) {
            if (i == nums.size) {
                val repeats = count.coerceAtMost(maxDuplicates)
                for (k in 1..repeats) {
                    nums[end++] = nums[i - 1]
                }
                break
            }
            if (nums[i] == nums[i - 1]) {
                count++
            } else {
                // write elements to the end
                val repeats = count.coerceAtMost(maxDuplicates)
                for (k in 1..repeats) {
                    nums[end++] = nums[i - 1]
                }
                count = 1
            }
        }
        return end
    }
}

fun main() {
    val remove = KtRemoveDuplicatesFromSortedArray_II_80()
    println(remove.removeDuplicates(intArrayOf(1,1,1,2,2,3)))
    println(remove.removeDuplicates(intArrayOf(0,0,1,1,1,1,2,3,3)))
    println(remove.removeDuplicates(intArrayOf(1,2)))
}