package data.priorityQueue;

import java.util.PriorityQueue;

public class LongestHappyString_1405 {
  public static String longestDiverseString(int a, int b, int c) {
    var count = new int[]{a, b, c};
    var pq = new PriorityQueue<Character>((m, n) -> count[n - 'a'] - count[m - 'a']);
    for (var i = 0; i < 3; i++) {
      if (count[i] > 0) {
        pq.offer((char)('a' + i));
      }
    }

    var happy = "";
    while (!pq.isEmpty()) {
      var ch = pq.poll();
      var len = happy.length();
      if (happy.length() > 1 && happy.charAt(len - 1) == happy.charAt(len - 2) && ch == happy.charAt(len - 1)) {
        if (pq.isEmpty()) {
          return happy;
        }
        var ch2 = pq.poll();
        happy += ch2;
        count[ch2 - 'a']--;
        pq.offer(ch);
        if (count[ch2 - 'a'] > 0) {
          pq.offer(ch2);
        }
      } else {
        var consume = 2;
        if (!happy.isEmpty() && ch == happy.charAt(len - 1)) {
          consume = 1;
        }
        consume = Math.min(consume, count[ch - 'a']);
        happy += String.valueOf(ch).repeat(consume);
        count[ch - 'a'] -= consume;
        if (count[ch - 'a'] > 0) {
          pq.offer(ch);
        }
      }
    }
    return happy;
  }

  public static void main(String[] args) {
    System.out.println(longestDiverseString(1, 1, 7));
    System.out.println(longestDiverseString(2, 2, 1));
  }
}
