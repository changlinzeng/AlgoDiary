package algo.dp;

public class MaximalSquare_221 {
  public int maximalSquare(char[][] matrix) {
    int maxLen = 0, rows = matrix.length, cols = matrix[0].length;
    var dp = new int[rows][cols];
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = 1;
          if (i > 0 && j > 0 && dp[i - 1][j - 1] > 0) {
            int m = 0, n = 0;
            while (m <= dp[i - 1][j - 1] && matrix[i - m][j] == '1') {
              m++;
            }
            while (n <= dp[i - 1][j - 1] && matrix[i][j - n] == '1') {
              n++;
            }
            dp[i][j] = Math.min(m, n);
          }
        }
        maxLen = Math.max(maxLen, dp[i][j]);
      }
    }
    return maxLen * maxLen;
  }
}
