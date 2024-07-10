package algo.depthFirstSearch;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
  /**
   * Similar to BestTimeToBuyAndSellStock_III_123
   */
  public int maxProfit(int[] prices, int fee) {
    var memo = new int[prices.length][2];
    for (var i = 0; i < memo.length; i++) {
      memo[i] = new int[]{-1, -1};
    }
    return dfs(prices, fee, 0, 1, memo);
  }

  private int dfs(final int[] prices, final int fee, final int start, int buy, final int[][] memo) {
    if (start == prices.length) {
      return 0;
    }

    if (memo[start][buy] != -1) {
      return memo[start][buy];
    }
    int maxProfit;
    if (buy == 1) {
      // buy stock or not buy
      maxProfit = Math.max(-1 * prices[start] + dfs(prices, fee, start + 1, 0, memo),
              dfs(prices, fee, start + 1, 1, memo));
    } else {
      // sell stock or not sell
      maxProfit = Math.max(prices[start] + dfs(prices, fee, start + 1, 1, memo) - fee,
              dfs(prices, fee, start + 1, 0, memo));
    }
    memo[start][buy] = maxProfit;
    return maxProfit;
  }
}
