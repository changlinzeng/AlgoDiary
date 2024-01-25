package algo.dp;

public class DistinctSubsequences_115 {
  public static int numDistinct(String s, String t) {
    //    b   a   b   g   b   a   g
    // b  1   1   2   2   3   3   3
    // a  0   1   1   1   1   4   4
    // g  0   0   0   1   1   1   5

    //    r   a   b   b   b   i   t
    // r  1   1   1   1   1   1   1
    // a  0   1   1   1   1   1   1
    // b  0   0   1   2   3   3   3
    // b  0   0   1   2   3   3   3
    // i  0   0   0   0   0   3   3
    // t  0   0   0   0   0   0   3

    int slen = s.length(), tlen = t.length();
    var dp = new int[tlen][slen];
    if (s.charAt(0) == t.charAt(0)) {
      dp[0][0] = 1;
    }
    for (var i = 1; i < slen; i++) {
      if (s.charAt(i) == t.charAt(0)) {
        dp[0][i] = dp[0][i - 1] + 1;
      } else {
        dp[0][i] = dp[0][i - 1];
      }
    }
    for (var i = 1; i < tlen; i++) {
      for (var j = 1; j < slen; j++) {
        if (t.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    return dp[tlen - 1][slen - 1];
  }

  public static void main(String[] args) {
    System.out.println(numDistinct("babgbag", "bag"));
    System.out.println(numDistinct("rabbbit", "rabbit"));
  }
}
