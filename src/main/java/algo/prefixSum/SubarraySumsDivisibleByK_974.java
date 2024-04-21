package algo.prefixSum;

import java.util.HashMap;

public class SubarraySumsDivisibleByK_974 {
  public static int subarraysDivByK(int[] nums, int k) {
    var count = 0;
    long sum = 0;
    var prefixMod = new HashMap<Integer, Integer>();  // mod of k -> count of mod
    for (int num : nums) {
      sum += num;
      var mod = (int) (sum % k);
      if (mod < 0) {
        mod += k;
      }
      if (mod == 0) {
        count++;
      }
      if (prefixMod.containsKey(mod)) {
        count += prefixMod.get(mod);
      }
      prefixMod.put(mod, prefixMod.getOrDefault(mod, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
  }
}
