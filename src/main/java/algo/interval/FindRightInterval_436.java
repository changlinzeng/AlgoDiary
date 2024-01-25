package algo.interval;

import java.util.ArrayList;
import java.util.Comparator;

public class FindRightInterval_436 {
  public static int[] findRightInterval(int[][] intervals) {
    var size= intervals.length;
    var intervalList = new ArrayList<int[]>();
    for (var i = 0; i < size; i++) {
      intervalList.add(new int[]{intervals[i][0], intervals[i][1], i});
    }

    // sort with interval start
    intervalList.sort(Comparator.comparingInt(i -> i[0]));

    var right = new ArrayList<int[]>();
    for (var i = 0; i < size; i++) {
      var cur = intervalList.get(i);
      var j = i;
      while(j < size && intervalList.get(j)[0] < cur[1]) {
        j++;
      }
      var next = j < size ? intervalList.get(j)[2] : -1;
      right.add(new int[]{cur[2], next});
    }

    right.sort(Comparator.comparingInt(i -> i[0]));
    var result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = right.get(i)[1];
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
