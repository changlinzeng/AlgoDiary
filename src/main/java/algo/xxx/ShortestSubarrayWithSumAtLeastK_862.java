package algo.xxx;

import java.util.Arrays;

public class ShortestSubarrayWithSumAtLeastK_862 {
  public static int shortestSubarray2(int[] nums, int k) {
    int sum = 0, min = Integer.MAX_VALUE;
    int len = nums.length, start = 0, end = 0;
    while (start < len && end < len) {
      sum += nums[end];
      if (sum >= k) {
        min = Math.min(min, end - start + 1);
        // shrink window from left
        for(var i = start; i < end; i++) {
          sum -= nums[i];
          if (sum >= k) {
            min = Math.min(min, end - i + 1);
          }
        }
      }
      if (end == len - 1) {
        start++;
        end = start;
        sum = 0;
      } else {
        end++;
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public static int shortestSubarray(int[] nums, int k) {
    // 3   -1   4   5   -2   9   7    k = 9
    // -1  -1  -1   2    2   1   2
    var len = nums.length;
    var dp = new int[len];
    var sums = new int[len];  // max sum of subarray ends at i
    Arrays.fill(dp, -1);
    dp[0] = nums[0] >= k ? 1 : -1;
    sums[0] = nums[0];
    for (var i = 1; i < len; i++) {
      sums[i] = Math.max(nums[i], nums[i] + sums[i - 1]);
      if (nums[i] <= 0) {
        dp[i] = dp[i - 1];
      } else if (nums[i] >= k) {
        dp[i] = 1;
        return 1;
      } else {
        if (sums[i] >= k) {
          int sum = 0, limit = dp[i - 1] == -1 ? -1 : i - dp[i - 1];
          for (var j = i; j > limit; j--) {
            sum += nums[j];
            if (sum >= k) {
              dp[i] = i - j + 1;
              break;
            }
          }
        }
        if (dp[i] == -1) {
          dp[i] = dp[i - 1];
        }
      }
    }

    return dp[len - 1];
  }

  public static void main(String[] args) {
    System.out.println(shortestSubarray(new int[]{1}, 1));
    System.out.println(shortestSubarray(new int[]{1,2}, 4));
    System.out.println(shortestSubarray(new int[]{2,-1,2}, 3));
    System.out.println(shortestSubarray(new int[]{17,85,93,-45,-21}, 150));
    System.out.println(shortestSubarray(new int[]{56,-21,56,35,-9}, 61));
    System.out.println(shortestSubarray(new int[]{-28,81,-20,28,-29}, 89));
    System.out.println(shortestSubarray(new int[]{-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6}, 151));
  }
}
