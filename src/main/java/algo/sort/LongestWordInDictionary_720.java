package algo.sort;

import java.util.Arrays;
import java.util.HashMap;

public class LongestWordInDictionary_720 {
  public static String longestWord(String[] words) {
    var longest = "";
    var mark = new HashMap<String, Boolean>(); // mark if word can be formed from previous word
    Arrays.sort(words);

    for (var word : words) {
      var prev = word.substring(0, word.length() - 1);
      if (word.length() == 1 || (mark.containsKey(prev) && mark.get(prev))) {
        mark.put(word, true);
        if (word.length() > longest.length()) {
          longest = word;
        }
      }
    }

    return longest;
  }

  public static void main(String[] args) {
    System.out.println(longestWord(new String[]{"w","wo","wor","worl","world"}));
    System.out.println(longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"}));
  }
}
