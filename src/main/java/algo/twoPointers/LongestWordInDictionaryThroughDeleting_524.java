package algo.twoPointers;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting_524 {
  public static String findLongestWord(String s, List<String> dictionary) {
    String longest = "";
    var sorted = dictionary.stream().sorted().toList();
    for (String word : sorted) {
      int i = 0, j = 0;
      while (i < word.length() && j < s.length()) {
        if (word.charAt(i) == s.charAt(j)) {
          i++;
        }
        j++;
      }
      if (i == word.length()) {
        if (word.length() > longest.length()) {
          longest = word;
        }
      }
    }

    return longest;
  }

  public static void main(String[] args) {
    System.out.println(findLongestWord("abpcplea", List.of("ale","apple","monkey","plea")));
    System.out.println(findLongestWord("abpcplea", List.of("a", "b")));
    System.out.println(findLongestWord("abce", List.of("abe","abc")));
  }
}
