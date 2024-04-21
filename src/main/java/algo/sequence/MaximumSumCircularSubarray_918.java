package algo.sequence;

public class MaximumSumCircularSubarray_918 {
  public static int maxSubarraySumCircular(int[] nums) {
    // there are two cases
    // one is to find the max sum array in [0, len - 1]
    // the other is to remove the min sum array in [0, len - 1] and the left is the target array
    var len = nums.length;
    var dp = new int[len][2];  // max sum and min sum of array ends at i
    dp[0] = new int[]{nums[0], nums[0]};
    int sum = nums[0], maxSum = sum, minSum = sum;
    for (var i = 1; i < len; i++) {
      sum += nums[i];
      dp[i] = new int[]{Math.max(dp[i - 1][0] + nums[i], nums[i]), Math.min(dp[i - 1][1] + nums[i], nums[i])};
      maxSum = Math.max(maxSum, dp[i][0]);
      minSum = Math.min(minSum, dp[i][1]);
    }
    if (maxSum < 0) {
      return maxSum;
    } else {
      return Math.max(maxSum, sum - minSum);
    }
  }

  public static void main(String[] args) {
    System.out.println(maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    System.out.println(maxSubarraySumCircular(new int[]{5,-3,5}));
  }
}
