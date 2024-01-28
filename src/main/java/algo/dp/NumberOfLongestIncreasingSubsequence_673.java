package algo.dp;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence_673 {
  public static int findNumberOfLIS(int[] nums) {
    var len = nums.length;
    var maxLen = 1;
    var dp = new int[len];   // len of longest subsequence ends at i
    Arrays.fill(dp, 1);
    var seqCount = new int[len];  // number of longest subsequences ends at i
    Arrays.fill(seqCount, 1);
    for (var i = 1; i < len; i++) {
      for (var j = i - 1; j >= 0; j--) {
        if (nums[i] > nums[j]) {
          if (dp[i] == dp[j] + 1) {
            // add prev count
            seqCount[i] += seqCount[j];
          } else if (dp[i] < dp[j] + 1) {
            // get new length
            seqCount[i] = seqCount[j];
            dp[i] = dp[j] + 1;
          }
        }
        maxLen = Math.max(maxLen, dp[i]);
      }
    }

    var count = 0;
    for (var i = 0; i < len; i++) {
      if (dp[i] == maxLen) {
        count += seqCount[i];
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));
  }
}
