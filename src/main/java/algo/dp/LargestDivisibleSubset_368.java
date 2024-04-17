package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {
  public static List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    var len = nums.length;
    var maxIndex = 0;
    var dp = new ArrayList<List<Integer>>(len);  // set with last element at i
    for (var i = 0; i < len; i++) {
      dp.add(new ArrayList<>());
    }
    dp.get(0).add(nums[0]);

    for (var i = 1; i < len; i++) {
      var idx = -1;
      // find the largest subset ends at j
      for (var j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0 && (idx == -1 || dp.get(j).size() > dp.get(idx).size())) {
          idx = j;
        }
      }
      if (idx != -1) {
        dp.get(i).addAll(dp.get(idx));
      }
      dp.get(i).add(nums[i]);
      if (dp.get(i).size() > dp.get(maxIndex).size()) {
        maxIndex = i;
      }
    }

    return dp.get(maxIndex);
  }

  public static void main(String[] args) {
    System.out.println(largestDivisibleSubset(new int[]{1,2,3}));
    System.out.println(largestDivisibleSubset(new int[]{1,2,4,8}));
    System.out.println(largestDivisibleSubset(new int[]{4,8,10,240}));
    System.out.println(largestDivisibleSubset(new int[]{3,4,6,8,12,16,32}));
  }
}
