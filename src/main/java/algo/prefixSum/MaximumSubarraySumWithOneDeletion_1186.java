package algo.prefixSum;

public class MaximumSubarraySumWithOneDeletion_1186 {
  // calculate the max sum of subarray ends at i -1 and max sum of subarray starts at i + 1
  public static int maximumSum(int[] arr) {
    var len = arr.length;
    var maxSum = arr[0];
    var prefixMax = new int[len];  // max sum of subarray ends at i
    var suffixMax = new int[len];  // max sum of subarray starts at i
    prefixMax[0] = arr[0];
    suffixMax[len - 1] = arr[len - 1];
    for (var i = 1; i < len; i++) {
      prefixMax[i] = Math.max(prefixMax[i - 1] + arr[i], arr[i]);
      // max sum without removing any element
      // remove the last element is included in this case
      maxSum = Math.max(maxSum, prefixMax[i]);
    }
    for (var i = len - 2; i >= 0; i--) {
      suffixMax[i] = Math.max(suffixMax[i + 1] + arr[i], arr[i]);
      // max sum without removing any element
      // remove first element is included in this case
      maxSum = Math.max(maxSum, suffixMax[i]);
    }

    // remove from 1 to len - 2
    for (var i = 1; i <= len - 2; i++) {
      maxSum = Math.max(maxSum, prefixMax[i - 1] + suffixMax[i + 1]);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(maximumSum(new int[]{1,-2,0,3}));
    System.out.println(maximumSum(new int[]{1,-2,-2,3}));
    System.out.println(maximumSum(new int[]{-1,-1,-1,-1}));
  }
}
