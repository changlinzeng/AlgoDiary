package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain_1048 {
  public int longestStrChain(String[] words) {
    var wordLen = new HashMap<Integer, List<String>>();  // length -> all words with this length
    for (var w : words) {
      wordLen.putIfAbsent(w.length(), new ArrayList<>());
      wordLen.get(w.length()).add(w);
    }

    var memo = new HashMap<String, Integer>();  // word -> max chain length starting with word
    var maxLen = 0;
    for (var w : words) {
      maxLen = Math.max(maxLen, dfs(wordLen, w, memo));
    }
    return maxLen + 1;
  }

  private int dfs(Map<Integer, List<String>> words, String word, Map<String, Integer> memo) {
    if (!words.containsKey(word.length() - 1)) {
      return 0;
    }
    if (memo.containsKey(word)) {
      return memo.get(word);
    }

    // loop through the words with len - 1 and find the max chain length
    var maxLen = 0;
    for (var w : words.get(word.length() - 1)) {
      if (checkPredecessor(word, w)) {
        maxLen = Math.max(maxLen, 1 + dfs(words, w, memo));
      }
    }
    memo.put(word, maxLen);
    return maxLen;
  }

  private boolean checkPredecessor(String word, String pred) {
    if (word.length() != pred.length() + 1) {
      return false;
    }
    int i = 0, j = 0;
    int diff = 0;
    while (i < word.length() && j < pred.length()) {
      if (diff > 1) {
        return false;
      }
      if (word.charAt(i) == pred.charAt(j)) {
        i++;
        j++;
      } else {
        diff++;
        i++;
      }
    }
    // the different char is either in the middle or in the end
    return j == pred.length() && (i == word.length() || diff == 0 && i == word.length() - 1);
  }
}
