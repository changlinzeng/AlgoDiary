package algo.backtrack

class KtCombinationSum_39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val combinations: MutableList<List<Int>> = mutableListOf()
        fun backtrack(candidates: IntArray, target: Int, list: MutableList<Int>) {
            candidates.forEach {
                val remain = target - it
                if (remain >= 0) {
                    list.add(it)
                    val sorted = list.sorted()
                    if (remain == 0) {
                        if (combinations.none { lst -> lst == sorted }) {
                            combinations.add(sorted)
                        }
                    } else {
                        backtrack(candidates, remain, list)
                    }
                    list.removeLast()
                }
            }
        }

        backtrack(candidates, target, mutableListOf())
        return combinations
    }

}

fun main() {
    val comSum = KtCombinationSum_39()
    println(comSum.combinationSum(intArrayOf(2,3,6,7), 7))
    println(comSum.combinationSum(intArrayOf(2,3,5), 8))
    println(comSum.combinationSum(intArrayOf(7,3,2), 18))
}