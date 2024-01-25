package algo.dp;

public class SubarrayProductLessThanK_713 {
  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    var len = nums.length;
    var dp = new int[len];
    dp[0] = nums[0] < k ? 1 : 0;
    for (var i = 1; i < len; i++) {
      if (nums[i] >= k) {
        dp[i] = dp[i - 1];
        continue;
      }
      int product = 1, num = 0;
      for (var j = i; j >= 0; j--) {
        product *= nums[j];
        if (product >= k) {
          break;
        }
        num++;
      }
      // subarrays ended in prev element plus subarrays ended in current element
      dp[i] = dp[i - 1] + num;
    }
    return dp[len - 1];
  }
}
