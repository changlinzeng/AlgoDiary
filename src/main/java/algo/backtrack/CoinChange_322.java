package algo.backtrack;

import java.time.Instant;

public class CoinChange_322 {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return dfs(coins, amount, new int[amount + 1]);
    }

    private static int dfs(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }

        var min = Integer.MAX_VALUE;
        for (int coin : coins) {
          var res = dfs(coins, amount - coin, dp);
          if (res != -1) {
            min = Math.min(min, 1 + res);
          }
        }
        if (min == Integer.MAX_VALUE) {
            dp[amount] = -1;
        } else {
            dp[amount] = min;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        var start = Instant.now();
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{1,2,5}, 1));
        System.out.println(coinChange(new int[]{1,2,5}, 2));
        System.out.println(coinChange(new int[]{1,2,5}, 4));
        System.out.println(coinChange(new int[]{2,5,10,1}, 27));

        System.out.println(coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
//        var end = Instant.now();
//        System.out.println("duration: " + Duration.between(start, end).toMillis());
    }
}
