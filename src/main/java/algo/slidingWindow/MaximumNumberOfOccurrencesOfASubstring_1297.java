package algo.slidingWindow;

import java.util.HashMap;

public class MaximumNumberOfOccurrencesOfASubstring_1297 {
  public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    var count = new HashMap<Character, Integer>();
    var substr = new HashMap<String, Integer>();
    int i = 0, j = 0;
    while (j < s.length()) {
      var ch = s.charAt(j);
      count.put(ch, count.getOrDefault(ch, 0) + 1);
      if (j - i + 1 <= maxSize && j - i + 1 >= minSize && count.size() <= maxLetters) {
        var str = s.substring(i, j + 1);
        substr.put(str, substr.getOrDefault(str, 0) + 1);
      }

      while (i < j && j - i + 1 > minSize) {
        var c = s.charAt(i);
        count.put(c, count.get(c) - 1);
        if (count.get(c) == 0) {
          count.remove(c);
        }
        i++;
        if (count.size() <= maxLetters) {
          substr.put(s.substring(i, j + 1), substr.getOrDefault(s.substring(i, j + 1), 0) + 1);
        }
      }
      j++;
    }

    var maxCount = 0;
    for (var n : substr.values()) {
      maxCount = Math.max(maxCount, n);
    }
    return maxCount;
  }

  public static void main(String[] args) {
    System.out.println(maxFreq("abcde", 2, 3, 3));
  }
}
