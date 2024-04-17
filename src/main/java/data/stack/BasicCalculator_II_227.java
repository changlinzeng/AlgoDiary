package data.stack;

import java.util.Stack;

public class BasicCalculator_II_227 {
  public static int calculate2(String s) {
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

  // Timeout !!
  public static int calculate(String s) {
    var indexPlus = s.lastIndexOf('+');
    var indexMinus = s.lastIndexOf('-');
    var indexMultiply = s.lastIndexOf('*');
    var indexDivide = s.lastIndexOf('/');

    if (indexPlus > indexMinus) {
      return calculate(s.substring(0, indexPlus)) + calculate(s.substring(indexPlus + 1));
    }
    if (indexMinus > indexPlus) {
      return calculate(s.substring(0, indexMinus)) - calculate(s.substring(indexMinus + 1));
    }
    if (indexMultiply > indexDivide) {
      return calculate(s.substring(0, indexMultiply)) * calculate(s.substring(indexMultiply + 1));
    }
    if (indexDivide > indexMultiply) {
      return calculate(s.substring(0, indexDivide)) / calculate(s.substring(indexDivide + 1));
    }

    return Integer.parseInt(s.trim());
  }

  public static void main(String[] args) {
    System.out.println(calculate("3 + 2*2"));
    System.out.println(calculate("3 / 2"));
    System.out.println(calculate(" 3/2"));
    System.out.println(calculate(" 3/2 "));
    System.out.println(calculate(" 3+5 / 2"));
    System.out.println(calculate("52"));
    System.out.println(calculate("52 / 2"));
    System.out.println(calculate("1-1+1"));
    System.out.println(calculate("1-1-1"));
    System.out.println(calculate("1+2*5/3+6/4*2"));
  }
}
