package algo.depthFirstSearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
  public static boolean wordBreak(String s, List<String> wordDict) {
    return dfs(s, 0, new HashSet<>(wordDict), new int[s.length()]) == 1;
  }

  private static int dfs(String s, int from, Set<String> words, int[] dp) {
    if (dp[from] != 0) {
      return dp[from];
    }
    if (from >= s.length()) {
      return 1;
    }
    for (var i = from; i < s.length(); i++) {
      var str = s.substring(from, i + 1);
      if (words.contains(str)) {
        if (i == s.length() - 1) {
          return 1;
        }
        var result = dfs(s, i + 1, words, dp);
        dp[i + 1] = result;
        if (result == 1) {
          return 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(wordBreak("leetcode", List.of("leet", "code")));
    System.out.println(wordBreak("applepen", List.of("apple", "pen")));
    System.out.println(wordBreak("catsandog", List.of("cats", "sand", "dog", "and", "cat")));
    System.out.println(wordBreak("catsandog", List.of("cats", "san", "dog", "and", "cat", "og")));
    System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aaa")));
    System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
  }
}
