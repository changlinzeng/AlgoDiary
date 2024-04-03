package algo.backtrack

class KtCoinChange_322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        fun backtrack(coins: IntArray, amount: Int, dp: IntArray): Int {
            if (amount == 0) {
                return 0
            }
            if (amount < 0) {
                return -1;
            }
            if (dp[amount] != 0) {
                return dp[amount]
            }
            var min = Int.MAX_VALUE
            coins.forEach {
                val res = backtrack(coins, amount - it, dp)
                if (res != -1) {
                    dp[amount] = res
                    min = min.coerceAtMost(res + 1)
                }
            }
            dp[amount] = if (min != Int.MAX_VALUE) min else -1
            return dp[amount]
        }

        return if (amount == 0) 0 else backtrack(coins, amount, IntArray(amount + 1))
    }
}

fun main() {
    val coinChange = KtCoinChange_322()
    println(coinChange.coinChange(intArrayOf(1,2,5), 11))
}