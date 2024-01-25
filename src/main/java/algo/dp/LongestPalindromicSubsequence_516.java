package algo.dp;

public class LongestPalindromicSubsequence_516 {
  public static int longestPalindromeSubseq(String s) {
    // reverse s and find longest common subsequence in s and reverse
    var len = s.length();
    var dp = new int[len][len];
    var r = "";
    for (var i = len - 1; i >= 0; i--) {
      r += s.charAt(i);
    }
    //    b   b   b   a   b
    // b  1   1   1   1   1
    // a  1   1   1   2   2
    // b  1   2   2   2   3
    // b  1   1   3   3   3
    // b  1   2   2   3   4
    for (var i = 0; i < len; i++) {
      for (var j = 0; j < len; j++) {
        if (s.charAt(j) == r.charAt(i)) {
          if (j > 0 && i > 0) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = 1;
          }
        } else {
          var m1 = i > 0 ? dp[i - 1][j] : 0;
          var m2 = j > 0 ? dp[i][j - 1] : 0;
          dp[i][j] = Math.max(m1, m2);
        }
      }
    }

    return dp[len - 1][len - 1];
  }

  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("bbbab"));
    System.out.println(longestPalindromeSubseq("cbbd"));
    System.out.println(longestPalindromeSubseq("aabaa"));
  }
}
