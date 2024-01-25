package algo.twoPointers;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting_524 {
  public static String findLongestWord(String s, String[] dictionary) {
    int i, j;
    String longest = "";
    for (String word : dictionary) {
      i = 0;
      j = 0;
      while (i < word.length() && j < s.length()) {
        if (word.charAt(i) == s.charAt(j)) {
          i++;
        }
        j++;
      }
      if (i == word.length() &&
              (word.length() > longest.length() ||
               (word.length() == longest.length() && word.compareTo(longest) < 0) ||
               longest.equals(""))) {
        longest = word;
      }
    }

    return longest;
  }

  public static void main(String[] args) {
    System.out.println(findLongestWord("abpcplea", new String[]{"ale","apple","monkey","plea"}));
    System.out.println(findLongestWord("abpcplea", new String[]{"a", "b"}));
    System.out.println(findLongestWord("abce", new String[]{"abe","abc"}));
  }
}
