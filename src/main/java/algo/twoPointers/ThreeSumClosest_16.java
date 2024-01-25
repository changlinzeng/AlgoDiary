package algo.twoPointers;

import java.util.Arrays;

public class ThreeSumClosest_16 {
  public static int threeSumClosest(int[] nums, int target) {
    var len = nums.length;
    int result = 0, diff = Integer.MAX_VALUE;
    int i = 0, j = 1, k = len - 1;

    Arrays.sort(nums);

    while (j < k) {
      var sum = nums[i] + nums[j] + nums[k];
      var newDiff = Math.abs(target - sum);
      if (newDiff == 0) {
        return sum;
      }
      if (newDiff < diff) {
        result = sum;
        diff = newDiff;
      }

      // reduce the sum
      if (j == i + 1 && sum > target) {
        k--;
        i = 0;
        j = 1;
      } else {
        j++;
        if (j == k) {
          i++;
          j = i + 1;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    System.out.println(threeSumClosest(new int[]{0,3,97,102,200}, 300));
    // -5, -5, -4, 0, 0, 3, 3, 4, 5
    System.out.println(threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
  }
}
