package algo.palindrome;

public class SplitTwoStringsToMakePalindrome_1616 {
  public static boolean checkPalindromeFormation(String a, String b) {
    if (isPalindrome(a) || isPalindrome(b)) {
      return true;
    }
    return formPalindrome(a, b) || formPalindrome(b, a);
  }

  private static boolean isPalindrome(String s) {
    var len = s.length();
    for (var i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }

  private static boolean formPalindrome(String a, String b) {
    var len = a.length();
    var i = 0;
    var result = true;
    for (i = 0; i < len / 2; i++) {
      if (a.charAt(i) != b.charAt(len - i - 1)) {
        break;
      }
    }
    while (i < len / 2) {
      if (a.charAt(i) != a.charAt(len - i - 1)) {
        result = false;
        break;
      }
      i++;
    }
    if (!result) {
      result = true;
      while (i < len / 2) {
        if (b.charAt(i) != b.charAt(len - i - 1)) {
          result = false;
          break;
        }
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    System.out.println(checkPalindromeFormation("x", "y"));
//    System.out.println(checkPalindromeFormation("xbdef", "xecab"));
//    System.out.println(checkPalindromeFormation("ulacfd", "jizalu"));
    System.out.println(checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
  }
}
