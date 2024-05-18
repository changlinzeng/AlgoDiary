package algo.dp;

public class DecodeWays_91 {
  public static int numDecodings(String s) {
    var len = s.length();
    if (s.charAt(0) == '0') {
      return 0;
    }
    var dp = new int[len];
    dp[0] = 1;

    for (var i = 1; i < len; i++) {
      char ch = s.charAt(i), prev = s.charAt(i - 1);
      if (ch == '0') {
        if (prev == '1' || prev == '2') {
          if (i == 1) {
            dp[i] = 1;
          } else {
            dp[i] = dp[i - 2];
          }
        } else {
          return 0;
        }
      } else {
        if (prev == '1' || prev == '2' && ch >= '1' && ch <= '6') {
          if (i == 1) {
            dp[i] = 2;
          } else {
            dp[i] = dp[i - 1] + dp[i - 2];
          }
        } else {
          dp[i] = dp[i - 1];
        }
      }
    }

    return dp[len - 1];
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("12"));
    System.out.println(numDecodings("226"));
    System.out.println(numDecodings("10"));
    System.out.println(numDecodings("2101"));
    System.out.println(numDecodings("1123"));
  }
}
