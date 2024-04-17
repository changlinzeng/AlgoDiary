package algo.slidingWindow;

import java.util.HashMap;

public class LengthOfLongestSubarrayWithAtMostKFrequency_2958 {
  public static int maxSubarrayLength(int[] nums, int k) {
    var len = nums.length;
    var count = new HashMap<Integer, Integer>();
    int i = 0, j = 0;
    var maxLen = 0;
    while (i < len && j < len) {
      count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
      while (i < j && count.get(nums[j]) > k) {
        count.put(nums[i], count.get(nums[i]) - 1);
        i++;
      }
      maxLen = Math.max(maxLen, j - i + 1);
      j++;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
    System.out.println(maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 1));
  }
}
