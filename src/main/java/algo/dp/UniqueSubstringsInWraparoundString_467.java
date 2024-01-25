package algo.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringsInWraparoundString_467 {
  public static int findSubstringInWraproundString(String s) {
    var len = s.length();
    var unique = new HashSet<String>();
    var substrings = new HashMap<Integer, Set<String>>();  // all substrings ends at i. keep duplicates here
    for (var i = 0; i < len; i++) {
      substrings.put(i, new HashSet<>());
    }

    var dp = new int[len];
    var substr = s.substring(0, 1);
    dp[0] = 1;
    unique.add(substr);
    substrings.get(0).add(substr);
    for (var i = 1; i < len; i++) {
      dp[i] = dp[i - 1];
      substr = s.substring(i, i + 1);
      substrings.get(i).add(substr);
      if (unique.add(substr)) {
        dp[i]++;
      }
      if (s.charAt(i) == s.charAt(i - 1) + 1 || s.charAt(i) == 'a' && s.charAt(i - 1) == 'z') {
        var count = 0;
        if (substrings.get(i - 1).isEmpty()) {
          substr = s.substring(i - 1, i + 1);
          substrings.get(i).add(substr);
          if (unique.add(substr)) {
            count++;
          }
        } else {
          for (var str : substrings.get(i - 1)) {
            substr = str + s.charAt(i);
            substrings.get(i).add(substr);
            if (unique.add(substr)) {
              count++;
            }
          }
        }
        dp[i] = dp[i] + count;
      }
    }

    return dp[len - 1];
  }

  public static void main(String[] args) {
//    System.out.println(findSubstringInWraproundString("zab"));
//    System.out.println(findSubstringInWraproundString("a"));
//    System.out.println(findSubstringInWraproundString("cac"));
//    System.out.println(findSubstringInWraproundString("abcd"));
//    System.out.println(findSubstringInWraproundString("aabb"));
//    System.out.println(findSubstringInWraproundString("cdefghefgh"));
//    System.out.println(findSubstringInWraproundString("cdefghefghi"));
    System.out.println(findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
  }
}
