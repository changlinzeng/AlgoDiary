package algo.dp;

public class UniqueBinarySearchTrees_96 {
  public static int numTrees(int n) {
    // the number of BST with root node k is the number of trees is calculated as
    // (number of trees with nodes 1 to k - 1) * (number of trees with nodes k + 1 to n)
    var dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (var i = 2; i <= n; i++) {
      // dp[i] = dp[0] * dp[i - 1] + dp[1] * dp[i - 2] ... + dp[i - 2] * dp[1] + dp[i - 1] * dp[0]
      for (var j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }
}
