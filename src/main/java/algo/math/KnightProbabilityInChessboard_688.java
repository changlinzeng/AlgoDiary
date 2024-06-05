package algo.math;

import java.util.HashMap;
import java.util.Map;

public class KnightProbabilityInChessboard_688 {
  public static double knightProbability(int n, int k, int row, int column) {
    return dfs(n, k, row, column, new HashMap<>());
  }

  private static double dfs(int n, int k, int row, int col, Map<String, Double> memo) {
    if (k == 0) {
      return 1;
    }
    var key = k + "_" + row + "_" + col;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    var directions = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    double prob = 0;
    for (var dir : directions) {
      int nextRow = row + dir[0], nextCol = col + dir[1];
      if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
        prob += 1.0 / 8 * dfs(n, k - 1, nextRow, nextCol, memo);
      }
    }
    memo.put(key, prob);
    return prob;
  }
}
