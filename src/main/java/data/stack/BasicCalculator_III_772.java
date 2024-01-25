package data.stack;

import java.util.Set;
import java.util.Stack;

public class BasicCalculator_III_772 {
  // "1 + 1" = 2
  // " 6-4 / 2 " = 4
  // "2*(5+5*2)/3+(6/2+8)" = 21
  // "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
  public static int calculate(String s) {
    var nums = new Stack<Integer>();
    var ops = new Stack<Character>();
    Integer num = null;
    var symbols = Set.of('+', '-', '*', '/', '(');
    s = s + " ";
    for (var i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      if (ch >= '0' && ch <= '9') {
        if (num == null) {
          num = 0;
        }
        num = num * 10 + (ch - '0');
      } else {
        if (num != null && ch != '(') {
          if (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
            var num1 = nums.pop();
            num = cal(ops.pop(), num1, num);
          }
          nums.push(num);
          num = null;
        }

        if (symbols.contains(ch)) {
          if (ch == '-') {
            // convert '-' to -1 * num
            var k = i - 1;
            while (k >= 0 && s.charAt(k) == ' ') {
              k--;
            }
            // '-' is not unary operator
            if (k >= 0 && s.charAt(k) != '(') {
              ops.push('+');
            }
            nums.push(-1);
            ops.push('*');
          } else {
            ops.push(ch);
          }
        } else if (ch == ')') {
          while (!ops.isEmpty()) {
            var op = ops.pop();
            if (op == '(') {
              break;
            }
            var num1 = nums.pop();
            var num2 = nums.pop();
            nums.push(cal(op, num2, num1));
          }
          // calculate multiply and divide as priority
          while (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
            var num1 = nums.pop();
            var num2 = nums.pop();
            nums.push(cal(ops.pop(), num2, num1));
          }
        }
      }
    }

    var result = nums.removeFirst();
    while (!ops.isEmpty()) {
      result = cal(ops.removeFirst(), result, nums.removeFirst());
    }

    return result;
  }

  private static int cal(char op, int num1, int num2) {
    return switch (op) {
      case '+' -> num1 + num2;
      case '-' -> num1 - num2;
      case '*' -> num1 * num2;
      case '/' -> num1 / num2;
      default -> throw new IllegalStateException("Unexpected value: " + op);
    };
  }

  public static void main(String[] args) {
    System.out.println(calculate("1 + 1"));
    System.out.println(calculate("-1+ 20"));
    System.out.println(calculate(" 6 - 4/2"));
    System.out.println(calculate("(7)-(0)-(4)"));
    System.out.println(calculate("(6/2+8)"));
    System.out.println(calculate("1- (6/2+8)"));
    System.out.println(calculate("2*(5+5*2)/3"));
    System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
    System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
  }
}
