package algo.prefixSum;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
  public int subarraySum(int[] nums, int k) {
    var count = 0;
    // map of {sum -> occurrence of this sum} as sums may duplicate because numbers contain negative
    var prefixSum = new HashMap<Integer, Integer>();
    prefixSum.put(0, 1);

    var sum = 0;
    for (int num : nums) {
      sum += num;
      if (prefixSum.containsKey(sum - k)) {
        count += prefixSum.get(sum - k);
      }
      prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
