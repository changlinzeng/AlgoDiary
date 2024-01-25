package algo.sequence;

import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights_846 {
  public static boolean isNStraightHand(int[] hand, int groupSize) {
    var len = hand.length;
    if (len < groupSize || len % groupSize != 0) {
      return false;
    }
    if (len == 1 || groupSize == 1) {
      return true;
    }

    Arrays.sort(hand);

    var freq = new HashMap<Integer, Integer>();
    for (var n : hand) {
      freq.put(n, freq.getOrDefault(n, 0) + 1);
    }

    var groupNum = len / groupSize;
    var groupCount = 0;
    for (var h : hand) {
      if (freq.get(h) > 0) {
        if (groupCount > groupNum) {
          return false;
        }
        for (var i = 0; i < groupSize; i++) {
          var next = h + i;
          if (!freq.containsKey(next) || freq.get(next) == 0) {
            return false;
          }
          freq.put(next, freq.get(next) - 1);
        }
        groupCount++;
      }
    }

    return groupCount == groupNum;
  }

  public static void main(String[] args) {
    System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    System.out.println(isNStraightHand(new int[]{1,2}, 2));
    System.out.println(isNStraightHand(new int[]{6,7,5,3,4,7,8,10,9,6}, 5));
  }
}
