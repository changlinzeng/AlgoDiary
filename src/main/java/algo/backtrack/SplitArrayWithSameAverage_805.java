package algo.backtrack;

import java.util.Arrays;

public class SplitArrayWithSameAverage_805 {
  public static boolean splitArraySameAverage(int[] nums) {
    var len = nums.length;
    var total = Arrays.stream(nums).sum();
    float avg = 1.0f * total / len;
    return backtrack(nums, avg, 0, 0, 0, new int[total + 1][1 << len]);
  }

  private static boolean backtrack(final int[] nums, final float avg, int sum, int num, int bitmask, int[][] dp) {
    if (num != 0 && Float.compare(sum, avg * nums.length) != 0 && Float.compare(1.0f * sum / num, avg) == 0) {
      return true;
    }
    if (dp[sum][bitmask] != 0) {
      return dp[sum][bitmask - 1] == 1;
    }
    var len = nums.length;
    for (var i = 0; i < len; i++) {
      var pos = 1 << (len - i - 1);
      if ((bitmask & pos) != 0) {
        continue;
      }
      var mask = bitmask ^ pos;
      if (backtrack(nums, avg, sum + nums[i], num + 1, mask, dp)) {
        dp[sum][bitmask] = 1;
        return true;
      }
      dp[sum][bitmask] = -1;
    }
    return false;
  }

  public static void main(String[] args) {
//    System.out.println(splitArraySameAverage(new int[]{1,2,3,4,5,6,7,8}));
//    System.out.println(splitArraySameAverage(new int[]{3,1}));
    System.out.println(splitArraySameAverage(new int[]{60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30}));
//    System.out.println(255 ^ 0);
  }
}
