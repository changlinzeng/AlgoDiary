package data.hashMap;

import java.util.HashMap;

public class CheckIfArrayPairsAreDivisiblebyK_1497 {
  public static boolean canArrange(int[] arr, int k) {
    // Let a % k = x, b % k = y. If (a + b) % k == 0, then x + y == k
    var modMap = new HashMap<Integer, Integer>();  // mod of a % k
    for (var num : arr) {
      var mod = num % k;
      if (mod < 0) {
        mod += k;
      }
      modMap.put(mod, modMap.getOrDefault(mod, 0) + 1);
    }

    // count of mod 0 should be even to be paired
    if (modMap.getOrDefault(0, 0) % 2 != 0) {
      return false;
    }

    // number of mod and k - mod should equal to be paired
    for (var mod : modMap.keySet()) {
      if (mod != 0 && !modMap.get(mod).equals(modMap.get(k - mod))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
    System.out.println(canArrange(new int[]{1,2,3,4,5,6}, 7));
    System.out.println(canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
  }
}
