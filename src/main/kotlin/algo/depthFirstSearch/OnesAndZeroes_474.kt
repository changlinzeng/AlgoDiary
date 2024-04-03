package algo.depthFirstSearch

class KtOnesAndZeroes_474 {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        fun dfs(strs: Array<String>, m: Int, n: Int, index: Int, dp: Array<Array<IntArray>>): Int {
            if (index >= strs.size) {
                return 0
            }
            if (dp[index][m][n] != -1) {
                return dp[index][m][n]
            }
            val countOne = strs[index].count { it == '1' }
            val countZero = strs[index].length - countOne
            val max = if (m >= countZero && n >= countOne) {
                // if we pick this one
                val c1 = 1 + dfs(strs, m - countZero, n - countOne, index + 1, dp)
                // if we skip this one
                val c2 = dfs(strs, m, n, index + 1, dp)
                c1.coerceAtLeast(c2)
            } else {
                // not able to pick this one
                dfs(strs, m, n, index + 1, dp)
            }
            dp[index][m][n] = max
            return max
        }

        val dp = Array(strs.size) {Array(m + 1) {IntArray(n + 1) {-1} } }
        return dfs(strs, m, n, 0, dp)
    }
}

fun main() {
    val one = KtOnesAndZeroes_474()
    println(one.findMaxForm(arrayOf("10","0001","111001","1","0"), 5, 3))
}