package algo.prefixSum;

public class MaximumSumOfTwoNonOverlappingSubarrays_1031 {
  public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
    var len = nums.length;
    var prefixSum = new int[len + 1];
    for (var i = 0; i < len; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    return Math.max(maxSum(prefixSum, firstLen, secondLen), maxSum(prefixSum, secondLen, firstLen));
  }

  private static int maxSum(final int[] prefixSum, int firstLen, int secondLen) {
    var mid = firstLen;
    var max = 0;
    while (mid < prefixSum.length - secondLen) {
      int lsum = 0, rsum = 0;
      for (var i = firstLen; i <= mid; i++) {
        lsum = Math.max(lsum, prefixSum[i] - prefixSum[i - firstLen]);
      }
      for (var j = mid + secondLen; j < prefixSum.length; j++) {
        rsum = Math.max(rsum, prefixSum[j] - prefixSum[j - secondLen]);
      }
      max = Math.max(max, lsum + rsum);
      mid++;
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 2, 1));
    System.out.println(maxSumTwoNoOverlap(new int[]{3,8,1,3,2,1,8,9,0}, 3, 2));
    System.out.println(maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
  }
}
