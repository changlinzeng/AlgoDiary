package algo.depthFirstSearch;

/**
 * Depth first search or DP
 */
public class MinimumWindowSubsequence_727 {
  public static String minWindow(String s1, String s2) {
    var minSeq = "";
    for (var i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) == s2.charAt(0)) {
        var end = dfs(s1, s2, i);
        if (minSeq.isEmpty() || minSeq.length() > (end -i)) {
          minSeq = s1.substring(i, end);
        }
      }
    }
    return minSeq;
  }

  private static int dfs(String s1, String s2, int start) {
    if (s2.isEmpty()) {
      return start;
    }
    for (var i = start; i < s1.length(); i++) {
      if (s1.charAt(i) == s2.charAt(0)) {
        // match
        var result = dfs(s1, s2.substring(1), i + 1);
        if (result != -1) {
          return result;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(minWindow("asfdsgtteqw", "ste"));
    System.out.println(minWindow("abcdefab", "ab"));
  }
}
