package algo.dp;

public class MaximumAbsoluteSumOfAnySubarray_1749 {
  public int maxAbsoluteSum(int[] nums) {
    // calculate max and min sum at each index and compare the diff
    int max = 0, min = 0;
    var sum = 0;
    var absSum = 0;
    for (var n : nums) {
      sum += n;
      max = Math.max(max, sum);
      min = Math.min(min, sum);
      absSum = Math.max(absSum, max - min);
    }
    return absSum;
  }
}
