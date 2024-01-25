package algo.slidingWindow;

import java.util.HashSet;

public class MaximumErasureValue_1695 {
  public static int maximumUniqueSubarray(int[] nums) {
    var freq = new HashSet<Integer>();
    int sum = 0, max = 0;
    int left = 0, right = 0;
    while (right < nums.length) {
      var n = nums[right];
      if (freq.contains(n)) {
        // remove numbers from the subarray
        while (left < right && freq.contains(n)) {
          freq.remove(nums[left]);
          sum -= nums[left];
          left++;
        }
      } else {
        freq.add(n);
        sum += n;
        max = Math.max(max, sum);
        right++;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
  }
}
