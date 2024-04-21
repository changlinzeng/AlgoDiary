package algo.slidingWindow;

import java.util.Arrays;

public class KRadiusSubarrayAverages_2090 {
  public static int[] getAverages(int[] nums, int k) {
    if (k == 0) {
      return nums;
    }

    var len = nums.length;
    var avg = new int[len];
    Arrays.fill(avg, -1);

    if (len < 2 * k + 1) {
      return avg;
    }

    long sum = 0;
    for (var i = 0; i < len; i++) {
      sum += nums[i];
      if (i > 2 * k) {
        sum -= nums[i - 2 * k - 1];
      }
      if (i >= 2 * k) {
        avg[i - k] = (int) (sum / (2 * k + 1));
      }
    }
    return avg;
  }

  public static void main(String[] args) {
    System.out.println(getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3));
    System.out.println(getAverages(new int[]{10,10,10,10,10,10,10,10,10,10}, 4));
  }
}
