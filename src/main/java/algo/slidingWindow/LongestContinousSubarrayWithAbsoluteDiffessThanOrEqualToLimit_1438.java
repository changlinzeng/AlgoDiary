package algo.slidingWindow;

public class LongestContinousSubarrayWithAbsoluteDiffessThanOrEqualToLimit_1438 {
  public static int longestSubarray(int[] nums, int limit) {
    // the diff of the smallest and biggest number in the window less than limit
    int len = nums.length;
    int maxlen = 0, min = Integer.MAX_VALUE, max = 0;
    int left = 0, right = 0;
    while (right < len) {
      if (nums[right] < min) {
        min = nums[right];
      }
      if (nums[right] > max) {
        max = nums[right];
      }
      if (max - min > limit) {
        // move left
        while (max - min > limit) {
          if (nums[left] == min) {
            // find next min from left + 1 to right
            if (nums[left] == nums[left + 1]) {
              while (nums[left + 1] == nums[left]) {
                left++;
              }
            } else {
              left++;
            }
            min = nums[left];
            for (var i = left; i <= right; i++) {
              if (nums[i] < min) {
                min = nums[i];
              }
            }
          } else if (nums[left] == max) {
            // find next max from left + 1 to right
            if (nums[left] == nums[left + 1]) {
              while (nums[left + 1] == nums[left]) {
                left++;
              }
            } else {
              left++;
            }
            max = nums[left];
            for (var i = left; i <= right; i++) {
              if (nums[i] > max) {
                max = nums[i];
              }
            }
          } else {
            left++;
          }
        }
      } else {
        maxlen = Math.max(maxlen, right - left + 1);
      }
      right++;
    }

    return maxlen;
  }

  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));
    System.out.println(longestSubarray(new int[]{10,1,2,4,7,2}, 5));
    System.out.println(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    System.out.println(longestSubarray(new int[]{1,5,5,5,6,6}, 4));
    // 36 - 15
    System.out.println(longestSubarray(new int[]{24,12,71,33,5,87,10,11,3,58,2,97,97, 36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15, 4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39}, 87));
  }
}
