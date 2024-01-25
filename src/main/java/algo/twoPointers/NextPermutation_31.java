package algo.twoPointers;

import java.util.Arrays;

public class NextPermutation_31 {
  public static void nextPermutation(int[] nums) {
    var len = nums.length;
    var peak = 0;

    // find the peak
    for (var i = len - 1; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        peak = i;
        break;
      }
    }

    if (peak == 0) {
      Arrays.sort(nums);
      return;
    }

    // find the first element that is greater than peak - 1
    int next = peak;
    for (int i = peak; i < len; i++) {
      if (nums[i] > nums[peak - 1]) {
        next = i;
      }
    }

    // swap next and peak - 1 and then sort from peak to end
    int tmp = nums[next];
    nums[next] = nums[peak - 1];
    nums[peak - 1] = tmp;

    int from = peak, to = len - 1;
    while (from < to) {
      tmp = nums[from];
      nums[from] = nums[to];
      nums[to] = tmp;
      from++;
      to--;
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
