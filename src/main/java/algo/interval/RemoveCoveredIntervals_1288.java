package algo.interval;

import java.util.Arrays;

public class RemoveCoveredIntervals_1288 {

  public static int removeCoveredIntervals(int[][] intervals) {
    var sorted = Arrays.stream(intervals).sorted((a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    }).toList();

    var last = sorted.getFirst();
    var toRemove = 0;
    for (var i = 1; i < sorted.size(); i++) {
      var interval = sorted.get(i);
      if (interval[0] >= last[0] && interval[1] <= last[1]) {
        toRemove++;
      } else if (last[0] >= interval[0] && last[1] <= interval[1]) {
        toRemove++;
        last = interval;
      } else {
        last = interval;
      }
    }
    return intervals.length - toRemove;
  }

  public static void main(String[] args) {
    System.out.println(removeCoveredIntervals(new int[][]{{1,4}, {3,6}, {2,8}}));
  }
}
