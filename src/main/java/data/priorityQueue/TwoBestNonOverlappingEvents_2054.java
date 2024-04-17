package data.priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents_2054 {
  public static int maxTwoEvents(int[][] events) {
    int leftMaxVal = 0, best = 0;
    var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));  // [event end, value]
    Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

    for (var event : events) {
      // find max value event before current event
      while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
        leftMaxVal = Math.max(leftMaxVal, pq.poll()[1]);
      }
      best = Math.max(best, leftMaxVal + event[2]);
      pq.offer(new int[]{event[1], event[2]});
    }

    return best;
  }

  public static void main(String[] args) {
    System.out.println(maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{2,4,3}}));
    System.out.println(maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{1,5,5}}));
    System.out.println(maxTwoEvents(new int[][]{{1,5,3},{1,5,1},{6,6,5}}));
    System.out.println(maxTwoEvents(new int[][]{{10,83,53},{63,87,45},{97,100,32},{51,61,16}}));
  }
}
