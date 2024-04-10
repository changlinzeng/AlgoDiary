package algo.sequence;

import java.util.Arrays;

public class NextPermutation_31 {
  public static void nextPermutation(int[] nums) {
    var len = nums.length;
    var peak = len - 1;

    // find the peak
    while (peak > 0 && nums[peak - 1] >= nums[peak]) {
      peak--;
    }

    // already sorted in descending order, reverse it
    if (peak == 0) {
      reverse(nums, 0, len - 1);
      return;
    }

    // find the smallest element that is greater than peak - 1 from peak to end
    var i = peak;
    while (i < len && nums[i] > nums[peak - 1]) {
      i++;
    }
    var tmp = nums[peak - 1];
    nums[peak - 1] = nums[i - 1];
    nums[i - 1] = tmp;

    reverse(nums, peak, len - 1);
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      var tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
//    var arr = new int[]{1, 2, 3};
//    var arr = new int[]{3, 2, 1};
    var arr = new int[]{1, 3, 2};
//    var arr = new int[]{1, 1, 5};
    nextPermutation(arr);
    for (var i : arr) {
      System.out.println(i);
    }
  }
}
