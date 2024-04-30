package algo.backtrack;

public class MinimumCostForTickets_983 {
  public static int mincostTickets(int[] days, int[] costs) {
    return backtrack(days, costs, 0, new int[days.length]);
  }

  private static int backtrack(int[] days, int[] costs, int start, int[] dp) {
    var tickets = new int[]{1, 7, 30};
    if (start == days.length) {
      return 0;
    }
    if (dp[start] != 0) {
      return dp[start];
    }
    var minCost = Integer.MAX_VALUE;
    var today = days[start];
    for (var j = 0; j < tickets.length; j++) {
      var day = start;
      while (day < days.length && days[day] < today + tickets[j]) {
        day++;
      }
      minCost = Math.min(minCost, costs[j] + backtrack(days, costs, day, dp));
    }
    dp[start] = minCost;
    return minCost;
  }

  public static void main(String[] args) {
    System.out.println(mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    System.out.println(mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
  }
}
