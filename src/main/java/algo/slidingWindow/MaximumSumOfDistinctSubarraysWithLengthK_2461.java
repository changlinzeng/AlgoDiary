package algo.slidingWindow;

import java.util.HashSet;

public class MaximumSumOfDistinctSubarraysWithLengthK_2461 {
  public static long maximumSubarraySum(int[] nums, int k) {
    var len = nums.length;
    long maxSum = 0, sum = 0;
    var count = new HashSet<Integer>();
    int i = 0, j = 0;
    while (j < len) {
      if (count.add(nums[j])) {
        sum += nums[j];
        while (j - i + 1 > k) {
          sum -= nums[i];
          count.remove(nums[i]);
          i++;
        }
        // in case subarray length < k when starting the loop
        if (j - i + 1 == k) {
          maxSum = Math.max(maxSum, sum);
        }
      } else {
        // move window right till we remove the prev nums[i] out of window
        while (i < j && nums[i] != nums[j]) {
          sum -= nums[i];
          count.remove(nums[i]);
          i++;
        }
        i++;
      }
      j++;
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    System.out.println(maximumSubarraySum(new int[]{4,4,4}, 3));
  }
}
