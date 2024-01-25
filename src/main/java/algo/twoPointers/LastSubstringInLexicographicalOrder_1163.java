package algo.twoPointers;

public class LastSubstringInLexicographicalOrder_1163 {
  public static String lastSubstring(String s) {
    int i = 0, j = 1, len = s.length();
    if (len == 1) {
      return s;
    }
    while (j < len) {
      char c1 = s.charAt(i), c2 = s.charAt(j);
      if (c1 < c2) {
        i = j;
      } else if (c1 == c2) {
        if (s.charAt(j) != s.charAt(j - 1)) {
          // compare substring starting from i and j
          if (compare(s, i, j) < 0) {
            i = j;
          }
        }
      }
      j++;
    }

    return s.substring(i);
  }

  private static int compare(String s, int i, int j) {
    var len = s.length();
    while (i < len && j < len) {
      char c1 = s.charAt(i), c2 = s.charAt(j);
      if (c1 < c2) {
        return -1;
      } else if (c1 > c2) {
        return 1;
      }
      i++;
      j++;
    }
    if (i < len) {
      return 1;
    }
    if (j < len) {
      return -1;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(lastSubstring("abab"));
    System.out.println(lastSubstring("leetcode"));
  }
}
