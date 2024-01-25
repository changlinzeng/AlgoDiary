package algo.twoPointers;

public class ShortestPalindrome_214 {
  public static String shortestPalindrome(String s) {
    int len = s.length(), mid = len / 2;
    var minString = "";

    if (len < 2) {
      return s;
    }

    // find middle right to left
    // 0 1 2 3 4 5 6 7
    for (;;) {
      var mids = new int[2][];
      mids[0] = new int[]{mid, mid};

      if (mid > 0 && s.charAt(mid) == s.charAt(mid - 1)) {
        mids[1] = new int[]{mid - 1, mid};
      } else {
        mids[1] = new int[]{-1, -1};
      }

      for (var idx : mids) {
        int i = idx[0], j = idx[1];
        if (i == -1) {
          break;
        }

        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
          i--;
          j++;
        }
        if (i == -1 && (minString.isEmpty() || minString.length() > len - j)) {
          minString = s;
          while (j < len) {
            minString = s.charAt(j) + minString;
            j++;
          }
          break;
        }

      }
      if (!minString.isEmpty()) {
        return minString;
      }
      mid--;
    }
  }

  public static void main(String[] args) {
//    System.out.println(shortestPalindrome("aacecaaa"));
//    System.out.println(shortestPalindrome("abcd"));
//    System.out.println(shortestPalindrome("ab"));
    System.out.println(shortestPalindrome("abbacd"));
  }
}
