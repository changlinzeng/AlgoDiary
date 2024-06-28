package algo.prefixSum;

import java.util.HashMap;

public class ContinuousSubarraySum_523 {
  public static boolean checkSubarraySum(int[] nums, int k) {
    var modMap = new HashMap<Integer, Integer>();
    var sum = 0;
    modMap.put(0, 0);  // add mod 0
    for (var i = 0; i < nums.length; i++) {
      sum += nums[i];
      var mod = sum % k;
      if (modMap.containsKey(mod) && modMap.get(mod) < i) {
        return true;
      } else {
        modMap.putIfAbsent(mod, i + 1);
      }
    }
    return false;
  }
}
