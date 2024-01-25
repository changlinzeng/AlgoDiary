package algo.twoPointers;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray_581 {
  public static int[] shortestSubarray(int[] nums) {
    int low, high, len = nums.length;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int from, to;

    for (low = 0; low < len - 1 && nums[low] <= nums[low + 1]; low++) {
    }

    if (low == len - 1) {
      return new int[0];
    }

    for (high = len - 1; high > 1 && nums[high] >= nums[high - 1]; high--) {
    }

    for (int i = low; i <= high; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }

    for (from = 0; from < low && nums[from] <= min; from++) {
    }

    for (to = len - 1; to > high && nums[to] >= max; to--) {
    }

    return Arrays.copyOfRange(nums, from, to + 1);
  }

  public static void main(String[] args) {
//    var arr = shortestSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
//    var arr = shortestSubarray(new int[]{1, 2, 3, 4});
//    var arr = shortestSubarray(new int[]{1});
//    var arr = shortestSubarray(new int[]{1, 2});
//    var arr = shortestSubarray(new int[]{3, 2, 1});
//    var arr = shortestSubarray(new int[]{3, 5, 7, 6, 1, 8});
//    var arr = shortestSubarray(new int[]{3, 5, 7, 6, 20, 10, 12});
//    var arr = shortestSubarray(new int[]{1, 2, 3, 3, 3});
//    var arr = shortestSubarray(new int[]{2, 3, 3, 2, 4});
    var arr = shortestSubarray(new int[]{1, 3, 2, 2, 2});
    for (int i : arr) {
      System.out.println(i);
    }
  }
}
