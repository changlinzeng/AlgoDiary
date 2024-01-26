package algo.dp;

import java.util.Arrays;
import java.util.List;

public class ArithmeticSlices_413 {
  public static int numberOfArithmeticSlices(int[] nums) {
    var len = nums.length;
    if (len < 3) {
      return 0;
    }
    var dp = new int[len];
    for (var i = 2; i < len; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[ i -2]) {
        dp[i] = dp[i - 1] + 1;
      }
    }

    return Arrays.stream(dp).sum();
  }

  public static void main(String[] args) {
    System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
  }
}
