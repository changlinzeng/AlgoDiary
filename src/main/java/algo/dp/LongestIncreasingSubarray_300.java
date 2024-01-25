package algo.dp;

import java.util.Arrays;

public class LongestIncreasingSubarray_300 {
  /**
   *
   *  num  [10, 9, 2, 5, 3, 7, 101, 18]
   *  dp   [1 , 1, 1, 2, 2, 3,   4,  4]
   *
   *
   */
  public int lengthOfLIS(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];

    Arrays.fill(dp, 1);

    int maxlen = dp[0];

    for (int i = 1; i < len; i++) {

      // find previous numbers smaller than nums[i]
      for (int j = i - 1; j >= 0; j--) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }

      maxlen = Math.max(maxlen, dp[i]);
    }

    return maxlen;
  }
}
