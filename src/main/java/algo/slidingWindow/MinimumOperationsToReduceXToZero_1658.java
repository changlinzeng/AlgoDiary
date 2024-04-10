package algo.slidingWindow;

import java.util.Arrays;

public class MinimumOperationsToReduceXToZero_1658 {
  public static int minOperations(int[] nums, int x) {
    // we can think this as the longest subarray with given sum
    int targetSum = Arrays.stream(nums).sum() - x;

    int maxlen = -1;
    int left = 0, right = 0;
    int sum = 0;
    if (targetSum == 0) {
      return nums.length;
    }
    while (right < nums.length) {
      sum += nums[right];
      if (sum == targetSum) {
        maxlen = Math.max(maxlen, right - left + 1);
      } else if (sum > targetSum) {
        // move left
        while (left < right && sum > targetSum) {
          sum -= nums[left];
          left++;
        }
        if (sum == targetSum) {
          maxlen = Math.max(maxlen, right - left + 1);
        }
      }
      right++;
    }

    return maxlen == -1 ? -1 : nums.length - maxlen;
  }

  public static void main(String[] args) {
    System.out.println(minOperations(new int[]{1,1,4,2,3}, 5));
    System.out.println(minOperations(new int[]{5,6,7,8,9}, 4));
    System.out.println(minOperations(new int[]{3,2,20,1,1,3}, 10));
    System.out.println(minOperations(new int[]{5,2,3,1,1}, 5));
    System.out.println(minOperations(new int[]{5,1,4,2,3}, 6));
  }
}
