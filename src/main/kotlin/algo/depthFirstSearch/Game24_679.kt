package algo.depthFirstSearch

import kotlin.math.absoluteValue

class KtGame24_679 {
    companion object {
        const val MIN: Double = 1e-6
    }
    fun judgePoint24(cards: IntArray): Boolean {
        fun dfs(cards: MutableList<Double>): Boolean {
            if (cards.size == 1 && cards[0] == 24.0) {
                return true
            }
            cards.indices.forEach { i ->
                for (j in 0..<i) {
                    val m = cards[i]
                    val n = cards[j]
                    val next: MutableList<Double> = mutableListOf(m + n, m - n, n - m, m * n)
                    if (m.absoluteValue > MIN) {
                        next.add(n / m)
                    }
                    if (n.absoluteValue > MIN) {
                        next.add(m / n)
                    }

                    cards.removeAt(i)
                    cards.removeAt(j)
                    next.forEach {
                        cards.add(it)
                        if (dfs(cards)) {
                            return true
                        }
                        cards.removeLast()
                    }
                    cards.add(j, n)
                    cards.add(i, m)
                }
            }
            return false
        }

        val list = cards.map { it.toDouble() }.toMutableList()
        return dfs(list)
    }
}

fun main() {
    val game = KtGame24_679()
//    println(game.judgePoint24(intArrayOf(4,1,8,7)))
//    println(game.judgePoint24(intArrayOf(1,2,1,2)))
    // TODO
    println(game.judgePoint24(intArrayOf(3,3,8,8)))
}