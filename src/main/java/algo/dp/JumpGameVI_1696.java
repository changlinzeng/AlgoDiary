package algo.dp;

import java.util.Arrays;

public class JumpGameVI_1696 {
  public static int maxResult(int[] nums, int k) {
    //           1  -1  -2  4  -7  3
    //dp[i][0]   1   0  -1  4  -3  7
    //maxk       1   1   0  4   4  7
    var len = nums.length;
    var maxk = nums[0];
    var dp = new int[len];  // max sum at i
    dp[0] = nums[0];
    for (var i = 1; i < len; i++) {
      dp[i] = nums[i] + maxk;
      if (i >= k && maxk == dp[i - k]) {
        // max sum is now outside of [i - k, i]
        maxk = dp[i];
        for (var j = i - 1; j >= 0 && j > i - k; j--) {
          maxk = Math.max(maxk, dp[j]);
        }
      } else {
        maxk = Math.max(maxk, dp[i]);
      }
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
    System.out.println(maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
    System.out.println(maxResult(new int[]{10,-5,-2,4,0,3}, 3));
    System.out.println(maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
  }
}
