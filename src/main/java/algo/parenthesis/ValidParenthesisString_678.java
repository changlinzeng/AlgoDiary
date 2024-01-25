package algo.parenthesis;

public class ValidParenthesisString_678 {
  public static boolean checkValidString(String s) {
    int maxLeft = 0, minLeft = 0;
    for (var i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      if (ch == '(') {
        maxLeft++;
        minLeft++;
      } else if (ch == ')') {
        maxLeft--;
        minLeft--;
      } else if (ch == '*') {
        maxLeft++;   // treat '*' as '('
        minLeft--;   // treat '*' as ')'
      }
      if (minLeft < 0) {
        minLeft = 0;
      }
      if (maxLeft < 0) {
        return false;
      }
    }
    return minLeft <= 0;
  }

  public static void main(String[] args) {
    System.out.println(checkValidString("())"));
    System.out.println(checkValidString("(*)"));
    System.out.println(checkValidString("(*))"));
  }
}
