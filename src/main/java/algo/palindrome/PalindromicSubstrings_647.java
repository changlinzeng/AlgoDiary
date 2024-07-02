package algo.palindrome;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings_647 {
  public static int countSubstrings(String s) {
    var dp = new HashMap<Integer, Set<Integer>>();  // start indices of palindrome ends at i
    dp.put(0, new HashSet<>());
    dp.get(0).add(0);
    var count = 1;
    for (var i = 1; i < s.length(); i++) {
      dp.put(i, new HashSet<>());
      dp.get(i).add(i);
      // check if we can make palindrome
      for (var start : dp.get(i - 1)) {
        if (isPalindrome(s, start, i)) {
          dp.get(i).add(start);
        }
        if (start > 0 && s.charAt(start - 1) == s.charAt(i)) {
          dp.get(i).add(start - 1);
        }
      }
      count += dp.get(i).size();
    }
    return count;
  }

  private static boolean isPalindrome(String s, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(countSubstrings("abc"));
    System.out.println(countSubstrings("aaa"));
  }
}
