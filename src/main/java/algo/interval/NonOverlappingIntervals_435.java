package algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals_435 {
  public static int eraseOverlapIntervals(int[][] intervals) {
    // sort with interval end
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

    int[] prev = intervals[0];
    int removed = 0;
    for (var i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < prev[1]) {
          //remove current interval
          removed++;
        } else {
          prev = intervals[i];
        }
    }

    return removed;
  }

  public static void main(String[] args) {
    System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}));
    System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {1,2}, {1,2}}));
    System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2,3}}));
  }
}
