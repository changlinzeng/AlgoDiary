package algo.interval;

import java.util.ArrayList;
import java.util.Comparator;

public class NonOverlappingIntervals_435 {
  public static int eraseOverlapIntervals(int[][] intervals) {
    var intervalList = new ArrayList<int[]>();
    for (var interval : intervals) {
      intervalList.add(interval);
    }

    // sort with interval end
    intervalList.sort(Comparator.comparingInt(i -> i[1]));

    int[] prev = null;
    int removed = 0;
    for (var interval : intervalList) {
      if (prev == null) {
        prev = interval;
      } else {
        // compare with prev interval
        if (interval[0] < prev[1]) {
          //remove current interval
          removed++;
        } else {
          prev = interval;
        }
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
