package data.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveKDigits_402 {
  public static String removeKDigits(String num, int k) {
    int len = num.length(), n = len - k;
    var stack = new Stack<Character>();
    if (k >= len) {
      return "0";
    }

    for (var i = 0; i < len; i++) {
      while (n < stack.size() + len - i && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
        stack.pop();
      }
      if (stack.size() < n) {
        stack.push(num.charAt(i));
      }
    }

    var result = stack.stream().map(String::valueOf).collect(Collectors.joining());
    var i = 0;
    for (; i < result.length(); i++) {
      if (result.charAt(i) != '0') {
        break;
      }
    }
    return i == result.length() ? "0" : result.substring(i);
  }

  public static void main(String[] args) {
    System.out.println(removeKDigits("1432219", 3));
    System.out.println(removeKDigits("10200", 1));
    System.out.println(removeKDigits("100200", 1));
    System.out.println(removeKDigits("10", 2));
    System.out.println(removeKDigits("9", 1));
    System.out.println(removeKDigits("112", 1));
    System.out.println(removeKDigits("10001", 4));
  }
}
