package algo.depthFirstSearch

class KtLongestIncreasingPathInAMatrix_329 {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        fun dfs(matrix: Array<IntArray>, row: Int, col: Int, dp: Array<IntArray>, visited: Array<BooleanArray>): Int {
            val rows = matrix.size; val cols = matrix[0].size
            val current = matrix[row][col]
            if (visited[row][col]) {
                return dp[row][col]
            }
            visited[row][col] = true
            if (dp[row][col] != 0) {
                return dp[row][col]
            }
            var maxLen = 0
            if (row + 1 < rows && matrix[row + 1][col] > current) {
                maxLen = maxLen.coerceAtLeast(dfs(matrix, row + 1, col, dp, visited))
            }
            if (row - 1 >= 0 && matrix[row - 1][col] > current) {
                maxLen = maxLen.coerceAtLeast(dfs(matrix, row - 1, col, dp, visited))
            }
            if (col + 1 < cols && matrix[row][col + 1] > current) {
                maxLen = maxLen.coerceAtLeast(dfs(matrix, row, col + 1, dp, visited))
            }
            if (col - 1 >= 0 && matrix[row][col - 1] > current) {
                maxLen = maxLen.coerceAtLeast(dfs(matrix, row, col - 1, dp, visited))
            }
            maxLen++
            dp[row][col] = maxLen
            return dp[row][col]
        }
        var longest = 1
        val dp = Array(matrix.size){ IntArray(matrix[0].size){0} }
        matrix.indices.forEach { i ->
            matrix[i].indices.forEach { j ->
                longest = longest.coerceAtLeast(dfs(matrix, i, j, dp, Array(matrix.size){BooleanArray(matrix[0].size)}))
            }
        }
        return longest
    }
}

fun main() {
    val increasing = KtLongestIncreasingPathInAMatrix_329()
    println(increasing.longestIncreasingPath(arrayOf(intArrayOf(3,4,5), intArrayOf(3,2,6), intArrayOf(2,2,1))))
}