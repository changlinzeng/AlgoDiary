package algo.depthFirstSearch

import algo.breadthFirstSearch.KtNumberOfOperationsToMakeNetworkConnected_1319

class KtNumbereOfWaysToReachAPositionAfterExactlyKSteps_2400 {
    companion object {
        const val offset = 1000
        const val mod = 1_000_000_007
    }
    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        return dfs(startPos, endPos, k, Array(k + 1){IntArray(3000) {-1} }).toInt()
    }

    fun dfs(currentPos: Int, endPos: Int, k: Int, dp: Array<IntArray>): Long {
        if (k == endPos - currentPos) {
            return 1
        }
        if (k == 0) {
            return if (currentPos == endPos) 1 else 0
        }
        // in case currentPos is negative, we add 999 to currentPos
        if (dp[k][currentPos + offset] != -1) {
            return dp[k][currentPos + offset].toLong()
        }
        val s1: Long = dfs(currentPos + 1, endPos, k - 1, dp)
        val s2: Long = dfs(currentPos - 1, endPos, k - 1, dp)
        val ways = (s1 + s2) % mod
        dp[k][currentPos + offset] = ways.toInt()
        return ways
    }
}

fun main() {
    val reachPosition = KtNumbereOfWaysToReachAPositionAfterExactlyKSteps_2400()
//    println(reachPosition.numberOfWays(1,2,3))
//    println(reachPosition.numberOfWays(2,5,10))
//    println(reachPosition.numberOfWays(1,1000,999))
    println(reachPosition.numberOfWays(989,1000,99))
}