package algo.slidingWindow;

public class GetEqualSubstringsWithinBudget_1208 {
  public static int equalSubstring(String s, String t, int maxCost) {
    int len = s.length();
    int left = 0, right = 0;
    int maxlen = 0;
    int cost = 0;
    while (right < len) {
      cost += Math.abs(s.charAt(right) - t.charAt(right));
      if (cost <= maxCost) {
        maxlen = Math.max(maxlen, right - left + 1);
      } else {
        while (left < right && cost > maxCost) {
          cost -= Math.abs(s.charAt(left) - t.charAt(left));
          left++;
        }
      }
      if (left == right && cost > maxCost) {
        cost -= Math.abs(s.charAt(left) - t.charAt(left));
        left++;
      }
      right++;
    }

    return maxlen;
  }

  public static void main(String[] args) {
    System.out.println(equalSubstring("abcd", "bcdf", 3));
    System.out.println(equalSubstring("abcd", "cdef", 3));
    System.out.println(equalSubstring("abcd", "acde", 0));
    System.out.println(equalSubstring("anryddgaqpjdw", "zjhotgdlmadcf", 5));
  }
}
