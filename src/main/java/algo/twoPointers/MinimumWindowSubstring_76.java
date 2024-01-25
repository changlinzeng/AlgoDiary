package algo.twoPointers;

public class MinimumWindowSubstring_76 {
  private static final int[] freq = new int[58];
  private static final int[] count = new int[58];

  public static String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }
    var minSubstring = "";
    int start = 0, end = t.length() - 1;

    for (var c : t.toCharArray()) {
      freq[c - 'A']++;
    }

    for (var i = 0; i < t.length(); i++) {
      count[s.charAt(i) - 'A']++;
    }

    while (end < s.length()) {
      if (match()) {
        // remove extra chars
        for (;;) {
          var c = s.charAt(start);
          if (freq[c - 'A'] == 0 || count[c - 'A'] > freq[c - 'A']) {
            start++;
            if (count[c - 'A'] > 0) {
              count[c - 'A']--;
            }
          } else {
            break;
          }
        }
        if (minSubstring.isEmpty() || (end - start + 1) < minSubstring.length()) {
          minSubstring = s.substring(start, end + 1);
          // this is the min substring then return
          if (minSubstring.length() == t.length()) {
            return minSubstring;
          }
        }
      }

      end++;
      if (end < s.length()) {
        var ch = s.charAt(end);
        if (freq[ch - 'A'] > 0) {
          count[ch - 'A']++;
        }
      }
    }

    return minSubstring;
  }

  private static boolean match() {
    for (var i = 0; i < freq.length; i++) {
      if (count[i] < freq[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    System.out.println(minWindow("a", "a"));
//    System.out.println(minWindow("a", "aa"));
  }
}
