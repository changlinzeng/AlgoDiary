package algo.dp;

import java.util.Arrays;

public class Matrix01Matrix_542 {
  public static int[][] updateMatrix(int[][] mat) {
    int rows = mat.length, cols = mat[0].length;
    var dp = new int[rows][cols];
    for (var row : dp) {
      Arrays.fill(row, rows + cols);
    }
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (mat[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          if (i - 1 >= 0) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
          }
          if (j - 1 >= 0) {
            dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
          }
        }
      }
    }
    for (var i = rows - 1; i >= 0; i--) {
      for (var j = cols - 1; j >= 0; j--) {
        if (i + 1 < rows) {
          dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
        }
        if (j + 1 < cols) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
        }
      }
    }
    return dp;
  }

  public static void main(String[] args) {
    Arrays.stream(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})).map(Arrays::toString).forEach(System.out::println);
  }
}
