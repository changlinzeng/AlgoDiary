package algo.backtrack

class KtGenerateParenthesis_22 {
    fun generateParenthesis(n: Int): List<String> {
        val paren: MutableList<String> = mutableListOf()
        fun backtrack(leftCount: Int, rightCount: Int, str: String) {
            if (leftCount == 0 && rightCount == 0) {
                paren.add(str)
                return
            }
            if (leftCount == 0) {
                if (rightCount > 0) {
                    backtrack(leftCount, rightCount - 1, "$str)")
                }
            } else {
                backtrack(leftCount - 1, rightCount, "$str(")
                // right paren should not exceed left paren
                if (rightCount > leftCount) {
                    backtrack(leftCount, rightCount - 1, "$str)")
                }
            }
        }
        backtrack(n, n, "")
        return paren
    }
}

fun main() {
    val gen = KtGenerateParenthesis_22()
    println(gen.generateParenthesis(1))
    println(gen.generateParenthesis(2))
    println(gen.generateParenthesis(3))
}