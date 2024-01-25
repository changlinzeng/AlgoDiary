package data.stack;

import java.util.Stack;

public class DailyTemperatures_739 {
  public static int[] dailyTemperatures(int[] temperatuers) {
    var len = temperatuers.length;
    var result = new int[len];
    var stack = new Stack<Integer>();  // store index

    for (var i = 0; i < len; i++) {
      while (!stack.isEmpty() && temperatuers[stack.peek()] < temperatuers[i]) {
        var index = stack.pop();
        result[index] = i - index;
      }

      stack.push(i);
    }

    return result;
  }

  public static void main(String[] args) {
//    var days = dailyTemperatures(new int[]{30, 60, 90});
//    var days = dailyTemperatures(new int[]{30, 40, 50, 60});
    var days = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    for (int i : days) {
      System.out.println(i);
    }
  }
}
