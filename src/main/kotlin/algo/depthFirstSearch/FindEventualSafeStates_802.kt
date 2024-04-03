package algo.depthFirstSearch

class KtFindEventualSafeStates_802 {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val adjMap: MutableMap<Int, MutableList<Int>> = HashMap()
        graph.indices.forEach { idx ->
            val sibling = adjMap.getOrPut(idx) { mutableListOf() }
            graph[idx].forEach { sibling.add(it) }
        }
        return eventualSafeNodesDfs(graph.size, adjMap)
    }

    private fun eventualSafeNodesDfs(n: Int, adjMap: Map<Int, List<Int>>): List<Int> {
        // check if there is circle
        fun dfs(adjMap: Map<Int, List<Int>>, node: Int, color: IntArray, dp: IntArray): Boolean {
            if (adjMap[node]!!.isEmpty()) {
                return true
            }
            if (dp[node] != 0) {
                return dp[node] == 1
            }
            if (color[node] == -1) {
                return false
            }
            color[node] = -1
            adjMap[node]?.forEach {
                if (!dfs(adjMap, it, color, dp)) {
                    dp[node] = -1
                    return false
                }
            }
            dp[node] = 1
            color[node] = 1
            return true
        }

        val safe: MutableList<Int> = mutableListOf()
        for (i in 0..<n) {
            if (dfs(adjMap, i, IntArray(n), IntArray(n))) {
                safe.add(i)
            }
        }
        return safe
    }
}

fun main() {
    val safe = KtFindEventualSafeStates_802()
    println(safe.eventualSafeNodes(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(5), intArrayOf(0), intArrayOf(5), intArrayOf(), intArrayOf())))
    println(safe.eventualSafeNodes(arrayOf(intArrayOf(1,2,3,4), intArrayOf(1,2), intArrayOf(3,4), intArrayOf(0,4), intArrayOf())))
}