package algo.backtrack

class KtNonDecreasingSubsequences_491 {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val all: MutableSet<List<Int>> = mutableSetOf()
        fun backtrack(nums: IntArray, start: Int, list: MutableList<Int>) {
            if (list.size > 1) {
                all.add(list.toList())
            }
            for (i in start..<nums.size) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue
                }
                if (list.isEmpty() || nums[i] >= list.last()) {
                    list.add(nums[i])
                    backtrack(nums, i + 1, list)
                    list.removeLast()
                }
            }
        }
        backtrack(nums, 0, mutableListOf())
        return all.toList()
    }
}

fun main() {
    val sub = KtNonDecreasingSubsequences_491()
    println(sub.findSubsequences(intArrayOf(4,6,7,7)))
}