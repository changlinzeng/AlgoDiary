package algo.breadthFirstSearch

import java.util.LinkedList

class KtMinimumScoreOfAPathBetweenTwoCities_2492 {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val adjMap: MutableMap<Int, MutableList<IntArray>> = mutableMapOf()
        roads.forEach {
            adjMap.getOrPut(it[0]){ mutableListOf() }.add(intArrayOf(it[1], it[2]))
            adjMap.getOrPut(it[1]){ mutableListOf() }.add(intArrayOf(it[0], it[2]))
        }

        var minCost = Int.MAX_VALUE
        val q = LinkedList<Int>()
        val visited = BooleanArray(n + 1)
        q.offer(1)
        while (q.isNotEmpty()) {
            val city = q.poll()
            if (visited[city]) {
                continue
            }
            visited[city] = true
            adjMap[city]?.forEach {
                minCost = minCost.coerceAtMost(it[1])
                q.offer(it[0])
            }
        }

        return minCost
    }
}

fun main() {
    val minScore = KtMinimumScoreOfAPathBetweenTwoCities_2492()
    println(minScore.minScore(4, arrayOf(intArrayOf(1,2,9), intArrayOf(2,3,6), intArrayOf(2,4,5), intArrayOf(1,4,7))))
}