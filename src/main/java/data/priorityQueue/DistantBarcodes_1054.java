package data.priorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class DistantBarcodes_1054 {
  public int[] rearrangeBarcodes(int[] barcodes) {
    var count = new HashMap<Integer, Integer>();
    var pq = new PriorityQueue<Integer>((a, b) -> count.get(b) - count.get((a)));
    for (var code : barcodes) {
      count.put(code, count.getOrDefault(code, 0) + 1);
    }

    count.keySet().forEach(pq::offer);

    var rearranged = new int[barcodes.length];
    var idx = 0;
    while (!pq.isEmpty()) {
      var first = pq.poll();
      count.put(first, count.get(first) - 1);
      rearranged[idx] = first;

      var second = -1;
      if (!pq.isEmpty()) {
        second = pq.poll();
        count.put(second, count.get(second) - 1);
        rearranged[++idx] = second;
      }
      idx++;

      if (count.get(first) > 0)
      {
        pq.offer(first);
      }
      if (second != -1 && count.get(second) > 0) {
        pq.offer(second);
      }
    }
    return rearranged;
  }
}
