package data.stack;

import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
  private static final List<String> ops = List.of("+", "-", "*", "/");
  public int evalRPN(String[] tokens) {
    var stack = new Stack<Integer>();
    for (var token : tokens) {
      if (ops.contains(token)) {
        int num2 = stack.pop(), num1 = stack.pop();
        var res = switch (token) {
          case "+" -> num1 + num2;
          case "-" -> num1 - num2;
          case "*" -> num1 * num2;
          case "/" -> num1 / num2;
          default -> Integer.MAX_VALUE;
        };
        stack.push(res);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
