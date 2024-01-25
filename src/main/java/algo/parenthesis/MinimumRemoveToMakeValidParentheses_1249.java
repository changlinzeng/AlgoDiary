package algo.parenthesis;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {
  public static String minRemoveToMakeValid(String s) {
    var stack = new Stack<String>();
    var valid = "";
    for (var c : s.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        if (!stack.isEmpty()) {
          stack.push(c + "");
        } else {
          valid += c;
        }
      } else if (c == '(') {
        stack.push("(");
      } else if (c == ')' && !stack.isEmpty()) {
        var str = ")";
        while (!stack.isEmpty()) {
          var e = stack.pop();
          str = e + str;
          if (e.equals("(")) {
            break;
          }
        }
        if (stack.isEmpty()) {
          valid += str;
        } else {
          stack.push(str);
        }
      }
    }
    for (var e : stack) {
      if (!e.equals("(")) {
        valid += e;
      }
    }
    return valid;
  }

  public static void main(String[] args) {
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
    System.out.println(minRemoveToMakeValid("))(("));
    System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
  }
}
