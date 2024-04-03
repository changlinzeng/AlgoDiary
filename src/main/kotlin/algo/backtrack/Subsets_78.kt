package algo.backtrack

class KtSubsets_78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val all: MutableList<List<Int>> = mutableListOf()
        fun backtrack(nums: IntArray, start: Int, list: MutableList<Int>) {
            all.add(list.toList())
            for (i in start..<nums.size) {
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
    val subset = KtSubsets_78()
    println(subset.subsets(intArrayOf(1,2,3)))
    println(subset.subsets(intArrayOf(0)))
}