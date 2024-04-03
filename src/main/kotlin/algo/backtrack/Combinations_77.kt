package algo.backtrack

class KtCombinations_77 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        fun backtrack(n: Int, k: Int, start: Int, all: MutableList<List<Int>>, combination: MutableList<Int>) {
            if (k == 0) {
                all.add(combination.toList())
            }
            for (i in start..n) {
                combination.add(i)
                backtrack(n, k - 1, i + 1, all, combination)
                combination.removeLast()
            }
        }

        val combinations: MutableList<List<Int>> = mutableListOf()
        backtrack(n, k, 1, combinations, mutableListOf())
        return combinations
    }
}

fun main() {
    val combinations = KtCombinations_77()
    println(combinations.combine(4, 2))
}