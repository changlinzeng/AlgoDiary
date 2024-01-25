package data.stack;

import java.util.Stack;

public class BasicCalculator_II_227 {
  public static int calculate(String s) {
    char c, sign = '+';
    int num = 0, result = 0, len = s.length();
    var operand = new Stack<Integer>();
    for (int i = 0; i < len; i++) {
      c = s.charAt(i);
      var isDigit = c >= '0' && c <= '9';
      var isOperator = c == '+' || c == '-' || c == '*' || c == '/';

      if (isDigit) {
        num = num * 10 + Integer.parseInt(c + "");
      }
      if (isOperator || i == len -1) {
        switch (sign) {
          case '+' -> operand.push(num);
          case '-' -> operand.push(-1 * num);
          case '*' -> operand.push(operand.pop() * num);
          case '/' -> operand.push(operand.pop() / num);
          default -> {
          }
        }
        num = 0;
        sign = c;
      }
    }

    while (!operand.isEmpty()) {
      result += operand.pop();
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(calculate("3 + 2*2"));
    System.out.println(calculate("3 / 2"));
    System.out.println(calculate(" 3/2"));
    System.out.println(calculate(" 3/2 "));
    System.out.println(calculate(" 3+5 / 2"));
    System.out.println(calculate("52"));
    System.out.println(calculate("52 / 2"));
  }
}
