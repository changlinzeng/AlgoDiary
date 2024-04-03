package algo.parenthesis;

import java.util.Stack;

public class ValidParenthesisString_678 {
  public static boolean checkValidString2(String s) {
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

  public static boolean checkValidString(String s) {
    var leftParens = new Stack<Integer>();  // index of left parenthesis
    var asterisk = new Stack<Integer>();  // index of asterisk
    for (var i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      switch (ch) {
        case '(' -> leftParens.push(i);
        case '*' -> asterisk.push(i);
        case ')' -> {
          if (!leftParens.isEmpty()) {
            leftParens.pop();  // consume left parenthesis
          } else if (!asterisk.isEmpty()) {
            asterisk.pop();  // consume asterisk
          } else {
            // nothing to consume. the parenthesis is not balanced
            return false;
          }
        }
      }
    }
    // if there are left parenthesis, we need to make sure they can be consumed by asterisk
    while (!leftParens.isEmpty() && !asterisk.isEmpty()) {
      // asterisk should be on the right
      if (leftParens.pop() > asterisk.pop()) {
        return false;
      }
    }
    return leftParens.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(checkValidString("())"));
    System.out.println(checkValidString("(*)"));
    System.out.println(checkValidString("(*))"));
    System.out.println(checkValidString("(((((*)))**"));
  }
}
