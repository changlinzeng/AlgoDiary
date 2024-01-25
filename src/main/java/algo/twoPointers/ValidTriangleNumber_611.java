package algo.twoPointers;

import java.util.Arrays;

public class ValidTriangleNumber_611 {
  public static int triangleNumber(int[] nums) {
    var len = nums.length;
    var count = 0;

    Arrays.sort(nums);

    for (var i = 0; i < len - 2; i++) {
      for (var j = i + 1; j < len - 1; j++) {
        for (var k = j + 1; k < len && nums[i] + nums[j] > nums[k]; k++) {
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(triangleNumber(new int[]{2,2,3,4}));
    System.out.println(triangleNumber(new int[]{4,2,3,4}));
  }
}
