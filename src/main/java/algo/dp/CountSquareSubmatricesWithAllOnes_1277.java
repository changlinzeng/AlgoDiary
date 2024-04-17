package algo.dp;

public class CountSquareSubmatricesWithAllOnes_1277 {
  public static int countSquares(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    var dp = new int[rows][cols];  // max side of square with bottom right at [i, j]
    var count = 0;
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          dp[i][j] = 1;
          count++;
          if (i > 0 && j > 0) {
            // up left is '1' so we check if we could make a larger square by adding row at bottom and col at right
            if (dp[i - 1][j - 1] >= 0) {
              // find max row
              var row = 1;
              for (var k = 1; k <= dp[i - 1][j - 1]; k++) {
                if (matrix[i][j - k] != 1) {
                  break;
                }
                row++;
              }
              // find max col
              var col = 1;
              for (var k = 1; k <= dp[i - 1][j - 1]; k++) {
                if (matrix[i - k][j] != 1) {
                  break;
                }
                col++;
              }
              if (row > 0 || col > 0) {
                dp[i][j] = Math.min(row, col);
                count += dp[i][j] - 1;
              }
            }
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}));
  }
}
