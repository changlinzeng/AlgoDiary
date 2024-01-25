package algo.dp;

import java.util.Arrays;

public class HouseRobberII_213 {
  public static int rob(int[] nums) {
    var len = nums.length;
    if (len == 1) {
      return nums[0];
    }

    int m1, m2;
    var dp = new int[len];

    // pick first one
    dp[0] = nums[0];
    dp[1] = Math.max(dp[0], nums[1]);
    for (var i = 2; i < len - 1; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    m1 = dp[len - 2];

    // do not pick the first one
    Arrays.fill(dp, 0);
    dp[1] = nums[1];
    for (var i = 2; i < len; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    m2 = dp[len - 1];

    return Math.max(m1, m2);
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[]{2,3,2}));
    System.out.println(rob(new int[]{1,2,3,1}));
    System.out.println(rob(new int[]{1,2,3}));
  }
}
