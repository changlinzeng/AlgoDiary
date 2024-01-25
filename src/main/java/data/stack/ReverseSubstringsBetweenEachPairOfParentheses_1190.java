package data.stack;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses_1190 {
  public static String reverseParentheses(String s) {
    var stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (c != ')') {
        stack.push(c);
      } else {
        // pop from stack and reverse
        String sub = "";
        while (!stack.isEmpty()) {
          var top = stack.pop();
          if (top == '(') {
            break;
          }
          sub += top;
        }
        for (int j = 0; j < sub.length(); j++) {
          stack.push(sub.charAt(j));
        }
      }
    }

    var result = "";
    for (int k = 0; k < stack.size(); k++) {
      result += stack.elementAt(k);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(reverseParentheses("(abcd)"));
    System.out.println(reverseParentheses("(u(love)i)"));
    System.out.println(reverseParentheses("(ed(et(oc))el)"));
  }
}
