package algo.interval;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval_57 {
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    var merged = new ArrayList<int[]>();
    int len = intervals.length, start = newInterval[0], end = newInterval[1];
    var result = new int[]{start, end};

    if (len == 0) {
      return new int[][]{{newInterval[0], newInterval[1]}};
    }

    var pos = 0;
    while (pos < len && intervals[pos][0] < start) {
      if (intervals[pos][1] >= start) {
        break;
      }
      merged.add(intervals[pos]);
      pos++;
    }

    // merge intervals[pos] to current
    if (pos < len && intervals[pos][0] <= end) {
      result[0] = Math.min(result[0], intervals[pos][0]);
      result[1] = Math.max(result[1], intervals[pos][1]);
      pos++;
      if (pos < len) {
        if (intervals[pos][0] <= end) {
          while (pos < len && intervals[pos][0] <= end) {
            pos++;
          }
        }
        result[1] = Math.max(result[1], intervals[pos - 1][1]);
      }
    }
    merged.add(result);

    while (pos < len) {
      merged.add(intervals[pos]);
      pos++;
    }

    var arr = new int[merged.size()][];
    return merged.toArray(arr);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{2, 5})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1,5}}, new int[]{2, 7})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
  }
}
