package algo.dp;

public class LongestCommonSubsequence_1143 {
  public static int longestCommonSubsequence(String text1, String text2) {
    //    a   b   c   d   e
    // a  1   1   1   1   1
    // c  1   1   2   2   2
    // e  1   1   2   2   3

    //    b   l
    // y  0   0
    // b  1   1
    // y  1   1

    //    e   z   u   p   k   r
    // u  0   0   1   1   1   1
    // b  0   0   1   1   1   1
    // m  0   0   1   1   1   1
    // r  0   0   1   1   1   2
    // a  0   0   1   1   1   2

    //    a   b   c   b   a
    // a  1   1   1   1   1
    // b  1   2   2   2   2
    // c  1   2   3   3   3
    // b  1   2   3   4   4
    // c  1   2   3   4   4
    // b  1   2   3   4
    // a
    int len1 = text1.length(), len2 = text2.length();
    var dp = new int[len2][len1];
    for (var i = 0; i < len1; i++) {
      if (text1.charAt(i) == text2.charAt(0)) {
        dp[0][i] = 1;
      } else {
        if (i > 0) {
          dp[0][i] = dp[0][i - 1];
        } else {
          dp[0][i] = 0;
        }
      }
    }
    for (var i = 1; i < len2; i++) {
      for (var j = 0; j < len1; j++) {
        if (text1.charAt(j) == text2.charAt(i)) {
          if (j > 0) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = 1;
          }
        } else {
          if (j > 0) {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
    }

    return dp[len2 - 1][len1 - 1];
  }

  public static void main(String[] args) {
    System.out.println(longestCommonSubsequence("abcde", "abc"));
    System.out.println(longestCommonSubsequence("abc", "abc"));
    System.out.println(longestCommonSubsequence("abc", "def"));
    System.out.println(longestCommonSubsequence("bl", "yby"));
    System.out.println(longestCommonSubsequence("ezupkr", "ubmrapg"));
    System.out.println(longestCommonSubsequence("abcba", "abcbcba"));
    System.out.println(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
  }
}
