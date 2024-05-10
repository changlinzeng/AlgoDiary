package data.stack;

import java.util.ArrayList;

public class BasicCalculator_II_227 {
  public static int calculate(String s) {
    var nums = new ArrayList<Integer>();
    var operator = '+';
    Integer num = null;
    var ss = s + " ";  // append space to end so we can process all nums
    for (var i = 0; i < ss.length(); i++) {
      var c = ss.charAt(i);
      if (c >= '0' && c <= '9') {
        if (num == null) {
          num = 0;
        }
        num = num * 10 + (c - '0');
      } else {
        if (num != null) {
          switch (operator) {
            case '+' -> nums.add(num);
            case '-' -> nums.add(-1 * num);
            case '*' -> nums.set(nums.size() - 1, nums.getLast() * num);
            case '/' -> nums.set(nums.size() - 1, nums.getLast() / num);
          }
          num = null;
        }
        if (c == '+' || c == '-' || c == '*' || c == '/') {
          operator = c;
        }
      }
    }
    return nums.stream().reduce(0, Integer::sum);
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
