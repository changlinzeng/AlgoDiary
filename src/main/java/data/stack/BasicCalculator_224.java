package data.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BasicCalculator_224 {
  public static int calculate(String s) {
    var nums = new ArrayList<Integer>();
    doCal(s, 0, nums);
    return nums.stream().reduce(0, Integer::sum);
  }

  private static int doCal(String s, int from, List<Integer> nums) {
    Integer num = null, sign = 1, i = from;
    s = s + " ";
    while (i < s.length()) {
      var c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        if (num == null) {
          num = 0;
        }
        num = num * 10 + (c - '0');
        i++;
      } else {
        if (num != null) {
          nums.add(sign * num);
          num = null;
          sign = 1;
        }
        if (c == '-') {
          sign = -1;
          i++;
        } else if (c == '(') {
          var res = new ArrayList<Integer>();
          var start = doCal(s, i + 1, res);
          var sum = res.stream().reduce(0, Integer::sum);
          nums.add(sign * sum);
          sign = 1;
          i = start + 1;
        } else {
          if (c == ')') {
            break;
          }
          i++;
        }
      }
    }
    // return the position of right parentheses
    return i;
  }

  public static int calculate2(String s) {
    var nums = new Stack<Integer>();
    var ops = new Stack<Character>();
    Integer num = null;
    var symbols = Set.of('+', '-', '(');
    s = s + " ";
    for (var i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      if (ch >= '0' && ch <= '9') {
        if (num == null) {
          num = 0;
        }
        num = num * 10 + (ch - '0');
      } else {
        if (num != null) {
          if (!ops.isEmpty() && ops.peek() != '(') {
            num = cal(ops.pop(), nums.pop(), num);
          }
          nums.push(num);
          num = null;
        }

        if (symbols.contains(ch)) {
          if (ch == '-') {
            var k = i - 1;
            while (k >= 0 && s.charAt(k) == ' ') {
              k--;
            }
            // '-' is unary operator
            if (k == -1 || s.charAt(k) == '(') {
              nums.push(0);
            }
          }
          ops.push(ch);
        } else if (ch == ')') {
          ops.pop();  // pop '('
          if (!ops.isEmpty()) {
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
      default -> throw new IllegalStateException("Unexpected value: " + op);
    };
  }

  public static void main(String[] args) {
//    System.out.println(calculate2("1+1"));
//    System.out.println(calculate2("1 + 1"));
//    System.out.println(calculate2("2 -1+ 2"));
//    System.out.println(calculate2("-1+ 20"));
//    System.out.println(calculate2("1-(-2)"));
//    System.out.println(calculate2("1+(2+3)"));
//    System.out.println(calculate2("2-(-1 +2)"));
//    System.out.println(calculate2("2-(5-6)"));
//    System.out.println(calculate2("2-(3+(-1 +2))"));
//    System.out.println(calculate2("- (3 + (4 + 5))"));
//    System.out.println(calculate2("(7)-(0)-(4)"));
//    System.out.println(calculate2("(7)-(0)+(4)"));
//    System.out.println(calculate2("8+2-6+(8+4-(1)+8-10)"));
//    System.out.println(calculate2("8+4-(1)+8-10"));
    System.out.println(calculate2("2-4-(8+2-6+(8+4-(1)+8-10))"));
  }
}
