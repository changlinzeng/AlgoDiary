package algo.backtrack

class KtMatchsticksToSquare_473 {
    fun makesquare(matchsticks: IntArray): Boolean {
        val total = matchsticks.sum()
        if (total % 4 != 0) {
            return false
        }
        val side = total / 4

        fun match(sticks: IntArray, sum: Int, sideNum: Int, bitmask: Int, dp: Array<IntArray>): Int {
            if (sum == total && sideNum == 4) {
                return 1
            }
            if (dp[sideNum][bitmask] != 0) {
                return dp[sideNum][bitmask]
            }
            val sideSum = sum % side
            for (i in sticks.indices) {
                val nextSum = sideSum + sticks[i]
                if (nextSum > side) {
                    continue
                }
                val pos = 1 shl (sticks.size - i)
                if (pos and bitmask != 0) {
                    continue
                }
                val nextSideNum = if (nextSum == side) sideNum + 1 else sideNum
                val res = match(sticks, sum + sticks[i], nextSideNum, pos xor bitmask, dp)
                dp[sideNum][bitmask] = res
                if (res == 1) {
                    break
                }
                dp[sideNum][bitmask] = -1
            }
            return dp[sideNum][bitmask]
        }

        val stateArray = Array(5) { IntArray(1 shl (matchsticks.size + 1)) {0} }
        return match(matchsticks, 0, 0, 0, stateArray) == 1
    }

}

fun main() {
    val matchSticks = KtMatchsticksToSquare_473()
    println(matchSticks.makesquare(intArrayOf(1,1,2,2,2)))
    println(matchSticks.makesquare(intArrayOf(3,3,3,3,4)))
    println(matchSticks.makesquare(intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)))
    println(matchSticks.makesquare(intArrayOf(5969561,8742425,2513572,3352059,9084275,2194427,1017540,2324577,6810719,8936380,7868365,2755770,9954463,9912280,4713511)))
    println(matchSticks.makesquare(intArrayOf(5,5,5,5,16,4,4,4,4,4,3,3,3,3,4)))
}