package algo.interval;

import java.util.ArrayList;

public class IntervalListIntersections_986 {
  public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    var intersections = new ArrayList<int[]>();
    int i = 0, j = 0;
    int start, end;
    while (i < firstList.length && j < secondList.length) {
      start = Math.max(firstList[i][0], secondList[j][0]);
      end = Math.min(firstList[i][1], secondList[j][1]);
      if (start <= end) {
        intersections.add(new int[]{start, end});
      }
      if (firstList[i][1] <= secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    var result = new int[intersections.size()][];
    for (i = 0; i < intersections.size(); i++) {
      result[i] = intersections.get(i);
    }

    return result;
  }
}
