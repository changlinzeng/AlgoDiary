package algo.twoPointers;

public class ExpressiveWords_809 {
  public static int expressiveWords(String s, String[] words) {
    var num = 0;
    for (var w : words) {
      int i = 0, j = 0;
      var found = true;
      while (i < s.length() && j < w.length()) {
        if (s.charAt(i) != w.charAt(j)) {
          found = false;
          break;
        }
        int baseCount = 1, wordCount = 1;
        while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
          baseCount++;
          i++;
        }
        while (j < w.length() - 1 && w.charAt(j) == w.charAt(j + 1)) {
          wordCount++;
          j++;
        }
        if (baseCount > 2 && baseCount < wordCount || baseCount <= 2 && baseCount != wordCount) {
          found = false;
          break;
        }
        i++;
        j++;
      }
      if (!found || i != s.length() || j != w.length()) {
        continue;
      }
      num++;
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    System.out.println(expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
    System.out.println(expressiveWords("abcd", new String[]{"abc"}));
  }
}
