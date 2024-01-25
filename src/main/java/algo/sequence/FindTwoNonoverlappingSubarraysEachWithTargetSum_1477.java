package algo.sequence;

import java.util.HashMap;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum_1477 {
  public static int minSumOfLengths(int[] arr, int target) {
    var len = arr.length;
    var prefixSum = new HashMap<Integer, Integer>();  // {sum -> position}
    var suffixSum = new HashMap<Integer, Integer>();
    var prefix = new int[len];  // min len sum to K at position i
    var suffix = new int[len];
    var psum = arr[0];
    prefixSum.put(psum, 0);
    prefix[0] = arr[0] == target ? 1 : 0;
    for (var i = 1; i < len; i++) {
      psum += arr[i];
      prefixSum.put(psum, i);
      if (arr[i] == target) {
        prefix[i] = 1;
      } else if (arr[i] < target) {
        if (psum == target) {
          prefix[i] = i + 1;
        } else {
          if (prefixSum.containsKey(psum - target)) {
            if (prefix[i - 1] > 0) {
              prefix[i] = Math.min(prefix[i - 1], i - prefixSum.get(psum - target));
            } else {
              prefix[i] = i - prefixSum.get(psum - target);
            }
          } else {
            prefix[i] = prefix[i - 1];
          }
        }
      } else {
        prefix[i] = prefix[i - 1];
      }
    }

    psum = arr[len - 1];
    suffixSum.put(psum, len - 1);
    suffix[len - 1] = arr[len - 1] == target ? 1 : 0;
    for (var i = len - 2; i >= 0; i--) {
      psum += arr[i];
      suffixSum.put(psum, i);
      if (arr[i] == target) {
        suffix[i] = 1;
      } else if (arr[i] < target) {
        if (psum == target) {
          suffix[i] = len - i;
        } else {
          if (suffixSum.containsKey(psum - target)) {
            if (suffix[i + 1] > 0) {
              suffix[i] = Math.min(suffix[i + 1], suffixSum.get(psum - target) - i);
            } else {
              suffix[i] = suffixSum.get(psum - target) - i;
            }
          } else {
            suffix[i] = suffix[i + 1];
          }
        }
      } else {
        suffix[i] = suffix[i + 1];
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
//    System.out.println(minSumOfLengths(new int[]{3,2,2,4,3}, 3));
//    System.out.println(minSumOfLengths(new int[]{4,3,2,6,2,3,4}, 6));
//    System.out.println(minSumOfLengths(new int[]{3,1,1,1,5,1,2,1}, 3));
    System.out.println(minSumOfLengths(new int[]{1,2,2,3,2,6,7,2,1,4,8}, 5));
  }
}
