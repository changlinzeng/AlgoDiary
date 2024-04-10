package algo.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WiggleSort_II_324 {
  public static void wiggleSort(int[] nums) {
    var len = nums.length;
    var pq = new PriorityQueue<Integer>((a, b) -> b - a);
    for (var n : nums) {
      pq.offer(n);
    }

    for (var i = 1; i < len; i = i + 2) {
      nums[i] = pq.poll();
    }

    for (var i = 0; i < len; i = i + 2) {
      nums[i] = pq.poll();
    }
  }

  public static void main(String[] args) {
//    var nums = new int[]{1,4,5,6,1,1};
//    var nums = new int[]{1,4,5,6,2,1,1};
//    var nums = new int[]{1,1,2,1,2,2,1};
    var nums = new int[]{4,5,5,6};
    wiggleSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
