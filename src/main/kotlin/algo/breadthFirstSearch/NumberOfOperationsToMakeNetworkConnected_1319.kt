package algo.breadthFirstSearch

import java.util.LinkedList

class KtNumberOfOperationsToMakeNetworkConnected_1319 {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        val adjMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        connections.forEach {
            adjMap.getOrPut(it[0]) { mutableListOf() }.add(it[1])
            adjMap.getOrPut(it[1]) { mutableListOf() }.add(it[0])
        }

        // count how many islands
        val visited = BooleanArray(n)
        var islands = 0
        for (i in 0..<n) {
            if (!visited[i]) {
                islands++
                bfs(adjMap, i, visited)
            }
        }

        val edgeNum = connections.size
        if (edgeNum < n - 1) {
            return -1
        }
        return islands - 1
    }

    private fun bfs(adjMap: MutableMap<Int, MutableList<Int>>, node: Int, visited: BooleanArray) {
        val q = LinkedList<Int>()
        q.offer(node)
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 1..size) {
                val e = q.poll()
                if (visited[e]) {
                    continue
                }
                visited[e] = true
                adjMap[e]?.forEach { q.offer(it) }
            }
        }
    }
}

fun main() {
    val ops = KtNumberOfOperationsToMakeNetworkConnected_1319()
//    println(ops.makeConnected(4, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2))))
    println(ops.makeConnected(11, arrayOf(intArrayOf(1,4), intArrayOf(0,3), intArrayOf(1,3), intArrayOf(3,7), intArrayOf(2,7), intArrayOf(0,1), intArrayOf(2,4), intArrayOf(3,6), intArrayOf(5,6), intArrayOf(6,7), intArrayOf(4,7), intArrayOf(0,7), intArrayOf(5,7))))
}