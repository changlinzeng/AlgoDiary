package algo.sequence;

public class LengthOfTheLongestAlphabeticalContinuousSubstring_2414 {
  public static int longestContinuousSubstring(String s) {
    var maxLen = 1;
    int i = 0, j = 0;
    while (j < s.length() - 1) {
      while (j < s.length() - 1 && s.charAt(j + 1) == s.charAt(j) + 1) {
        j++;
      }
      maxLen = Math.max(maxLen, j - i + 1);
      j++;
      i = j;
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestContinuousSubstring("abacaba"));
    System.out.println(longestContinuousSubstring("abcde"));
  }
}
