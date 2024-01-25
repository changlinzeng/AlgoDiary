package data.stack;

import java.util.Stack;

public class ValidateStackSequences_946 {
  public static boolean validateStackSequences(int[] pushed, int[] popped) {
    var stack = new Stack<Integer>();
    var i = 0;
    for (var in : pushed) {
      stack.push(in);
      while (!stack.isEmpty() && stack.peek() == popped[i]) {
        stack.pop();
        i++;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
  }
}
