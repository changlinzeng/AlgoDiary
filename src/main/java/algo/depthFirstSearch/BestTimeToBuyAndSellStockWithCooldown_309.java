package algo.depthFirstSearch;

public class BestTimeToBuyAndSellStockWithCooldown_309 {
  public int maxProfit(int[] prices) {
    var memo = new int[prices.length][2];
    for (var i = 0; i < prices.length; i++) {
      for (var j = 0; j < 2; j++) {
        memo[i][j] = -1;
      }
    }
    return dfs(prices, 1, 0, memo);
  }

  private int dfs(final int[] prices, int buy, int start, int[][] memo) {
    if (start >= prices.length) {
      return 0;
    }
    if (memo[start][buy] != -1) {
      return memo[start][buy];
    }
    var maxProfit = 0;
    if (buy == 1) {
      // buy stock or not
      maxProfit = Math.max(maxProfit, -1 * prices[start] + dfs(prices, 0, start + 1, memo));
      maxProfit = Math.max(maxProfit, dfs(prices, 1, start + 1, memo));
    } else {
      // sell stock or not
      maxProfit = Math.max(maxProfit, prices[start] + dfs(prices, 1, start + 2, memo));
      maxProfit = Math.max(maxProfit, dfs(prices, 0, start + 1, memo));
    }
    memo[start][buy] = maxProfit;
    return maxProfit;
  }
}
