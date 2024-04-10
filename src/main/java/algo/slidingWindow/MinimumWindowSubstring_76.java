package algo.slidingWindow;

public class MinimumWindowSubstring_76 {
  public static String minWindow(String s, String t) {
    var base = new int[58];
    var count = new int[58];
    var window = t.length();
    if (t.length() > s.length()) {
      return "";
    }
    for (var i = 0; i < t.length(); i++) {
      base[t.charAt(i) - 'A']++;
    }

    int left = 0, right = 0;
    var minWindow = "";
    while (right < s.length()) {
      var ch = s.charAt(right);
      count[ch - 'A']++;
      if (right >= window - 1) {
        var included = true;
        for (var i = 0; i < base.length; i++) {
          if (base[i] != 0 && base[i] > count[i]) {
            included = false;
            break;
          }
        }
        if (included) {
          // try to shrink the window from left
          var c = s.charAt(left);
          while (base[c - 'A'] == 0 || count[c - 'A'] > base[c - 'A']) {
            if (count[c - 'A'] > 0) {
              count[c - 'A'] = count[c - 'A'] - 1;
            }
            left++;
            c = s.charAt(left);
          }
          var sub = s.substring(left, right + 1);
          if (minWindow.isEmpty() || sub.length() < minWindow.length()) {
            minWindow = sub;
          }
        }
      }
      right++;
    }
    return minWindow;
  }

  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    System.out.println(minWindow("a", "a"));
    System.out.println(minWindow("a", "aa"));
  }
}
