package algo.prefixSum;

import java.util.HashMap;

public class ContiguousArray_525 {
  public static int findMaxLength(int[] nums) {
    var len = nums.length;
    var diffs = new HashMap<Integer, Integer>();  // diff between numbers of 0 and 1 at position i
    var diff = 0;
    var maxLen = 0;
    for (var i = 0; i < len; i++) {
      if (nums[i] == 0) {
        diff++;
      } else {
        diff--;
      }
      if (diff == 0) {
        // there are equal numbers of 0 and 1
        maxLen = Math.max(maxLen, i + 1);
      } else {
        if (!diffs.containsKey(diff)) {
          diffs.put(diff, i);
        } else {
          // find the first position who has the same diff
          maxLen = Math.max(maxLen, i - diffs.get(diff));
        }
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(findMaxLength(new int[]{0,1}));
    System.out.println(findMaxLength(new int[]{0,1,0}));
    System.out.println(findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
    System.out.println(findMaxLength(new int[]{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));
    System.out.println(findMaxLength(new int[]{0,0,1}));
  }
}
