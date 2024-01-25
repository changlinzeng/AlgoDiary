package algo.sort;

import java.util.Arrays;

public class WiggleSort_II_324 {
  public static void wiggleSort(int[] nums) {
    // 1. 1. 1. 4. 5. 6
    // 1. 4. 1. 1. 5. 6
    // 1. 4. 1. 5. 1. 6

    // 1. 1. 1. 3  4. 5. 6
    // 1  3  1  1  4  5  6
    // 1  3  1  4  1  5  6
    var len = nums.length;
    Arrays.sort(nums);
    int start = 0, end = len - 1;
    while (start < end) {
      // swap start + 1 and mid
      var mid = start + (end - start) / 2 + 1;
//      if (nums.length % 2 == 0) {
//        mid++;
//      }
      if (mid == start + 1 && mid == end - 1) {
        if (nums[mid] >= nums[mid - 1] && nums[mid] < nums[mid + 1]) {
          var tmp = nums[mid];
          nums[mid] = nums[mid + 1];
          nums[mid + 1] = tmp;
        }
      }
      var tmp = nums[mid];
      for (var i = mid; i > start + 1; i--) {
        nums[i] = nums[i - 1];
      }
      nums[start + 1] = tmp;
      start = start + 2;
    }
  }

  public static void main(String[] args) {
//    var nums = new int[]{1,4,5,6,1,1};
//    var nums = new int[]{1,4,5,6,2,1,1};
//    var nums = new int[]{1,1,2,1,2,2,1};
    var nums = new int[]{4,5,5,6};
    wiggleSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
