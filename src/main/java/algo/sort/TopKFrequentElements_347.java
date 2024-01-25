package algo.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {
  public static int[] topKFrequent(int[] nums, int k) {
    var freq = new HashMap<Integer, Integer>();
    var pq = new PriorityQueue<Integer>(k, Comparator.comparingInt(freq::get));

    for (var i : nums) {
      freq.put(i, freq.getOrDefault(i, 0) + 1);
    }

    for (var key : freq.keySet()) {
      if (pq.size() < k) {
        pq.offer(key);
      } else {
        if (freq.get(pq.peek()) < freq.get(key)) {
          pq.poll();
          pq.offer(key);
        }
      }
    }

    var result = new int[pq.size()];
    var i = 0;
    for (var n : pq) {
      result[i] = n;
      i++;
    }

    return result;
  }

  public static void main(String[] args) {
//    var top = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    var top = topKFrequent(new int[]{1}, 1);
    for (var i : top) {
      System.out.println(i);
    }
  }
}
