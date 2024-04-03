package algo.backtrack

class KtSubsets_II_90 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val all: MutableList<List<Int>> = mutableListOf()
        nums.sort()
        fun backtrack(nums: IntArray, start: Int, list: MutableList<Int>) {
            all.add(list.toList())
            for (i in start..<nums.size) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue
                }
                list.add(nums[i])
                backtrack(nums, i + 1, list)
                list.removeLast()
            }
        }
        backtrack(nums, 0, mutableListOf())
        return all
    }
}

fun main() {
    val subset = KtSubsets_II_90()
    println(subset.subsetsWithDup(intArrayOf(1,2,2)))
    println(subset.subsetsWithDup(intArrayOf(0)))
}