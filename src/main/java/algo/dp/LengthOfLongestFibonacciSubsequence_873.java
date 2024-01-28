package algo.dp;

import java.util.HashMap;

public class LengthOfLongestFibonacciSubsequence_873 {
  public static int lenLongestFibSubseq(int[] arr) {
    //   2,  4,  7,  8,  9,  10,  14,  15,  18,  23,  32,  50
    //   0   0   0   0   3    3    3    3    3    3    4    5
    //   -1 -1  -1  -1   2    3    5    3    6    7    8   10
    //       4                    14        18
    //               8       10             18
    int len = arr.length, maxLen = 0;
    var position = new HashMap<Integer, Integer>();  // {arr[i] -> i}
    var dp = new int[len][len];  // length of longest fibonacci subsequence ends with i and j (i < j)
    position.put(arr[0], 0);
    position.put(arr[1], 1);
    for (var i = 2; i < len; i++) {
      for (var j = i - 1; j >= 0; j--) {
        var diff = arr[i] - arr[j];
        var prev = position.getOrDefault(diff, -1);
        if (prev != -1 && prev < j) {
          dp[j][i] = dp[prev][j] + 1;
          maxLen = Math.max(maxLen, dp[j][i]);
        }
      }
      position.put(arr[i], i);
    }
    return maxLen == 0 ? 0 : maxLen + 2;
  }

  public static void main(String[] args) {
    System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    System.out.println(lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
  }
}
