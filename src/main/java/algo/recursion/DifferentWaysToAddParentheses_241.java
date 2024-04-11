package algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses_241 {
  public static List<Integer> diffWaysToCompute(String expression) {
    return compute(expression, 0, expression.length() - 1);
  }

  private static List<Integer> compute(String exp, int start, int end) {
    var result = new ArrayList<Integer>();
    for (var i = start; i <= end; i++) {
      var c = exp.charAt(i);
      if (c == '+' || c == '-' || c == '*' || c == '/') {
        var nums1 = compute(exp, start, i - 1);
        var nums2 = compute(exp, i + 1, end);
        for (var n1 : nums1) {
          for (var n2 : nums2) {
            var res = switch (c) {
              case '+' -> n1 + n2;
              case '-' -> n1 - n2;
              case '*' -> n1 * n2;
              case '/' -> n1 / n2;
              default -> throw new IllegalStateException("Unexpected value: " + c);
            };
            result.add(res);
          }
        }
      }
    }
    if (result.isEmpty()) {
      result.add(Integer.parseInt(exp.substring(start, end + 1)));
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(diffWaysToCompute("1+2*2"));
  }
}
