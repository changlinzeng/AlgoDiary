package data.priorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler_621 {
  public static int leastInterval(char[] tasks, int n) {
    var count = new HashMap<Character, Integer>();
    for (var c : tasks) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    var pq = new PriorityQueue<Character>((a, b) -> count.get(b) - count.get(a));
    for (var k : count.keySet()) {
      pq.offer(k);
    }

    var units = 0;
//    while (!pq.isEmpty()) {
//      // pop n + 1 chars
//      var group = new ArrayList<Character>();
//      for (var i = 0; i <= n; i++) {
//        if (!pq.isEmpty()) {
//          var t = pq.poll();
//          units++;
//          count.put(t, count.get(t) - 1);
//          if (count.get(t) > 0) {
//            group.add(t);
//          }
//        } else {
//          if (!group.isEmpty()) {
//            units++;
//          }
//        }
//      }
//      group.forEach(pq::offer);
//    }

    while (!pq.isEmpty()) {
      var list = new ArrayList<Character>();
      var size = Math.min(n + 1, pq.size());
      for (var i = 0; i < size; i++) {
        var task = pq.poll();
        count.put(task, count.get(task) - 1);
        if (count.get(task) > 0) {
          list.add(task);
        }
      }
      pq.addAll(list);
      if (pq.isEmpty()) {
        units += size;
      } else {
        units += n + 1;
      }
    }

    return units;
  }

  public static void main(String[] args) {
    System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
  }
}
