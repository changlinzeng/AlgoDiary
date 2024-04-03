package algo.depthFirstSearch

class KtReachableNodesWithRestrictions_2368 {
    fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
        fun dfs(adjMap: Map<Int, List<Int>>, node: Int, restricted: IntArray, visited: BooleanArray): Int {
            if (visited[node]) {
                return 0
            }
            visited[node] = true
            var count = 1
            adjMap[node]?.forEach {
                if (!restricted.contains(it)) {
                    count += dfs(adjMap, it, restricted, visited)
                }
            }
            return count
        }
        val adjMap = HashMap<Int, MutableList<Int>>()
        edges.forEach {
            adjMap.getOrPut(it[0]) { mutableListOf() }.add(it[1])
            adjMap.getOrPut(it[1]) { mutableListOf() }.add(it[0])
        }

        return dfs(adjMap, 0, restricted, BooleanArray(n))
    }
}

fun main() {
    val reach = KtReachableNodesWithRestrictions_2368()
    println(reach.reachableNodes(7, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(3,1), intArrayOf(4,0), intArrayOf(0,5), intArrayOf(5,6)), intArrayOf(4,5)))
}