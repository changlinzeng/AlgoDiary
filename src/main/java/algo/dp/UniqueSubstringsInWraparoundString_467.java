package algo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringsInWraparoundString_467 {
  public static int findSubstringInWraproundString(String s) {
    var len = s.length();
    var strlen = new int[26];  // longest str ends with char as the longest str contains all shorter str
    var dp = new int[len];  // number of substring ends at i
    dp[0] = 1;
    strlen[s.charAt(0) - 'a'] = 1;
    for (var i = 1; i < len; i++) {
      char ch = s.charAt(i), prev = s.charAt(i - 1);
      if (ch == (prev + 1) || ch == 'a' && prev == 'z') {
        dp[i] = 1 + dp[i - 1];
      } else {
        dp[i] = 1;
      }
      strlen[ch - 'a'] = Math.max(strlen[ch - 'a'], dp[i]);
    }
    return Arrays.stream(strlen).sum();
  }

  public static void main(String[] args) {
    System.out.println(findSubstringInWraproundString("zab"));
    System.out.println(findSubstringInWraproundString("a"));
    System.out.println(findSubstringInWraproundString("cac"));
    System.out.println(findSubstringInWraproundString("abcd"));
    System.out.println(findSubstringInWraproundString("aabb"));
    System.out.println(findSubstringInWraproundString("cdefghefgh"));
    System.out.println(findSubstringInWraproundString("cdefghefghi"));
    System.out.println(findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
  }
}
