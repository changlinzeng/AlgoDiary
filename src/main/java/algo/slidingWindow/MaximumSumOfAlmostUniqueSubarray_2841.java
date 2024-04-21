package algo.slidingWindow;

import java.util.HashMap;
import java.util.List;

public class MaximumSumOfAlmostUniqueSubarray_2841 {
  public static long maxSum(List<Integer> nums, int m, int k) {
    var len = nums.size();
    var count = new HashMap<Integer, Integer>();
    long maxSum = 0;
    long sum = 0;
    for (var i = 0; i < len; i++) {
      var num = nums.get(i);
      if (i >= k) {
        var prev = nums.get(i - k);
        sum -= prev;
        count.put(prev, count.get(prev) - 1);
        if (count.get(prev) == 0) {
          count.remove(prev);
        }
      }
      sum += num;
      count.put(num, count.getOrDefault(num, 0) + 1);
      if (count.size() >= m) {
        maxSum = Math.max(maxSum, sum);
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(maxSum(List.of(2,6,7,3,1,7), 3, 4));
    System.out.println(maxSum(List.of(5,9,9,2,4,5,4), 1, 3));
  }
}
