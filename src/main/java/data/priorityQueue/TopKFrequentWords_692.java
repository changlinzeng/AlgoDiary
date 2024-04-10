package data.priorityQueue;

import java.util.*;

public class TopKFrequentWords_692 {
  public static List<String> topKFrequent(String[] words, int k) {
    var result = new ArrayList<String>();
    var freq = new HashMap<String, Integer>();
    var queue = new PriorityQueue<String>((a, b) -> {
      if (freq.get(b) == freq.get(a)) {
        return a.compareTo(b);
      } else {
        return freq.get(b) - freq.get(a);
      }
    });

    for (var word : words) {
      freq.put(word, freq.getOrDefault(word, 0) + 1);
    }

    for (var w : freq.keySet()) {
      queue.offer(w);
    }

    for (int i = 0; i < k; i++) {
      result.add(queue.poll());
    }

    return result;
  }

  public static void main(String[] args) {
//    var words = topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2);
    var words = topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4);
    for (var w : words) {
      System.out.println(w);
    }
  }
}
