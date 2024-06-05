package algo.depthFirstSearch;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDiceRollsWithTargetSum_1155 {
  public static int numRollsToTarget(int n, int k, int target) {
    return dfs(n, k, target, new HashMap<>());
  }

  private static int dfs(int n, int k, int target, Map<String, Integer> memo) {
    var key = n + "_" + target;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    if (n == 0 && target == 0) {
      return 1;
    }
    if (n == 0 || target == 0) {
      return 0;
    }
    for (var i = 1; i <= k; i++) {
      if (i > target) {
        continue;
      }
      memo.putIfAbsent(key, 0);
      var count = dfs(n - 1, k, target - i, memo);
      if (count > 0) {
        memo.put(key, (memo.get(key) + count) % 1_000_000_007);
      }
    }
    return memo.get(key);
  }
}
