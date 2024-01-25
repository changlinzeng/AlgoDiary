package algo.twoPointers;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray_1877 {
  public static int minPairSum(int[] nums) {
    int len = nums.length;
    int minMaxSum = Integer.MIN_VALUE;
    Arrays.sort(nums);

    int i = 0, j = len - 1;
    while (i < j) {
      minMaxSum = Math.max(minMaxSum, nums[i] + nums[j]);
      i++;
      j--;
    }

    return minMaxSum;
  }

  public static void main(String[] args) {
    System.out.println(minPairSum(new int[]{3,5,2,3}));
    System.out.println(minPairSum(new int[]{3,5,4,2,4,6}));
  }
}
