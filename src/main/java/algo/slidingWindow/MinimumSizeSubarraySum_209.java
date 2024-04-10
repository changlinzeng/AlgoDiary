package algo.slidingWindow;

public class MinimumSizeSubarraySum_209 {
  public static int minSubArrayLen2(int target, int[] nums) {
    int i = 0, j = 0;
    int len = nums.length;
    int size = len + 1;
    int sum = nums[0];

    while (i <= j && j < len - 1) {

      // enlarge window size to the right
      while (sum < target && j < len - 1) {
        sum += nums[++j];
      }
      size = Math.min(size, j - i + 1);

      // shrink window from left
      while (sum >= target && i <= j) {
        sum -= nums[i++];
      }
      size = Math.min(size, j - i + 1);
    }

    return size <= len ? size : 0;
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int left = 0, right = 0;
    var sum = 0;
    var minLen = Integer.MAX_VALUE;
    while (right < nums.length) {
      sum += nums[right];
      if (sum >= target) {
        while (left < right && sum - nums[left] >= target) {
          sum -= nums[left];
          left++;
        }
        minLen = Math.min(minLen, right - left + 1);
      }
      right++;
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }

}
