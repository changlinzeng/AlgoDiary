package algo.dp;

public class CombinationSum_IV_377 {
  public int combinationSum4(int[] nums, int target) {
    var dp = new int[target + 1];
    dp[0] = 1;
    for (var i = 1; i <= target; i++) {
      for (var n : nums) {
        if (n <= i) {
          dp[i] += dp[i - n];
        }
      }
    }
    return dp[target];
  }
}
