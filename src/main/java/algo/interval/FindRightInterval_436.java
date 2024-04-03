package algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindRightInterval_436 {
  public static int[] findRightInterval(int[][] intervals) {
    var len = intervals.length;
    var startPosition = new HashMap<Integer, Integer>();

    // record position of each interval start
    var maxStart = 0;
    for (var i = 0; i < len; i++) {
      startPosition.put(intervals[i][0], i);
      maxStart = Math.max(maxStart, intervals[i][0]);
    }

    var result = new int[len];
    Arrays.fill(result, -1);
    for (var i = 0; i < len; i++) {
      var interval = intervals[i];
      // find the smallest start
      for (var j = interval[1]; j <= maxStart; j++) {
        if (startPosition.containsKey(j)) {
          result[i] = startPosition.get(j);
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] right;
//    right = findRightInterval(new int[][]{{1,2}});
//    right = findRightInterval(new int[][]{{3,4}, {2,3}, {1,2}});
//    right = findRightInterval(new int[][]{{1,4}, {2,3}, {3,4}});
    right = findRightInterval(new int[][]{{1,1}, {3,4}});
    for (var n : right) {
      System.out.println(n);
    }
  }
}
