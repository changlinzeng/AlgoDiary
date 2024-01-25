package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_II {
  public static List<String> wordBreak(String s, List<String> wordDict) {
    var sentences = new HashSet<String>();
    dfs(s, new HashSet<>(wordDict), 0, sentences, "");
    return new ArrayList<>(sentences);
  }

  private static void dfs(String s, Set<String> wordDict, int index, Set<String> sentences,
                          String sub) {
    for (var i = index; i < s.length(); i++) {
      var word = s.substring(index, i + 1);
      if (wordDict.contains(word)) {
        if (i == s.length() - 1) {
            if (sub.isEmpty()) {
              sentences.add(word);
            } else {
              sentences.add(sub + " " + word);
            }
          continue;
        }
        if (!sub.isEmpty()) {
          word = " " + word;
        }
        dfs(s, wordDict, i + 1, sentences, sub + word);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    System.out.println(wordBreak("pineapplepenapple", List.of("apple","pen","applepen","pine","pineapple")));
    System.out.println(wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    System.out.println(wordBreak("a", List.of("a")));
    System.out.println(wordBreak("aaaaaaa", List.of("aaaa","aa","a")));
//    System.out.println(wordBreak("aaaa", List.of("aaaa","aa","a")));
  }
}
