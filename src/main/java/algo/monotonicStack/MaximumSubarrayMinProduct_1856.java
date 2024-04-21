package algo.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumSubarrayMinProduct_1856 {
  public static int maxSumMinProduct(int[] nums) {
    // it is the same as Largest Rectangle In Histogram - 84
    var arr = Arrays.copyOf(nums, nums.length + 1);
    arr[arr.length - 1] = -1;

    var len = arr.length;
    var mod = 1_000_000_007;
    long maxProduct = 0;
    var maxStack = new Stack<Integer>();
    var prefixSum = new long[len];
    for (var i = 0; i < len; i++) {
      if (i == 0) {
        maxStack.push(i);
        prefixSum[i] = arr[i];
      } else {
        prefixSum[i] += prefixSum[i - 1] + arr[i];
        var prev = -1;
        while (!maxStack.isEmpty() && arr[maxStack.peek()] >= arr[i]) {
          // calculate product from prev to i - 1
          // prev to i - 1 is increasing and so prev is the min val
          prev = maxStack.pop();
          if (prev > 0) {
            maxProduct = Math.max(maxProduct, (long) (prefixSum[i - 1] - prefixSum[prev - 1]) * arr[prev]);
          } else {
            maxProduct = Math.max(maxProduct, (long) (prefixSum[i - 1]) * arr[prev]);
          }
        }
        if (prev != -1) {
          // calculate product from prev to i. now i is the smallest element
          maxProduct = Math.max(maxProduct, (long) (prefixSum[i] - prefixSum[prev] + arr[prev]) * arr[i]);
          // update arr[prev] to keep the index
          arr[prev] = arr[i];
          maxStack.push(prev);
        }
        maxStack.push(i);
      }
    }
    return (int) (maxProduct % mod);
  }

  public static void main(String[] args) {
    System.out.println(maxSumMinProduct(new int[]{1,2,3,2}));
    System.out.println(maxSumMinProduct(new int[]{2,3,3,1,2}));
    System.out.println(maxSumMinProduct(new int[]{1,1,3,2,2,2,1,5,1,5}));
    System.out.println(maxSumMinProduct(new int[]{2,5,4,2,4,5,3,1,2,4}));
    System.out.println(maxSumMinProduct(new int[]{3,3,2,2,3,1,1,4,1,3}));
    System.out.println(maxSumMinProduct(new int[]{4,10,6,4,8,7,8,3,5,3,4,9,9,5,10,7,10,7,6,4}));
  }
}
