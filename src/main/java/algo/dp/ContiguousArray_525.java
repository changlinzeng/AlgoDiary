package algo.dp;

import java.util.HashMap;

public class ContiguousArray_525 {
  public static int findMaxLength(int[] nums) {
    //  0    0    1   1    0    1    0    0    0    0    1    1    0    1
    //  0    0    2   4    4    6    6    6    6    6    6    10   10   12
    //  1,0  2,0  2,1 2,2  3,2  3,3  4,3  5,3  6,3  7,3  7,4  7,5  8,5  8,6
    //                                                   i - 2 * 4

    var len = nums.length;
    var diffs = new HashMap<Integer, Integer>();  // diff between numbers of 0 and 1 at position i
    var dp = new int[len];
    dp[0] = 0;
    var diff = nums[0] == 0 ? 1 : -1;
    diffs.put(diff, 0);
    for (var i = 1; i < len; i++) {
      var num = nums[i];
      if (num == 0) {
        diff++;
      } else {
        diff--;
      }
      if (diff == 0) {
        // there are equal numbers of 0 and 1
        dp[i] = i + 1;
      } else {
        if (!diffs.containsKey(diff)) {
          diffs.put(diff, i);
          dp[i] = dp[i - 1];
        } else {
          // find the first position who has the same diff
          var start = diffs.get(diff);
          dp[i] = Math.max(dp[i - 1], i - start);
        }
      }
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
//    System.out.println(findMaxLength(new int[]{0,1}));
//    System.out.println(findMaxLength(new int[]{0,1,0}));
//    System.out.println(findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
//    System.out.println(findMaxLength(new int[]{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));
    System.out.println(findMaxLength(new int[]{0,0,1}));
  }
}
