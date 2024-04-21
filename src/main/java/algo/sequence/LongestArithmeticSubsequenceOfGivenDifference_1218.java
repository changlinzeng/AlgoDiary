package algo.sequence;

import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifference_1218 {
  public static int longestSubsequence(int[] arr, int difference) {
    var maxArrLen = new HashMap<Integer, Integer>();  // max length of array ends with num
    var maxLen = 0;
    for (var num : arr) {
      var prev = num - difference;
      if (maxArrLen.containsKey(prev)) {
        var len = 0;
        if (maxArrLen.containsKey(num)) {
          len = Math.max(maxArrLen.get(num), maxArrLen.get(prev) + 1);
        } else {
          len = maxArrLen.get(prev) + 1;
        }
        maxArrLen.put(num, len);
        maxLen = Math.max(maxLen, len);
      }
      maxArrLen.putIfAbsent(num, 1);
      maxLen = Math.max(1, maxLen);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestSubsequence(new int[]{1,2,3,4}, 1));
    System.out.println(longestSubsequence(new int[]{1,3,5,7}, 1));
    System.out.println(longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    System.out.println(longestSubsequence(new int[]{-9,-12,-12,8,8}, 0));
  }
}
