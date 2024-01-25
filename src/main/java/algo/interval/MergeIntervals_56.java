package algo.interval;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals_56 {
  public static int[][] merge(int[][] intervals) {
    var result = new ArrayList<int[]>();
    Arrays.sort(intervals, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });

    var len = intervals.length;
    var merged = intervals[0];
    for (var i = 1; i < len; i++) {
      var interval = intervals[i];
      if (interval[0] <= merged[1]) {
        merged[1] = Math.max(merged[1], interval[1]);
      } else {
        result.add(merged);
        merged = interval;
      }
    }
    result.add(merged);

    var arr = new int[result.size()][];
    return result.toArray(arr);
  }

  public static void main(String[] args) {
//    var res = merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    var res = merge(new int[][]{{1,4},{4,5}});
    for (var e : res) {
      System.out.println(e[0] + ":" + e[1]);
    }
  }
}
