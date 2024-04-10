package algo.slidingWindow;

public class MaximumLengthOfSubarrayWithPositiveProduct_1567 {
  /**
   * Count negative numbers in the window
   */
  public static int getMaxLen2(int[] nums) {
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

  public static int getMaxLen(int[] nums) {
    var maxLen = 0;
    var start = 0;
    int firstNeg = -1, lastNeg = -1, negCount = 0;
    for (var i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        negCount++;
        if (firstNeg == -1) {
          firstNeg = i;
        }
        lastNeg = i;
      }
      if (nums[i] == 0) {
        if (i > 0 && nums[i - 1] != 0) {
          //check subarray from start to i
          if (negCount % 2 == 0) {
            maxLen = Math.max(maxLen, i - start);
          } else {
            var max = Math.max(i - firstNeg - 1, lastNeg - start);
            maxLen = Math.max(maxLen, max);
          }
          firstNeg = -1;
          lastNeg = -1;
          negCount = 0;
        }
        start = i + 1;
      } else if (i == nums.length - 1) {
        if (negCount % 2 == 0) {
          maxLen = Math.max(maxLen, i - start + 1);
        } else {
          var max = Math.max(i - firstNeg, lastNeg - start);
          maxLen = Math.max(maxLen, max);
        }
      }
    }
    return maxLen;
  }
}
