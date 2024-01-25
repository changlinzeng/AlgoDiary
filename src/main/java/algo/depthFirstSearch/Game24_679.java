package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game24_679 {
  private static final char[] operators = new char[]{'+', '-', '*', '/'};
  public static boolean judgePoint24(int[] cards) {
    return dfs(Arrays.stream(cards).boxed().collect(Collectors.toList()));
  }

  private static boolean dfs(List<Integer> nums) {
    if (nums.size() == 1) {
      return nums.get(0) == 24;
    }
    var len = nums.size();
    for (var i = 0; i < len; i++) {
      for (var j = i + 1; j < len; j++) {
        for (var op : operators) {
          var result = operate(nums.get(i), nums.get(j), op);
          if (result != Integer.MAX_VALUE) {
            var next = new ArrayList<Integer>();
            next.add(result);
            for (var k = 0; k < len; k++) {
              if (k != i && k != j) {
                next.add(nums.get(k));
              }
            }
            if (dfs(next)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  private static int operate(int a, int b, char op) {
    if (op == '/' && b == 0) {
      return Integer.MAX_VALUE;
    }
    return switch (op) {
      case '+' -> a + b;
      case '-' -> a - b;
      case '*' -> a * b;
      case '/' -> a / b;
      default -> throw new IllegalStateException("Unexpected value: " + op);
    };
  }

  public static void main(String[] args) {
//    System.out.println(judgePoint24(new int[]{4,1,8,7}));
//    System.out.println(judgePoint24(new int[]{1,2,1,2}));
//    System.out.println(judgePoint24(new int[]{1,5,9,1}));
//    System.out.println(judgePoint24(new int[]{1,9,1,2}));
    System.out.println(judgePoint24(new int[]{5,4,5,7}));
  }
}
