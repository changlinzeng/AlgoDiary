package algo.depthFirstSearch;

public class BestTimeToBuyAndSellStock_III_123 {
    public static int maxProfit(int[] prices) {
        var memo = new int[prices.length][5];
        for (var i = 0; i < memo.length; i++) {
            memo[i] = new int[]{-1, -1, -1, -1, -1};
        }
        return dfs(prices, 0, 4, memo);
    }

    private static int dfs(int[] prices, int day, int transactionsTodo, int[][] memo) {
        if (day == prices.length || transactionsTodo == 0) {
            return 0;
        }

        if (memo[day][transactionsTodo] != -1) {
            return memo[day][transactionsTodo];
        }

        // if we do not make any transaction this day
        var profit1 = dfs(prices, day + 1, transactionsTodo, memo);

        // we make transaction this day
        // when there are even number of transactions to make, we need to buy stock
        boolean buy = (transactionsTodo % 2 == 0);
        var profit2 = 0;
        if (buy) {
            profit2 = -1 * prices[day] + dfs(prices, day + 1, transactionsTodo - 1, memo);
        } else {
            profit2 = prices[day] + dfs(prices, day + 1, transactionsTodo - 1, memo);
        }

        memo[day][transactionsTodo] = Math.max(profit1, profit2);
        return memo[day][transactionsTodo];
    }

    private static int trade(int[] prices) {
        int p1 = -1 * prices[0], p2 = Integer.MIN_VALUE, p3 = Integer.MIN_VALUE, p4 = Integer.MIN_VALUE;

        for (var price : prices) {
            p1 = Math.max(p1, -1 * price);  // spend
            p2 = Math.max(p2, p1 + price);  // earn
            p3 = Math.max(p3, p2 - price);  // spend
            p4 = Math.max(p4, p3 + price);  // earn
        }

        return Math.max(0, p4);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
