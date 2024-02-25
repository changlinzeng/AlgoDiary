package algo.sequence;

import java.util.Arrays;

public class LongestNonDecreasingSubarrayFromTwoArrays_2771 {
  public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
    var len = nums1.length;
    var maxLen = 1;
    var dp1 = new int[len];
    var dp2 = new int[len];
    Arrays.fill(dp1, 1);
    Arrays.fill(dp2, 1);
    for (var i = 1; i < len; i++) {
      if (nums1[i] >= nums1[i - 1]) {
        dp1[i] = dp1[i - 1] + 1;
      }
      if (nums1[i] >= nums2[i - 1]) {
        dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
      }
      if (nums2[i] >= nums2[i - 1]) {
        dp2[i] = dp2[i - 1] + 1;
      }
      if (nums2[i] >= nums1[i - 1]) {
        dp2[i] = Math.max(dp2[i], dp1[i - 1] + 1);
      }
      maxLen = Math.max(maxLen, Math.max(dp1[i], dp2[i]));
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(maxNonDecreasingLength(new int[]{2,3,1}, new int[]{1,2,1}));
    System.out.println(maxNonDecreasingLength(new int[]{1,3,2,1}, new int[]{2,2,3,4}));
    System.out.println(maxNonDecreasingLength(new int[]{11,7,7,9}, new int[]{19,19,1,7}));
  }
}
