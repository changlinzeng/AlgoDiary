package data.hashMap;

import java.util.HashMap;

public class MaxNumberOfKSumPairs_1679 {
  public static int maxOperations(int[] nums, int k) {
    var map = new HashMap<Integer, Integer>();
    int count = 0;

    for (var n : nums) {
      if (map.containsKey(k - n) && map.get(k - n) != 0) {
        count++;
        map.put(k - n, map.get(k - n) - 1);
      } else {
        map.put(n, map.getOrDefault(n, 0) + 1);
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(maxOperations(new int[]{1,2,3,4}, 5));
    System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
    System.out.println(maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));
  }
}
