package data.priorityQueue;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumArrayLengthAfterPairRemovals_2856 {
  public static int minLengthAfterRemovals(List<Integer> nums) {
    // count frequency of each number and then we get a list of frequencies
    // repeatedly get the first nad second largest and remove pair
    var pq = new PriorityQueue<Integer>((a, b) -> b - a);  // count the frequency of each number
    int i = 0, j = 0;

    // count frequency of each number
    while (i < nums.size()) {
      var current = i;
      var num = nums.get(i);
      while (i < nums.size() && nums.get(i).compareTo(num) == 0) {
        i++;
      }
      pq.offer(i - current);
    }

    while (!pq.isEmpty()) {
      var top = pq.poll();
      if (pq.isEmpty()) {
        return top;
      }
      var next = pq.poll();
      if (top > 1) {
        pq.offer(top - 1);
      }
      if (next > 1) {
        pq.offer(next - 1);
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(minLengthAfterRemovals(List.of(1,3,4,9)));
    System.out.println(minLengthAfterRemovals(List.of(1,1,2)));
    System.out.println(minLengthAfterRemovals(List.of(2,3,4,4,4)));
    System.out.println(minLengthAfterRemovals(List.of(1000000000,1000000000)));
  }
}
