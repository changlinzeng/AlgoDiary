package algo.depthFirstSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrogJump_403 {
  public static boolean canCross(int[] stones) {
    var len = stones.length;
    var map = new HashMap<Integer, Integer>();
    for (var i = 0; i < len; i++) {
      map.put(stones[i], i);
    }
    var dp = new int[len][len];
    for (var d : dp) {
      Arrays.fill(d, -1);
    }
    return dfs(stones, map, dp, stones.length - 1, 0, 0);
  }

  private static boolean dfs(int[] stones, Map<Integer, Integer> posMap, int[][] dp, int target, int position, int prevJump) {
    if (position == target) {
      return true;
    }
    // there are duplicates on the position and prev jump, so we use memorization to record the solved state
    // dp records whether we can jump to the end from position dp[i] and prev jump dp[i][j]
    if (dp[position][prevJump] != -1) {
      return dp[position][prevJump] != 0;
    }
    var current = stones[position];
    var nextJumps = new int[]{prevJump - 1, prevJump, prevJump + 1};
    for (var n : nextJumps) {
      if (n > 0 && posMap.containsKey(current + n)) {
        var nextPos = posMap.get(current + n);
        if (dfs(stones, posMap, dp, target, nextPos, n)) {
          // mark as success
          dp[nextPos][n] = 1;
          return true;
        }
        // we are not able to reach the end from current position
        dp[nextPos][n] = 0;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //  0   1     3     5     6     8     12    17
    //  0   0,1   1,2   3,2   3,3   5,3   8,4   12,5
    //                        5,1   6,2
    //                              6,2  // repeated position and prev jump
    System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
    System.out.println(canCross(new int[]{0,1,2,3,4,8,9,11}));
    System.out.println(canCross(new int[]{0,1,2,3,4,5,6,12}));
    System.out.println(canCross(new int[]{0,1}));
  }
}
