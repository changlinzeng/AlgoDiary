package algo.backtrack;

import java.util.HashMap;

public class PartitionToKEqualSumSubsets_698 {
  public static boolean canPartitionKSubsets(int[] nums, int k) {
    int len = nums.length, sum = 0;
    var count = new HashMap<Integer, Integer>();
    for (var n : nums) {
      sum += n;
      count.put(n, count.getOrDefault(n, 0) + 1);
    }
    if (sum % k != 0) {
      return false;
    }

    var partitionSum = sum / k;
    return backtrack(nums, k, partitionSum, partitionSum, 0, new int[k + 1][1 << (len + 1)]);
  }

  private static boolean backtrack(int[] nums, int k, int psum, int left, int bitmask, int[][] dp) {
    if (left == 0 && k == 1) {
      return true;
    }
    // bitmask is the binary representation of if nums[i] is used
    if (dp[k][bitmask] != 0) {
      return dp[k][bitmask] == 1;
    }
    if (left == 0) {
      k--;
      left = psum;
    }
    var len = nums.length;
    for (var i = 0; i < len; i++) {
      if (nums[i] > psum) {
        return false;
      }
      var pos = 1 << (len - i);
      if ((bitmask & pos) != 0) {
        continue;
      }
      if (left >= nums[i]) {
        var mask = bitmask ^ pos;
        if (backtrack(nums, k, psum, left - nums[i], mask, dp)) {
          dp[k][mask] = 1;
          return true;
        }
        dp[k][mask] = -1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
//    System.out.println(canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
//    System.out.println(canPartitionKSubsets(new int[]{1,2,3,4}, 3));
//    System.out.println(canPartitionKSubsets(new int[]{129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22}, 3));
//    System.out.println(canPartitionKSubsets(new int[]{15,3557,42,3496,5,81,34,95,9,81,42,106,71}, 11));
//    System.out.println(canPartitionKSubsets(new int[]{3,3,10,2,6,5,10,6,8,3,2,1,6,10,7,2}, 6));
//    System.out.println(canPartitionKSubsets(new int[]{99,37,37,37,37,37,37,37,37,5}, 4));
    System.out.println(canPartitionKSubsets(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}, 4));
  }
}
