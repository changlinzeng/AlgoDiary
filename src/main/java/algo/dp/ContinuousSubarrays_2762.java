package algo.dp;

import java.util.Arrays;

public class ContinuousSubarrays_2762 {
  public static long continuousSubarrays(int[] nums) {
    var len = nums.length;
    var dp = new int[len];
    Arrays.fill(dp, 1);
    for (var i = 1; i < len; i++) {
      if (nums[i] == nums[i - 1]) {
        dp[i] = dp[i - 1] + 1;
      } else {
        var j = i - 1;
        int max = nums[i], min = nums[i];
        while (j >= 0) {
          max = Math.max(max, nums[j]);
          min = Math.min(min, nums[j]);
          if (Math.abs(max - min) > 2) {
            break;
          }
          j--;
        }
        j++;
        dp[i] += i - j;
      }
    }

    long count = 0;
    for (var n : dp) {
      count += n;
    }
    return count;
  }
}
