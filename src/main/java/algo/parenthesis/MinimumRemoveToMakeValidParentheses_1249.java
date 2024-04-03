package algo.parenthesis;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {
  public static String minRemoveToMakeValid(String s) {
    var len = s.length();
    var leftCount = 0;
    var stack = new Stack<String>();
    for (var i = 0; i < len; i++) {
      var c = s.charAt(i);
      if (c >= 'a' && c <= 'z') {
        stack.push(c + "");
      } else if (c == '(') {
        leftCount++;
        stack.push("(");
      } else if (c == ')') {
        if (leftCount > 0) {
          leftCount--;
          var str = ")";
          while (!stack.isEmpty()) {
            var e = stack.pop();
            str = e + str;
            if ("(".equals(e)) {
              break;
            }
          }
          stack.push(str);
        }
      }
    }
    return stack.stream().filter(a -> !a.equals("(")).reduce("", String::concat);
  }

  public static void main(String[] args) {
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
    System.out.println(minRemoveToMakeValid("))(("));
    System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
  }
}
