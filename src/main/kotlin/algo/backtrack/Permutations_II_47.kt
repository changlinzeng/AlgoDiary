package algo.backtrack

class KtPermutations_II_47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val all: MutableList<List<Int>> = mutableListOf()
        nums.sort()
        fun backtrack(nums: IntArray, list: MutableList<Int>, visited: BooleanArray) {
            if (list.size == nums.size) {
                all.add(list.toList())
                return
            }
            nums.indices.filter { !visited[it] }.forEach {
                // skip current duplicate if previous is not picked up as we backtrack one by one
                // only the previous is picked up, we can backtrack current one
                if (it == 0 || nums[it] != nums[it - 1] || visited[it - 1]) {
                    visited[it] = true
                    list.add(nums[it])
                    backtrack(nums, list, visited)
                    visited[it] = false
                    list.removeLast()
                }
            }
        }

        backtrack(nums, mutableListOf(), BooleanArray(nums.size))
        return all
    }
}

fun main() {
    val uperm = KtPermutations_II_47()
    println(uperm.permuteUnique(intArrayOf(1,1,2)))
    println(uperm.permuteUnique(intArrayOf(1,2,3)))
}