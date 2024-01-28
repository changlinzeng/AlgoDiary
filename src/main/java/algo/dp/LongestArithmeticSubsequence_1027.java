package algo.dp;

public class LongestArithmeticSubsequence_1027 {
  public static int longestArithSeqLength(int[] nums) {
    //      20,  1,  15,  3, 10, 5, 8
    // 20    0
    //  1  -19   0
    // 15   -5  14    0
    //  3  -17   2  -12   0
    // 10  -10   9   -5   7   0
    //  5  -15   4  -10   2  -5  0
    //  8  -12   7   -7   5  -2  3  0
    var len = nums.length;
    var dp = new int[len][1001];   // max length of arith seq ends at i with diff in [-500, 500]
    var diff = new int[len][len];
    var maxLen = 0;
    for (var i = 1; i < len; i++) {
      for (var j = 0; j < i; j++) {
        diff[i][j] = nums[i] - nums[j];
        var index = diff[i][j] + 500;   // diff + 500 to avoid negative index
        for (var k = 0; k < j; k++) {
          if (diff[j][k] == diff[i][j]) {
            dp[i][index] = dp[j][index] + 1;
            break;
          }
        }
        if (dp[i][index] == 0) {
          dp[i][index] = 2;
        }
        maxLen = Math.max(maxLen, dp[i][diff[i][j] + 500]);
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestArithSeqLength(new int[]{3, 6, 9 ,12}));
    System.out.println(longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
    System.out.println(longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    System.out.println(longestArithSeqLength(new int[]{83,20,17,43,52,78,68,45}));
    System.out.println(longestArithSeqLength(new int[]{75,12,29,77,29,84,63,44,79,59,10}));
    System.out.println(longestArithSeqLength(new int[]{12,28,13,6,34,36,53,24,29,2,23,0,22,25,53,34,23,50,35,43,53,11,48,56,44,53,31,6,31,57,46,6,17,42,48,28,5,24,0,14,43,12,21,6,30,37,16,56,19,45,51,10,22,38,39,23,8,29,60,18}));
  }
}
