package algo.slidingWindow;

public class PermutationInString_567 {
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    var window = s1.length();
    var freq = new int[26];
    for (var c : s1.toCharArray()) {
      freq[c - 'a']++;
    }

    var count = new int[26];
    for (var i = 0; i < window; i++) {
      count[s2.charAt(i) - 'a']++;
    }

    for (var i = 0; i <= s2.length() - window; i++) {
      if (i > 0) {
        count[s2.charAt(i + window - 1) - 'a']++;
        count[s2.charAt(i - 1) - 'a']--;
      }
      if (match(count, freq)) {
        return true;
      }
    }
    return false;
  }

  private static boolean match(int[] count, int[] freq) {
    for (var i = 0; i < count.length; i++) {
      if (count[i] != freq[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eidbaooo"));
    System.out.println(checkInclusion("ab", "eidboaoo"));
    System.out.println(checkInclusion("adc", "dcda"));
  }
}
