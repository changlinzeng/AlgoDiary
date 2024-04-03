package algo.backtrack

class KtCombinationSum_II_40 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val all: MutableList<List<Int>> = mutableListOf()
        fun backtrack(candidates: IntArray, target: Int, start: Int, list: MutableList<Int>) {
            if (target < 0) {
                return
            }
            if (target == 0) {
                all.add(list.toList())
                return
            }
            for (idx in start..<candidates.size) {
                if (idx > start && candidates[idx] == candidates[idx - 1]) {
                    continue
                }
                val remain = target - candidates[idx]
                if (remain >= 0) {
                    list.add(candidates[idx])
                    backtrack(candidates, remain, idx + 1, list)
                    list.removeLast()
                }
            }
        }
        candidates.sort()
        backtrack(candidates, target, 0, mutableListOf())
        return all
    }
}

fun main() {
    val sum2 = KtCombinationSum_II_40()
    println(sum2.combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
}