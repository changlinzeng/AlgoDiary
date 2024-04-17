package data.hashMap;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSquareStreakInAnArray_2501 {
  public static int longestSquareStreak(int[] nums) {
    var count = new HashMap<Long, Integer>();
    var maxLen = 0;

    for (var n : nums) {
      count.put((long) n, count.getOrDefault((long)n, 0) + 1);
    }

    Arrays.sort(nums);
    for (int num : nums) {
      if (count.get((long)num) > 0) {
        var llen = 1;
        var square = (long) num * num;
        while (count.containsKey(square) && count.get(square) > 0) {
          llen++;
          count.put(square, count.get(square) - 1);
          square *= square;
        }
        maxLen = Math.max(maxLen, llen);
      }
    }

    return maxLen == 1 ? -1 : maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestSquareStreak(new int[]{4,3,6,16,8,2}));
    System.out.println(longestSquareStreak(new int[]{2,3,5,6,7}));
  }
}
