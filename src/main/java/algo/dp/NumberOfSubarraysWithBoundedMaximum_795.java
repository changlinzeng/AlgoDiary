package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfSubarraysWithBoundedMaximum_795 {
  public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
    var len = nums.length;
    var dp = new int[len];  // number of arrays ends at i
    dp[0] = nums[0] >= left && nums[0] <= right ? 1 : 0;
    var prevInvalid = nums[0] > right ? 0 : -1;   // position of prev invalid element
    for (var i = 1; i < len; i++) {
      if (nums[i] > right) {
        // current is invalid
        dp[i] = 0;
        prevInvalid = i;
      } else if (nums[i] < left) {
        dp[i] = dp[i - 1];
      } else {
        dp[i] = i - prevInvalid;
      }
    }
    return Arrays.stream(dp).sum();
  }

  public static void main(String[] args) {
//    System.out.println(numSubarrayBoundedMax(new int[]{2,1,4,3}, 2, 3));
//    System.out.println(numSubarrayBoundedMax(new int[]{2,9,2,5,6}, 2, 8));
//    System.out.println(numSubarrayBoundedMax(new int[]{7,3,6,7,1}, 1, 4));
    System.out.println(numSubarrayBoundedMax(new int[]{409,96,729,843,328,855,860,587,238,141,475,857,82,10,279,683,194,549,81,201,711,705,617,615,941,589,12,781,260,42,745,976,201,973,609,402,629,322,78,805,746,515,401,119,224,178,711,960,266,130,310,731,969,717,43,656,729,447,997,563,41,235,366,584,293,305,104,378,632,766,245,149,498,147,865,133,227,680,655,603,529,885,875,737,173,317,995,705,283,984,649,513,702,313,499,676,516,106,446,491}, 542, 772));
  }
}
