package algo.slidingWindow;

public class LongestRepeatingCharacterReplacement_424 {
  public static int characterReplacement(String s, int k) {
    var freq = new int[26];

    int max = 0;
    int i = 0, j = 0;
    while (i <= j && j < s.length()) {
      var c = s.charAt(j);
      freq[c - 'A']++;

      // (window size - max freq) is the number of characters we are going to replace
      int maxFreq = 0;
      for (var n : freq) {
        maxFreq = Math.max(maxFreq, n);
      }
      int windowSize = j - i + 1;
      int replacements = windowSize - maxFreq;
      if (replacements <= k) {
        max = Math.max(max, windowSize);
      } else {
        freq[s.charAt(i) - 'A']--;
        i++;
      }
      j++;
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(characterReplacement("ABAB", 2));
    System.out.println(characterReplacement("AABABBA", 1));
    System.out.println(characterReplacement("AABABBA", 2));
    System.out.println(characterReplacement("ABAA", 0));
    System.out.println(characterReplacement("BAAA", 0));
  }
}
