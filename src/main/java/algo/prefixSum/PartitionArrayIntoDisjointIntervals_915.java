package algo.prefixSum;

public class PartitionArrayIntoDisjointIntervals_915 {
  // find the smallest index so that the max before it less than the min after it
  public static int partitionDisjoint(int[] nums) {
    var len = nums.length;
    var prefixMax = new int[len];
    var suffixMin = new int[len];

    prefixMax[0] = nums[0];
    var max = nums[0];
    for (var i = 0; i < len; i++) {
      max = Math.max(max, nums[i]);
      prefixMax[i] = max;
    }

    suffixMin[0] = nums[len - 1];
    var min = nums[len - 1];
    for (var i = len - 1; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      suffixMin[i] = min;
    }

    for (var i = 0; i < len - 1; i++) {
      if (prefixMax[i] <= suffixMin[i + 1]) {
        return i + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(partitionDisjoint(new int[]{5,0,3,8,6}));
  }
}
