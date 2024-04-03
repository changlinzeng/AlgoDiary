package algo.depthFirstSearch

class KtNumberOfClosedIslands_1254 {
    fun closedIsland(grid: Array<IntArray>): Int {
        fun bfs(grid: Array<IntArray>, row: Int, col: Int, visited: Array<BooleanArray>): Int {
            val cell = grid[row][col]
            if (visited[row][col] || cell == 1) {
                return 1
            }
            val rows = grid.size; val cols = grid[0].size
            visited[row][col] = true
            val reachBorder = row == rows - 1 || col == cols - 1 || row == 0 || col == 0
            var count = 0
            if (row + 1 < rows) {
                count += bfs(grid, row + 1, col, visited)
            }
            if (row > 0) {
                count += bfs(grid, row - 1, col, visited)
            }
            if (col + 1 < cols) {
                count += bfs(grid, row, col + 1, visited)
            }
            if (col > 0) {
                count += bfs(grid, row, col - 1, visited)
            }
            return if (reachBorder || count < 4) 0 else 1
        }

        var num = 0
        val rows = grid.size; val cols = grid[0].size
        val visited = Array(rows) { BooleanArray(cols) }
        grid.indices.forEach { row ->
            grid[0].indices.forEach { col ->
                if (grid[row][col] == 0 && !visited[row][col]) {
                    num += bfs(grid, row, col, visited)
                }
            }
        }
        return num
    }
}