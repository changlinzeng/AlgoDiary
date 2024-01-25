package data.hashMap;

import java.util.HashMap;

public class KDiffPairsInAnArray_532 {
  public static int findPairs(int[] nums, int k) {
    int count = 0;
    var map = new HashMap<Integer, Integer>();

    for (var n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    for (var key : map.keySet()) {
      if (k == 0 && map.get(key) > 1) {
        count++;
      } else {
        if (k > 0 && map.containsKey(key + k)) {
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
  }
}