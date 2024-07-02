package algo.dp;

public class UniquePath_II_63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
    var dp = new int[rows][cols];
    // init the first row
    for (var i = 0; i < cols; i++) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
      dp[0][i] = 1;
    }
    // init the first column
    for (var i = 0; i < rows; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      }
      dp[i][0] = 1;
    }

    for (var i = 1; i < rows; i++) {
      for (var j = 1; j < cols; j++) {
        if (obstacleGrid[i][j] == 0) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[rows - 1][cols - 1];
  }
}
