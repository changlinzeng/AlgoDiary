package algo.depthFirstSearch;

import java.util.Arrays;

public class MinimumDifficultyOfAJobSchedule_1335 {
  public static int minDifficulty(int[] jobDifficulty, int d) {
    if (jobDifficulty.length < d) {
      return -1;
    }
    if (jobDifficulty.length == d) {
      return Arrays.stream(jobDifficulty).sum();
    }
    var memo = new int[jobDifficulty.length][d + 1];
    for (var row : memo) {
      Arrays.fill(row, -1);
    }
    return dfs(jobDifficulty, d, 0, memo);
  }

  private static int dfs(int[] jobDifficulty, int day, int start, int[][] memo) {
    var len = jobDifficulty.length;

    if (memo[start][day] != -1) {
      return memo[start][day];
    }

    var currentMax = 0;
    if (day == 1) {
      for (var i = start; i < len; i++) {
        currentMax = Math.max(currentMax, jobDifficulty[i]);
      }
      return currentMax;
    }

    var minDifficulty = Integer.MAX_VALUE;
    for (var i = start; i < len - day + 1; i++) {
      currentMax = Math.max(currentMax, jobDifficulty[i]);
      var nextMin = dfs(jobDifficulty, day - 1, i + 1, memo);
      minDifficulty = Math.min(minDifficulty, currentMax + nextMin);
    }
    memo[start][day] = minDifficulty;
    return minDifficulty;
  }

  public static void main(String[] args) {
    System.out.println(minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
  }
}
