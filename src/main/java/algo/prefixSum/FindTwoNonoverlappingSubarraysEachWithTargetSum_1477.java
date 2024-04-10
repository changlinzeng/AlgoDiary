package algo.prefixSum;

import java.util.HashMap;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum_1477 {
  public static int minSumOfLengths(int[] arr, int target) {
    var len = arr.length;

    var prefixSum = new HashMap<Integer, Integer>();  // {sum -> position}
    var prefix = new int[len];  // min len subarray sum to K at position i
    var sum = 0;
    for (var i = 0; i < len; i++) {
      sum += arr[i];
      prefixSum.put(sum, i);
      if (sum == target) {
        prefix[i] = i + 1;
      } else {
        if (prefixSum.containsKey(sum - target)) {
          if (prefix[i - 1] > 0) {
            prefix[i] = Math.min(prefix[i - 1], i - prefixSum.get(sum - target));
          } else {
            prefix[i] = i - prefixSum.get(sum - target);
          }
        } else {
          if (i > 0) {
            prefix[i] = prefix[i - 1];
          }
        }
      }
    }

    var suffixSum = new HashMap<Integer, Integer>();
    var suffix = new int[len];
    sum = 0;
    for (var i = len - 1; i >= 0; i--) {
      sum += arr[i];
      suffixSum.put(sum, i);
      if (sum == target) {
        suffix[i] = len - i;
      } else {
        if (suffixSum.containsKey(sum - target)) {
          if (suffix[i + 1] > 0) {
            suffix[i] = Math.min(suffix[i + 1], suffixSum.get(sum - target) - i);
          } else {
            suffix[i] = suffixSum.get(sum - target) - i;
          }
        } else {
          if (i < len - 1) {
            suffix[i] = suffix[i + 1];
          }
        }
      }
    }

    var minLen = Integer.MAX_VALUE;
    for (var i = 0; i < len - 1; i++) {
      if (prefix[i] > 0 && suffix[i + 1] > 0) {
        minLen = Math.min(minLen, prefix[i] + suffix[i + 1]);
      }
    }
    return minLen == Integer.MAX_VALUE ? -1 : minLen;
  }

  public static void main(String[] args) {
    System.out.println(minSumOfLengths(new int[]{3,2,2,4,3}, 3));
    System.out.println(minSumOfLengths(new int[]{4,3,2,6,2,3,4}, 6));
    System.out.println(minSumOfLengths(new int[]{3,1,1,1,5,1,2,1}, 3));
    System.out.println(minSumOfLengths(new int[]{1,2,2,3,2,6,7,2,1,4,8}, 5));
  }
}
