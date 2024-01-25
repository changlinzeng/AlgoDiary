package algo.sort;

import java.util.PriorityQueue;

public class KthSmallestPrimeFraction_786 {
  public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
    var stop = false;
    var len = arr.length;
    var queue = new PriorityQueue<int[]>((p1, p2) -> p1[1] * p2[0] - p2[1] * p1[0]);

    for (var i = 0; i < len && !stop; i++) {
      for (var j = len - 1; j > i && !stop; j--) {
        if (queue.size() < k) {
          queue.offer(new int[]{arr[i], arr[j]});
        } else {
          var top = queue.peek();
          if (arr[i] * top[1] - arr[j] * top[0] < 0) {
            queue.poll();
            queue.offer(new int[]{arr[i], arr[j]});
          }
        }
      }
    }

    return queue.peek();
  }

  public static void main(String[] args) {
//    var fraction = kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
//    var fraction = kthSmallestPrimeFraction(new int[]{1, 7}, 1);
    var fraction = kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    System.out.println(fraction[0] + ":" + fraction[1]);
  }
}
