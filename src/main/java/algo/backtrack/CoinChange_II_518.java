package algo.backtrack;

import java.util.Arrays;

public class CoinChange_II_518 {
  public static int change(int amount, int[] coins) {
    var memo = new int[coins.length + 1][amount + 1];
    for (var arr : memo) {
      Arrays.fill(arr, -1);
    }
    return backtrack(coins, amount, 0, memo);
  }

  private static int backtrack(final int[] coins, int amount, int start, int[][] memo) {
    if (start >= coins.length) {
      return 0;
    }
    if (amount < 0) {
      return 0;
    }
    if (amount == 0) {
      return 1;
    }
    if (memo[start][amount] != -1) {
      return memo[start][amount];
    }
    // take current coin or not take
    memo[start][amount] = backtrack(coins, amount - coins[start], start, memo) +
            backtrack(coins, amount, start + 1, memo);
    return memo[start][amount];
  }
}
