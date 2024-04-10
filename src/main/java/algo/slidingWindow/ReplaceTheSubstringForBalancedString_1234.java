package algo.slidingWindow;

import java.util.HashMap;

public class ReplaceTheSubstringForBalancedString_1234 {
  public static int balancedString(String s) {
    // Find the shortest window so that when we remove the window from the string, the count of all
    // chars are less than total / 4
    var limit = s.length() / 4;
    var count = new HashMap<Character, Integer>();
    for (var i = 0; i < s.length(); i++) {
      count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
    }
    if (count.size() == 4 && count.values().stream().allMatch(v -> v >= limit)) {
      return 0;
    }

    int left = 0, right = 0;
    var minLen = Integer.MAX_VALUE;
    while (right < s.length()) {
      count.put(s.charAt(right), count.get(s.charAt(right)) - 1);
      if (count.values().stream().allMatch(v -> v <= limit)) {
        minLen = Math.min(minLen, right - left + 1);
        while (left < right) {
          minLen = Math.min(minLen, right - left + 1);
          count.put(s.charAt(left), count.get(s.charAt(left)) + 1);
          left++;
          if (count.values().stream().anyMatch(v -> v > limit)) {
            break;
          }
        }
      }
      right++;
    }

    return minLen;
  }

  public static void main(String[] args) {
    System.out.println(balancedString("QWER"));
    System.out.println(balancedString("QQWE"));
    System.out.println(balancedString("QQQW"));
    System.out.println(balancedString("WQWRQQQW"));
  }
}
