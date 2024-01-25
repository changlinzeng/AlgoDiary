package algo.sequence;

import java.util.HashSet;

public class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget_1546 {
  public static int maxNonOverlapping(int[] nums, int target) {
    var len = nums.length;
    var prefixSum = new HashSet<Integer>();
    prefixSum.add(0);

    int count = 0, sum = 0;
    for (var i = 0; i < len; i++) {
      sum += nums[i];
      if (prefixSum.contains(sum - target)) {
        count++;
        sum = 0;
        prefixSum.clear();
        prefixSum.add(0);
      } else {
        prefixSum.add(sum);
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(maxNonOverlapping(new int[]{1,1,1,1,1}, 2));
    System.out.println(maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9}, 6));
  }
}
