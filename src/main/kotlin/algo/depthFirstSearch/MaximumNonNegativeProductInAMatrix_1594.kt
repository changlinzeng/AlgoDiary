package algo.depthFirstSearch

class KtMaximumNonNegativeProductInAMatrix_1594 {
    fun maxProductPath(grid: Array<IntArray>): Int {
        val mod = 1_000_000_007
        var maxProduct: Long = Long.MIN_VALUE
        fun dfs(grid: Array<IntArray>, row: Int, col: Int, product: Long) {
            val rows = grid.size; val cols = grid[0].size
            val current = grid[row][col]
            if (current == 0) {
                maxProduct = maxProduct.coerceAtLeast(0)
                return
            }
            val nextProduct = product * current
            if (row == rows - 1 && col == cols - 1) {
                maxProduct = maxProduct.coerceAtLeast(nextProduct)
                return
            }
            if (row + 1 < rows) {
                dfs(grid, row + 1, col, nextProduct)
            }
            if (col + 1 < cols) {
                dfs(grid, row, col + 1, nextProduct)
            }
        }
        dfs(grid, 0, 0, 1)
        return if (maxProduct >= 0) (maxProduct % mod).toInt() else -1
    }
}

fun main() {
    val product = KtMaximumNonNegativeProductInAMatrix_1594()
    println(product.maxProductPath(arrayOf(intArrayOf(1,-2,1), intArrayOf(1,-2,1), intArrayOf(3,-4,1))))
}