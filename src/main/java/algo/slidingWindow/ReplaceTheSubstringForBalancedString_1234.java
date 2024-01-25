package algo.slidingWindow;

import java.util.HashMap;

public class ReplaceTheSubstringForBalancedString_1234 {
  public static int balancedString(String s) {
    int len = s.length(), k = s.length() / 4;
    // frequency
    var freq = new HashMap<Character, Integer>(){
      {
        put('Q', 0);
        put('W', 0);
        put('E', 0);
        put('R', 0);
      }
    };

    for (int i = 0; i < s.length(); i++) {
      freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
    }

    if (freq.get('Q') == k && freq.get('W') == k && freq.get('E') == k && freq.get('R') == k) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    int left = 0, right = 0;
    while (right <= len) {
      while (right < len && freq.get('Q') > k || freq.get('W') > k || freq.get('E') > k || freq.get('R') > k) {
        // consume extra chars
        freq.put(s.charAt(right), freq.get(s.charAt(right)) - 1);
        right++;
      }
      for (;;) {
        var c = s.charAt(left);
        if (freq.get(c) + 1 > k) {
          break;
        }
        freq.put(c, freq.get(c) + 1);
        left++;
      }

      min = Math.min(min, right - left);

      if (right < len) {
        freq.put(s.charAt(right), freq.get(s.charAt(right)) - 1);
      }
      right++;
    }

    return min;
  }

  public static void main(String[] args) {
    System.out.println(balancedString("QWER"));
    System.out.println(balancedString("QQWE"));
    System.out.println(balancedString("QQQW"));
    System.out.println(balancedString("WQWRQQQW"));
  }
}
