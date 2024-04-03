package algo.depthFirstSearch

import java.util.LinkedList

class KtIsGraphBipartite_785 {
    companion object {
        const val BLACK = -1
        const val RED = 1
        const val NONE = 0
    }
    fun isBipartite(graph: Array<IntArray>): Boolean {
        fun bfs(graph: Array<IntArray>, node: Int, color: IntArray): Boolean {
            val q = LinkedList<Int>()
            q.offer(node)
            color[node] = BLACK
            while (q.isNotEmpty()) {
                val size = q.size
                for (i in 1..size) {
                    val n = q.poll()
                    graph[n].forEach {
                        when (color[it]) {
                            color[n] -> return false
                            NONE -> {
                                color[it] = -1 * color[n]
                                q.offer(it)
                            }
                        }
                    }
                }
            }
            return true
        }

        val color = IntArray(graph.size)
        graph.indices.forEach {
            if (color[it] == NONE && !bfs(graph, it, color)) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val bipartite = KtIsGraphBipartite_785()
    println(bipartite.isBipartite(arrayOf(intArrayOf(1,2,3), intArrayOf(0,2), intArrayOf(0,1,3), intArrayOf(0,2))))
    println(bipartite.isBipartite(arrayOf(intArrayOf(1,3), intArrayOf(0,2), intArrayOf(1,3), intArrayOf(0,2))))
}