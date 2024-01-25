package data.priorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
  public static int leastInterval(char[] tasks, int n) {
    var count = new HashMap<Character, Integer>();
    for (var c : tasks) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    var pq = new PriorityQueue<Character>((a, b) -> count.get(b) - count.get(a));
    for (var k : count.keySet()) {
      pq.offer(k);
    }

//    var schedule = "";
    var units = 0;
    while (!pq.isEmpty()) {
      // pop n + 1 chars
      var group = new ArrayList<Character>();
      for (var i = 0; i <= n; i++) {
        if (!pq.isEmpty()) {
          var t = pq.poll();
//          schedule += t;
          units++;
          count.put(t, count.get(t) - 1);
          if (count.get(t) > 0) {
            group.add(t);
          }
        } else {
          if (!group.isEmpty()) {
//            schedule += "0";
            units++;
          }
        }
      }
      group.forEach(pq::offer);
    }

    return units;
//    return schedule.length();
  }

  public static void main(String[] args) {
    System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
  }
}
