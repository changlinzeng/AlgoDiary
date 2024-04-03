package algo.backtrack

class KtCombinationSum_III_216 {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val all: MutableList<List<Int>> = mutableListOf()
        fun backtrack(k: Int, sum: Int, start: Int, list: MutableList<Int>) {
            if (sum < 0) {
                return
            }
            if (k == 0 && sum == 0) {
                all.add(list.toList())
                return
            }
            for (num in start..9) {
                val remain = sum - num
                if (remain >= 0) {
                    list.add(num)
                    backtrack(k - 1, remain, num + 1, list)
                    list.removeLast()
                }
            }
        }
        backtrack(k, n, 1, mutableListOf())
        return all
    }
}

fun main() {
    val sum3 = KtCombinationSum_III_216()
    println(sum3.combinationSum3(3, 7))
    println(sum3.combinationSum3(3, 9))
}