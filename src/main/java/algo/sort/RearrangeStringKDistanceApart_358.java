package algo.sort;

import java.util.*;

public class RearrangeStringKDistanceApart_358 {
  public static String rearrangeString(String str, int k) {
    var freq = new HashMap<Character, Integer>();
    var pq = new PriorityQueue<Character>((a, b) -> {
      if (Objects.equals(freq.get(b), freq.get(a))) {
        return a - b;
      }
      return freq.get(b) - freq.get(a);
    });
    for (var c : str.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }
    freq.keySet().forEach(pq::offer);

    var left = str.length();
    var result = "";
    while (!pq.isEmpty()) {
      var size = Math.min(left, k);
      var q = new ArrayList<Character>();
      if (pq.size() < size) {
        return "";
      }
      for (var i = 0; i < size; i++) {
        var c = pq.poll();
        result += c;
        freq.put(c, freq.get(c) - 1);
        if (freq.get(c) > 0) {
          q.add(c);
        }
        left--;
      }
      q.forEach(pq::offer);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(rearrangeString("aabbcc", 3));
    System.out.println(rearrangeString("aaabc", 3));
    System.out.println(rearrangeString("aaadbbcc", 2));
  }
}
