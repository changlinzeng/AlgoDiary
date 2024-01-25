package algo.slidingWindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters_3 {
  public static int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0;
    int maxlen = 0;
    var freq = new int[256];
    Arrays.fill(freq, 0);

    while (j < s.length()) {
      var c = s.charAt(j);

      // move left window till there is no repeats
      if (freq[c] != 0) {
        while (freq[c] != 0) {
          freq[s.charAt(i)]--;
          i++;
        }
      }

      freq[c]++;
      maxlen = Math.max(maxlen, j - i + 1);
      j++;
    }

    return maxlen;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }
}
