package data.hashMap;

import java.util.Arrays;
import java.util.HashMap;

public class DivideArrayInSetsOfKConsecutiveNumbers_1296 {
  public static boolean isPossibleDivide(int[] nums, int k) {
    if (nums.length % k != 0) {
      return false;
    }
    var count = new HashMap<Integer, Integer>();
    for (var n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    Arrays.sort(nums);
    for (var n : nums) {
      if (count.get(n) > 0) {
        var numInGroup = 0;
        var next = n;
        while (count.getOrDefault(next, 0) > 0 && numInGroup < k) {
          count.put(next, count.get(next) - 1);
          numInGroup++;
          next++;
        }
        if (numInGroup < k) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
    System.out.println(isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
    System.out.println(isPossibleDivide(new int[]{1,2,3,4}, 3));
  }
}
