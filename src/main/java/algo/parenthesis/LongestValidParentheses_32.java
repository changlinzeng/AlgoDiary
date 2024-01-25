package algo.parenthesis;

import java.util.Stack;

public class LongestValidParentheses_32 {
  public static int longestValidParentheses(String s) {
    int leftCount = 0, rightCount = 0;
    var stack = new Stack<String>();
    for (var i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      if (ch == '(') {
        stack.push("(");
        leftCount++;
      } else if (ch == ')') {
        if (!stack.isEmpty()) {
          var p = ")";
          if (rightCount < leftCount) {
            while (!stack.isEmpty()) {
              var e = stack.pop();
              p = e + p;
              if (e.equals("(")) {
                break;
              }
            }
            rightCount++;
          }
          stack.push(p);
        }
      }
    }

    var maxLen = 0;
    var len = 0;
    while (!stack.isEmpty()) {
      var e = stack.pop();
      if (e.equals("(") || e.equals(")")) {
        len = 0;
        continue;
      }
      len += e.length();
      maxLen = Math.max(maxLen, len);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("(()"));
    System.out.println(longestValidParentheses(")()())"));
    System.out.println(longestValidParentheses("(()()()())"));
    System.out.println(longestValidParentheses(")()())()()("));
    System.out.println(longestValidParentheses(")(())))(())())"));
  }
}
