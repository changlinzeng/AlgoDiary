package algo.depthFirstSearch;

public class PartitionStringIntoSubstringsWithValuesAtMostK_252 {
  public static int minimumPartition(String s, int k) {
    return dfs(s, k, 0, new int[s.length()]);
  }

  private static int dfs(String s, int k, int start, int[] dp) {
    if (start == s.length()) {
      return 0;
    }
    if (dp[start] != 0) {
      return dp[start];
    }
    var minPartition = Integer.MAX_VALUE;
    long sum = 0;
    for (var i = start; i < s.length(); i++) {
      sum = sum * 10 + (s.charAt(i) - '0');
      if (sum > k) {
        // the single char is greater than k, so we could not partition anymore
        if (i == start) {
          return -1;
        }
        break;
      }
      minPartition = Math.min(minPartition, dfs(s, k, i + 1, dp));
    }
    dp[start] = minPartition == -1 ? -1 : minPartition + 1;
    return dp[start];
  }

  public static void main(String[] args) {
    System.out.println(minimumPartition("165462", 60));
  }
}
