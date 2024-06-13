package algo.depthFirstSearch;

import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
  public static int minimumTotal(List<List<Integer>> triangle) {
    var len = triangle.size();
    var memo = new int[len][len];
    for (var m : memo) {
      Arrays.fill(m, Integer.MAX_VALUE);
    }
    return dfs(triangle, 0, 0, memo);
  }

  private static int dfs(List<List<Integer>> triangle, int row, int col, int[][] memo) {
    var sum = triangle.get(row).get(col);
    if (row == triangle.size() - 1) {
      return sum;
    }
    if (memo[row][col] != Integer.MAX_VALUE) {
      return memo[row][col];
    }
    var min = dfs(triangle, row + 1, col, memo);
    min = Math.min(min, dfs(triangle, row + 1, col + 1, memo));
    memo[row][col] = min + sum;
    return memo[row][col];
  }
}
