package algo.backtrack;

import java.util.Arrays;

public class PartitionEqualSubsetSum_416 {
    public static boolean canPartition(int[] nums) {
        var sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            // sum should be even to be partitioned
            return false;
        }
        var partialSum = sum / 2;
        return canSumUp(nums, partialSum, 0, new int[nums.length][partialSum + 1]);
    }

    private static boolean canSumUp(int[] nums, int sum, int start, int[][] dp) {
        if (sum == 0) {
           return true;
        }
        if (start >= nums.length) {
            return false;
        }
        if (dp[start][sum] != 0) {
            return dp[start][sum] == 1;
        }
        for (var i = start; i < nums.length; i++) {
            if (nums[i] <= sum) {
                if (canSumUp(nums, sum - nums[i], i + 1, dp)) {
                    dp[start][sum] = 1;
                    return true;
                } else {
                    dp[start][sum] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,3,5}));
        System.out.println(canPartition(new int[]{1,2,5}));
        System.out.println(canPartition(new int[]{1,2,3,4,5,6,7}));
        System.out.println(canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
        System.out.println(canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
        System.out.println(canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,
                                                  100,100,100,100,
                                                  99,97}));
        System.out.println(canPartition(new int[]{1,2,3,4,5,6,7}));
    }
}
