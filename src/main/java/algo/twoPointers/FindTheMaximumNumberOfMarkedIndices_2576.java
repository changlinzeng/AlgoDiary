package algo.twoPointers;

import java.util.Arrays;

public class FindTheMaximumNumberOfMarkedIndices_2576 {
  public static int maxNumOfMarkedIndices(int[] nums) {
    var len = nums.length;
    Arrays.sort(nums);

    var count = 0;
    int i = 0, j = len / 2;
    while (i < len / 2 && j < len) {
      if (nums[i] * 2 <= nums[j]) {
        i++;
        count += 2;
      }
      j++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(maxNumOfMarkedIndices(new int[]{3,5,2,4}));
    System.out.println(maxNumOfMarkedIndices(new int[]{9,2,5,4}));
  }
}
