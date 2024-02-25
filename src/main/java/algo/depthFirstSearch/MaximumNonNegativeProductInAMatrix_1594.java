package algo.depthFirstSearch;

public class MaximumNonNegativeProductInAMatrix_1594 {
  private static final int mod = 1_000_000_007;
  private static long maxProduct = -1;
  public static int maxProductPath(int[][] grid) {
    dfs(grid, 0, 0, 1);
    return (int)(maxProduct % mod);
  }

  private static void dfs(int[][] grid, int row, int col, long product) {
    if (grid[row][col] == 0) {
      maxProduct = Math.max(maxProduct, 0);
      return;
    }
    long newProduct = product * grid[row][col];
    if (newProduct > 0 && row == grid.length - 1 && col == grid[0].length - 1) {
      if (newProduct > maxProduct) {
        maxProduct = newProduct;
      }
    }
    if (row + 1 < grid.length) {
      dfs(grid, row + 1, col, newProduct);
    }
    if (col + 1 < grid[0].length) {
      dfs(grid, row, col + 1, newProduct);
    }
  }

  public static void main(String[] args) {
    System.out.println(maxProductPath(new int[][]{{-1,-2,-3}, {-2,-3,-3}, {-3,-3,-2}}));
    System.out.println(maxProductPath(new int[][]{{1,-2,1}, {1,-2,1}, {3,-4,1}}));
    System.out.println(maxProductPath(new int[][]{{-1,-4, 2},
                                                  {4, 3, -1},
                                                  {2, -4, 4},
                                                  {1, -1,-4}}));
  }
}
