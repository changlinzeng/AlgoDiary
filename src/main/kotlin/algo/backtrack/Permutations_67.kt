package algo.backtrack

class KtPermutations_67 {
    fun permute(nums: IntArray): List<List<Int>> {
        val all: MutableList<List<Int>> = mutableListOf()
        fun backtrack(nums: IntArray, list: MutableList<Int>, visited: BooleanArray) {
            if (list.size == nums.size) {
                all.add(list.toList())
                return
            }
            for (i in nums.indices) {
                if (visited[i]) {
                    continue
                }
                visited[i] = true
                list.add(nums[i])
                backtrack(nums, list, visited)
                visited[i] = false
                list.removeLast()
            }
        }
        backtrack(nums, mutableListOf(), BooleanArray(nums.size))
        return all
    }
}

fun main() {
    val permute = KtPermutations_67()
    println(permute.permute(intArrayOf(1,2,3)))
    println(permute.permute(intArrayOf(0,1)))
    println(permute.permute(intArrayOf(1)))
}