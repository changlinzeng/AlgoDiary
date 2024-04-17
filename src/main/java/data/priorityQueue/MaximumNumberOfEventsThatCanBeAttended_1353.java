package data.priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended_1353 {
  public static int maxEvents(int[][] events) {
    var len = events.length;
    var pq = new PriorityQueue<Integer>();  // end day of event
    Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    var endDay = events[len - 1][1];
    var k = 0;
    var count = 0;
    for (var day = 1; day <= endDay + 1; day++) {
      // put events started at day to queue
      while (k < len && events[k][0] == day) {
        pq.offer(events[k][1]);
        k++;
      }

      // remove expired events
      while (!pq.isEmpty() && pq.peek() < day) {
        pq.poll();
      }

      // attend the event that will expire soon
      if (!pq.isEmpty()) {
        pq.poll();
        count++;
      }
    }

    // need to add the events remained the queue after the last day
    return count + pq.size();
  }

  public static void main(String[] args) {
    System.out.println(maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}}));
  }
}
