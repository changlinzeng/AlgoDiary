package algo.depthFirstSearch

class KtFrogJump_403 {
    fun canCross(stones: IntArray): Boolean {
        fun cross(stones: IntArray, position: Int, prevJump: Int, dp: Array<IntArray>): Boolean {
            if (position >= stones.size - 1) {
                return true
            }
            if (dp[prevJump][position] != 0) {
                return dp[prevJump][position] == 1
            }
            intArrayOf(prevJump - 1, prevJump, prevJump + 1).filter { it > 0 }.forEach {
                val next = stones[position] + it
                for (i in position..<stones.size) {
                    if (stones[i] == next) {
                        if (cross(stones, i, it, dp)) {
                            dp[it][i] = 1
                            return true
                        }
                        dp[it][i] = -1
                    }
                }
            }
            return false
        }

        return cross(stones, 0, 0, Array(stones.size){ IntArray(stones.size) })
    }
}

fun main() {
    val frog = KtFrogJump_403()
    println(frog.canCross(intArrayOf(0,1,3,5,6,8,12,17)))
    println(frog.canCross(intArrayOf(0,1,2,3,4,8,9,11)))
}