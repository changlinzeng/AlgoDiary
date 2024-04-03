package algo.breadthFirstSearch

import java.util.LinkedList

class KtPossibleBipartition_886 {
    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        fun bfs(adjMap: MutableMap<Int, MutableList<Int>>, node: Int, color: IntArray): Boolean {
            // this person does dislike anyone
            if (!adjMap.containsKey(node)) {
                return true
            }

            val q = LinkedList<Int>()
            q.offer(node)
            color[node] = -1
            while (q.isNotEmpty()) {
                val e = q.poll()
                adjMap[e]?.forEach {
                    // parent and child have the same color
                    if (color[it] == color[e]) {
                        return false
                    }
                    if (color[it] == 0) {
                        color[it] = -1 * color[e]
                        q.offer(it)
                    }
                }
            }
            return true
        }

        val adjMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        dislikes.forEach {
            adjMap.getOrPut(it[0]) { mutableListOf() }.add(it[1])
            adjMap.getOrPut(it[1]) { mutableListOf() }.add(it[0])
        }

        val color = IntArray(n + 1)
        color.indices.forEach {
            if (color[it] == 0) {
                if (!bfs(adjMap, it, color)) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    val partition = KtPossibleBipartition_886()
    println(partition.possibleBipartition(4, arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,4))))
    println(partition.possibleBipartition(3, arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,3))))
}