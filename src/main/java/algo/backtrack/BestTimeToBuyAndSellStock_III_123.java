package algo.backtrack;

public class BestTimeToBuyAndSellStock_III_123 {
    public static int maxProfit(int[] prices) {
        return trade(prices, 0, 4);
    }

    /**
     * Time out for backtrack
     * @param prices
     * @param day
     * @param transactionsTodo
     * @return
     */
    private static int trade(int[] prices, int day, int transactionsTodo) {
        if (day == prices.length || transactionsTodo == 0) {
            return 0;
        }

        // if we do not make any transaction this day
        var profit1 = trade(prices, day + 1, transactionsTodo);

        // we make transaction this day
        boolean buy = (transactionsTodo % 2 == 0);
        var profit2 = 0;
        if (buy) {
            profit2 += -1 * prices[day] + trade(prices, day + 1, transactionsTodo - 1);
        } else {
            profit2 += prices[day] + trade(prices, day + 1, transactionsTodo - 1);
        }

        return Math.max(profit1, profit2);
    }

    private static int trade2(int[] prices) {
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
