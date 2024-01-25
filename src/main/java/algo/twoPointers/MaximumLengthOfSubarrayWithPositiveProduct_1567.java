package algo.twoPointers;

public class MaximumLengthOfSubarrayWithPositiveProduct_1567 {
  /**
   * Count negative numbers in the window
   */
  public static int getMaxLen(int[] nums) {
    int len = nums.length, numNeg = 0;
    int start = 0, end = 0, maxLen = 0;
    while (end <= len) {
      if (end == len || nums[end] == 0) {
        if (numNeg % 2 != 0) {
          while (start < end && nums[start] > 0) {
            start++;
          }
          maxLen = Math.max(maxLen, end - start - 1);
        }
        end++;
        start = end;
        numNeg = 0;
        continue;
      }
      if (nums[end] < 0) {
        numNeg++;
      }
      if (numNeg % 2 == 0) {
        maxLen = Math.max(maxLen, end - start + 1);
      }
      end++;
    }

    return maxLen;
  }
}
