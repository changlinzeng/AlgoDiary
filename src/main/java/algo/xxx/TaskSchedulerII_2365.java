package algo.xxx;

import java.util.Arrays;
import java.util.HashMap;

public class TaskSchedulerII_2365 {
  public static long taskSchedulerII(int[] tasks, int space) {
    int len = tasks.length;
    var last = new HashMap<Integer, Integer>();  // last position of task type
    var breaks = new HashMap<Integer, Integer>();  // days of break after position i
    for (var i = 0; i < len; i++) {
      var task = tasks[i];
      if (last.containsKey(task)) {
        var pos = last.get(task);
        var duration = 0;
        for (var j = i - 1; j >= pos; j--) {
          duration += breaks.getOrDefault(j, 0);
          if (j != pos) {
            duration++;
          }
          if (duration >= space) {
            break;
          }
        }
        // add days before i
        if (duration < space) {
          breaks.put(i - 1, space - duration);
        }
      }
      last.put(tasks[i], i);
    }
    return len + breaks.values().stream().mapToLong(a -> a).sum();
  }

  public static void main(String[] args) {
    System.out.println(taskSchedulerII(new int[]{1,2,1,2,3,1}, 3));
    System.out.println(taskSchedulerII(new int[]{5,8,8,5}, 2));
    System.out.println(taskSchedulerII(new int[]{1,1,1,1,1,1,1,1,1,1}, 10));

    var len = 100000;
    var arr = new int[len];
    Arrays.fill(arr, 1000000000);
    System.out.println(taskSchedulerII(arr, len));
  }
}
