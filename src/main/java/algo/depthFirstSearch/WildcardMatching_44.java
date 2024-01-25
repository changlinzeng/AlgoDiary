package algo.depthFirstSearch;

public class WildcardMatching_44 {
  public static boolean isMatch(String s, String p) {
    // remove consecutive * from p
    var pattern = "";
    for (var c : p.toCharArray()) {
      if (!pattern.isEmpty() && c == '*' && pattern.charAt(pattern.length() - 1) == '*') {
        continue;
      }
      pattern += c;
    }

    return match(s, pattern, 0, 0, new int[s.length()][p.length()]) == 1;
  }

  private static int match(String s, String p, int sIndex, int pIndex, int[][] dp) {
    if (s.isEmpty()) {
      return "*".equals(p) || p.isEmpty() ? 1 : -1;
    }
    if (p.isEmpty()) {
      return -1;
    }

    int slen = s.length(), plen = p.length();
    // return previously calculated result
    if (dp[sIndex][pIndex] != 0) {
      return dp[sIndex][pIndex];
    }
    int i, j;
    for (i = sIndex, j = pIndex; i < slen && j < plen; i++, j++) {
      char schar = s.charAt(i), pchar = p.charAt(j);
      if (pchar == '*') {
        if (j == p.length() - 1) {
          // last '*' matches all
          dp[sIndex][pIndex] = 1;
          return 1;
        } else {
          for (var k = i; k < slen; k++) {
            if (s.charAt(k) == p.charAt(j + 1) || p.charAt(j + 1) == '?') {
              var result = match(s, p, k, j + 1, dp);
              dp[k][j + 1] = result;
              if (result == 1) {
                return 1;
              }
            }
          }
        }
      }
      if (schar != pchar && pchar != '?') {
        dp[sIndex][pIndex] = -1;
        return -1;
      }
    }
    // ignore last '*'
    if (i == slen && (j == plen || j == plen - 1 && p.charAt(j) == '*')) {
      dp[sIndex][pIndex] = 1;
    } else {
      dp[sIndex][pIndex] = -1;
    }
    return dp[sIndex][pIndex];
  }

  public static void main(String[] args) {
    System.out.println(isMatch("aa", "a"));
    System.out.println(isMatch("aa", "*"));
    System.out.println(isMatch("cb", "?a"));
    System.out.println(isMatch("aa", "aaa"));
    System.out.println(isMatch("aabbcc", "a?*b"));
    System.out.println(isMatch("adceb", "*a*b"));
    System.out.println(isMatch("adceb", "*a*b*"));
    System.out.println(isMatch("adceb", "*a*e*"));
    System.out.println(isMatch("", "*"));
    System.out.println(isMatch("", ""));
    System.out.println(isMatch("a", "*?*"));
//    System.out.println(isMatch2("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
//            "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
  }
}
