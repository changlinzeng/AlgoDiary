package algo.depthFirstSearch;

public class LongestIncreasingPathInAMatrix_329 {
  public static int longestIncreasingPath(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    var dp = new int[rows][cols];  // record the max increasing path from [i][j]
    var visited = new boolean[rows][cols];
    var max = 0;
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (!visited[i][j]) {
          max = Math.max(max, dfs(matrix, i, j, dp, visited));
        }
      }
    }
    return max;
  }

  private static int dfs(int[][] matrix, int row, int col, int[][] dp, boolean[][] visited) {
    if (visited[row][col]) {
      return dp[row][col];
    }
    if (dp[row][col] != 0) {
      visited[row][col] = true;
      return dp[row][col];
    }
    visited[row][col] = true;
    var val = matrix[row][col];
    var maxLen = 0;
    if (row + 1 < matrix.length && matrix[row + 1][col] > val) {
      maxLen = dfs(matrix, row + 1, col, dp, visited);
    }
    if (row - 1 >= 0 && matrix[row - 1][col] > val) {
      maxLen = Math.max(maxLen, dfs(matrix, row - 1, col, dp, visited));
    }
    if (col + 1 < matrix[0].length && matrix[row][col + 1] > val) {
      maxLen = Math.max(maxLen, dfs(matrix, row, col + 1, dp, visited));
    }
    if (col - 1 >= 0 && matrix[row][col - 1] > val) {
      maxLen = Math.max(maxLen, dfs(matrix, row, col - 1, dp, visited));
    }
    maxLen++;
    dp[row][col] = maxLen;
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    System.out.println(longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
    System.out.println(longestIncreasingPath(new int[][]{{1}}));
  }
}
