package algo.sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaximumGoodSubarraySum_3026 {
  // TODO timeout!!
  public static long maximumSubarraySum(int[] nums, int k) {
    var len = nums.length;
    long maxSum = Long.MIN_VALUE;
    var pos = new HashMap<Long, List<Integer>>();
    long[] prefixSum = new long[len];
    prefixSum[0] = nums[0];
    pos.put((long) nums[0], new ArrayList<>(List.of(0)));
    for (var i = 1; i < len; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
      if (pos.containsKey((long)nums[i])) {
        pos.get((long)nums[i]).add(i);
      } else {
        pos.put((long) nums[i], new ArrayList<>(List.of(i)));
      }
      if (pos.containsKey((long)nums[i] - k)) {
        for (var idx : pos.get((long)nums[i] - k)) {
          maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[idx] + nums[idx]);
        }
      }
      if (pos.containsKey((long)nums[i] + k)) {
        for (var idx : pos.get((long)nums[i] + k)) {
          maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[idx] + nums[idx]);
        }
      }
    }
    return maxSum == Long.MIN_VALUE ? 0 : maxSum;
  }

  public static void main(String[] args) {
    System.out.println(maximumSubarraySum(new int[]{1,2,3,4,5,6}, 1));
    System.out.println(maximumSubarraySum(new int[]{-1,3,2,4,5}, 3));
    System.out.println(maximumSubarraySum(new int[]{-1,-2,-3,-4}, 2));
  }
}
