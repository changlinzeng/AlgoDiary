package algo.xxx;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets_916 {
  public static List<String> wordSubsets(String[] words1, String[] words2) {
    var count = new int[26];
    for (var w : words2) {
      var charCount = new int[26];
      for (var i = 0; i < w.length(); i++) {
        charCount[w.charAt(i) - 'a']++;
      }
      // maintain the max count of chars for all word in words2
      // word in word1 is universal only if char count greater than the max chars
      for (var i = 0; i < count.length; i++) {
        count[i] = Math.max(count[i], charCount[i]);
      }
    }

    var universal = new ArrayList<String>();
    for (var w : words1) {
      var charCount = new int[26];
      for (var i = 0; i < w.length(); i++) {
        charCount[w.charAt(i) - 'a']++;
      }

      var isSubset = true;
      for (var i = 0; i < count.length; i++) {
        if (charCount[i] < count[i]) {
          isSubset = false;
          break;
        }
      }
      if (isSubset) {
        universal.add(w);
      }
    }

    return universal;
  }
}
