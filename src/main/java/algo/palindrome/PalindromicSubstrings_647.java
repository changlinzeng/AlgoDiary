package algo.palindrome;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings_647 {
  public static int countSubstrings(String s) {
    var len = s.length();
    var palindrome = new HashMap<Integer, Set<Integer>>();  // start indices of palindrome ends at i
    var dp = new int[len];
    dp[0] = 1;
    palindrome.put(0, new HashSet<>());
    palindrome.get(0).add(0);
    for (var i = 1; i < len; i++) {
      dp[i] = dp[i - 1] + 1;
      palindrome.put(i, new HashSet<>());
      palindrome.get(i).add(i);
      // check if we can make palindrome with i
      var count = 0;
      for (var idx : palindrome.get(i - 1)) {
        // check palindrome from idx - 1 to i
        if (idx > 0 && s.charAt(idx - 1) == s.charAt(i)) {
          palindrome.get(i).add(idx - 1);
          count++;
        }
      }
      for (var idx : palindrome.get(i - 1)) {
        // check palindrome from idx to i
        if (palindrome.get(i).contains(idx)) {
          continue;
        }
        var found = true;
        for (var k = idx; k <= idx + (i - idx) / 2; k++) {
          if (s.charAt(k) != s.charAt(i + idx - k)) {
            found = false;
            break;
          }
        }
        if (found) {
          palindrome.get(i).add(idx);
          count++;
        }
      }
      dp[i] += count;
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
    System.out.println(countSubstrings("abc"));
    System.out.println(countSubstrings("aaa"));
  }
}
