package algo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer_935 {
  private static final Map<Integer, List<Integer>> moves = new HashMap<>() {
    {
      put(0, List.of(4, 6));
      put(1, List.of(6, 8));
      put(2, List.of(7, 9));
      put(3, List.of(4, 8));
      put(4, List.of(0, 3, 9));
      put(5, List.of());
      put(6, List.of(0, 1, 7));
      put(7, List.of(2, 6));
      put(8, List.of(1, 3));
      put(9, List.of(2, 4));
    }
  };

  private static final int mod = 1_000_000_007;

  public static int knightDialer(int n) {
    var dp = new long[n][10];  // count of numbers ending with 0 to 9
    dp[0] = new long[10];
    Arrays.fill(dp[0], 1);

    for (var i = 1; i < n; i++) {
      var arr = new long[10];
      for (var k = 0; k < 10; k++) {
        var lastNumberCount = dp[i - 1][k];  // count of number ending with k
        for (var last : moves.get(k)) {
          arr[last] = (arr[last] + lastNumberCount) % mod;
        }
      }
      dp[i] = arr;
    }

    return (int) ((Arrays.stream(dp[n - 1]).sum()) % mod);
  }

  public static void main(String[] args) {
    System.out.println(knightDialer(4));
  }

}
