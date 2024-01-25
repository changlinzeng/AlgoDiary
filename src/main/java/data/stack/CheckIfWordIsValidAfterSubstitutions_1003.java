package data.stack;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions_1003 {
  public static boolean isValid(String s) {
    var stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char a = '\0', b = '\0';
      var ch = s.charAt(i);
      if (ch != 'c') {
        stack.push(ch);
      } else {
        if (!stack.isEmpty()) {
          b = stack.pop();
        }
        if (!stack.isEmpty()) {
          a = stack.pop();
        }
        if (a != 'a' || b != 'b') {
          if (a != '\0') {
            stack.push(a);
          }
          if (b != '\0') {
            stack.push(b);
          }
          stack.push(ch);
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("aabcbc"));
    System.out.println(isValid("abcabcababcc"));
    System.out.println(isValid("abccba"));
    System.out.println(isValid("babcc"));
    System.out.println(isValid("abacbcabcc"));
  }
}
