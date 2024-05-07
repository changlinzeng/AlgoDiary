package algo.depthFirstSearch;

import java.util.HashMap;
import java.util.Map;

public class ExtraCharactersInAString_2707 {
  public static int minExtraChar(String s, String[] dictionary) {
    return dfs(s, dictionary, new HashMap<>());
  }

  private static int dfs(String s, String[] dictionary, Map<String, Integer> memo) {
    if (s.isEmpty()) {
      return 0;
    }
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    var skip = Integer.MAX_VALUE;
    for (var word : dictionary) {
      if (s.startsWith(word)) {
        skip = Math.min(skip, dfs(s.substring(word.length()), dictionary, memo));
      }
    }
    var minSkip =  Math.min(skip, 1 + dfs(s.substring(1), dictionary, memo));
    memo.put(s, minSkip);
    return minSkip;
  }

  public static void main(String[] args) {
    System.out.println(minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
    System.out.println(minExtraChar("sayhelloworld", new String[]{"hello", "world"}));
  }
}
