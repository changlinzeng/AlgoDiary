package algo.breadthFirstSearch

import java.util.LinkedList

class KtRottingOranges_994 {
    companion object {
        const val FRESH = 1
        const val ROTTEN = 2
    }
    fun orangesRotting(grid: Array<IntArray>): Int {
        fun bfs(grid: Array<IntArray>): Int {
            var time = 0
            val visited = Array(grid.size) { BooleanArray(grid[0].size) }
            val q = LinkedList<IntArray>()
            for (row in grid.indices) {
                for (col in grid[0].indices) {
                    // init rotten oranges
                    if (grid[row][col] == ROTTEN) {
                        q.offer(intArrayOf(row, col))
                        visited[row][col] = true
                    }
                }
            }
            while (q.isNotEmpty()) {
                val size = q.size
                for (i in 1..size) {
                    val cell = q.poll()
                    val (m, n) = cell
                    grid[m][n] = ROTTEN
                    if (m + 1 < grid.size && grid[m + 1][n] == FRESH && !visited[m + 1][n]) {
                        q.offer(intArrayOf(m + 1, n))
                        visited[m + 1][n] = true
                    }
                    if (m - 1 >= 0 && grid[m - 1][n] == FRESH && !visited[m - 1][n]) {
                        q.offer(intArrayOf(m - 1, n))
                        visited[m - 1][n] = true
                    }
                    if (n + 1 < grid[0].size && grid[m][n + 1] == FRESH && !visited[m][n + 1]) {
                        q.offer(intArrayOf(m, n + 1))
                        visited[m][n + 1] = true
                    }
                    if (n - 1 >= 0 && grid[m][n - 1] == FRESH && !visited[m][n - 1]) {
                        q.offer(intArrayOf(m, n - 1))
                        visited[m][n - 1] = true
                    }
                }
                time++
            }
            return (time - 1).coerceAtLeast(0)
        }

        val time = bfs(grid)
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                // fresh orange found
                if (grid[row][col] == FRESH) {
                    return -1
                }
            }
        }
        return time
    }
}

fun main() {
    val rotting = KtRottingOranges_994()
    println(rotting.orangesRotting(arrayOf(intArrayOf(2,1,1), intArrayOf(1,1,0), intArrayOf(0,1,1))))
    println(rotting.orangesRotting(arrayOf(intArrayOf(2,2), intArrayOf(1,1), intArrayOf(0,0), intArrayOf(0,2))))
}