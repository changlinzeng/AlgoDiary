package data.priorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString_767 {
  public static String reorganizeString(String s) {
    var count = new HashMap<Character, Integer>();
    for (var c : s.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    var pq = new PriorityQueue<Character>((a, b) -> count.get(b) - count.get(a));
    for (var k : count.keySet()) {
      pq.offer(k);
    }

    var reorg = "";
    while (!pq.isEmpty()) {
      if (pq.size() == 1 && count.get(pq.peek()) > 1) {
        return "";
      }
      // pop 2 chars
      var group = new ArrayList<Character>();
      for (var i = 0; i < 2; i++) {
        if (!pq.isEmpty()) {
          var t = pq.poll();
          reorg += t;
          count.put(t, count.get(t) - 1);
          if (count.get(t) > 0) {
            group.add(t);
          }
        }
      }
      group.forEach(pq::offer);
    }

    return reorg;
  }

  public static void main(String[] args) {
    System.out.println(reorganizeString("aab"));
    System.out.println(reorganizeString("aaab"));
  }
}
