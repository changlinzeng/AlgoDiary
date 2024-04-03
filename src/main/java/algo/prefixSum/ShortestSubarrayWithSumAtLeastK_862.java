package algo.prefixSum;

import java.util.ArrayDeque;

public class ShortestSubarrayWithSumAtLeastK_862 {
  public static int shortestSubarray(int[] nums, int k) {
    var len = nums.length;
    var q = new ArrayDeque<Integer>();  // increasing queue
    var sum = new long[len + 1];  // prefix sum at i
    for (var i = 0; i < len; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }

    var shortest = Integer.MAX_VALUE;
    for (var i = 0; i <= len; i++) {
      while (!q.isEmpty() && sum[i] < sum[q.getLast()]) {
        q.pollLast();
      }
      q.offerLast(i);
      while (!q.isEmpty() && sum[i] - sum[q.getFirst()] >= k) {
        shortest = Math.min(shortest, i - q.getFirst());
        q.pollFirst();
      }
    }
    return shortest != Integer.MAX_VALUE ? shortest : -1;
  }

  public static void main(String[] args) {
    System.out.println(shortestSubarray(new int[]{1}, 1));
    System.out.println(shortestSubarray(new int[]{1,2}, 4));
    System.out.println(shortestSubarray(new int[]{2,-1,2}, 3));
    System.out.println(shortestSubarray(new int[]{17,85,93,-45,-21}, 150));
    System.out.println(shortestSubarray(new int[]{56,-21,56,35,-9}, 61));
    System.out.println(shortestSubarray(new int[]{-28,81,-20,28,-29}, 89));
    System.out.println(shortestSubarray(new int[]{-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6}, 151));
  }
}
