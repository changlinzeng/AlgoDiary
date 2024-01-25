package algo.dp;

public class NumberOfSubarraysWithOddSum_1524 {
  public static int numOfSubarrays(int[] arr) {
    int MOD = 1_000_000_007;
    int len = arr.length, num = 0;
    var sumStat = new int[len][2];  // count of odd sum and even sum at position i
    var dp = new int[len];
    dp[0] = arr[0] % 2 == 0 ? 0 : 1;
    sumStat[0][0] = dp[0];
    sumStat[0][1] = 1 - dp[0];
    for (var i = 1; i < len; i++) {
      if (arr[i] % 2 == 0) {
        // current number is even
        if (sumStat[i - 1][0] != 0 && sumStat[i - 1][1] != 0) {
          sumStat[i][0] = sumStat[i - 1][0];
          sumStat[i][1] = sumStat[i - 1][1] + 1;
        } else if (sumStat[i - 1][0] == 0) {
          sumStat[i][0] = 0;
          sumStat[i][1] = sumStat[i - 1][1] + 1;
        } else if (sumStat[i - 1][1] == 0) {
          sumStat[i][0] = sumStat[i - 1][0];
          sumStat[i][1] = 1;
        }
        dp[i] = (dp[i - 1] + sumStat[i - 1][0]) % MOD;
      } else {
        // current number is odd
        if (sumStat[i - 1][0] != 0 && sumStat[i - 1][1] != 0) {
          sumStat[i][0] = sumStat[i - 1][1] + 1;
          sumStat[i][1] = sumStat[i - 1][0];
        } else if (sumStat[i - 1][0] == 0) {
          sumStat[i][0] = sumStat[i - 1][1] + 1;
          sumStat[i][1] = 0;
        } else if (sumStat[i - 1][1] == 0) {
          sumStat[i][0] = 1;
          sumStat[i][1] = sumStat[i - 1][0];
        }
        dp[i] = (dp[i - 1] + sumStat[i - 1][1] + 1) % MOD;
      }
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
//    System.out.println(numOfSubarrays(new int[]{1,3,5}));
//    System.out.println(numOfSubarrays(new int[]{2,4,6}));
    System.out.println(numOfSubarrays(new int[]{64,69,7,78,31,83,47,84,47,6,67}));
    //       64, 69, 7, 78, 31, 83, 47, 84, 47, 6, 67
    // odd    0   2  1   1
    // even   1   0  2   3
  }
}
