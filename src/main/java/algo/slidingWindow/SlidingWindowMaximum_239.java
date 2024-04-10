package algo.slidingWindow;

import java.util.Arrays;

/**
 * Find the position of max within window and when window moves beyond max, find again
 */
public class SlidingWindowMaximum_239 {
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int max = 0;
    int len = nums.length;
    int[] maxwin = new int[len - k + 1];

    max = findMax(nums, 0, k - 1);

    for (int start = 0, end = k - 1; end < len; start++, end++) {
      if (start > max) {
        // find max again
        max = findMax(nums, start, end);
      }
      if (nums[end] >= nums[max]) {
        max = end;
      }
      maxwin[start] = nums[max];
    }

    return maxwin;
  }

  private static int findMax(int[] nums, int from, int to) {
    int max = from;
    for (int i = from + 1; i <= to; i++) {
      if (nums[i] >= nums[max]) {
        max = i;
      }
    }

    return max;
  }

  public static void main(String[] args) {
//    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1)));
  }
}
