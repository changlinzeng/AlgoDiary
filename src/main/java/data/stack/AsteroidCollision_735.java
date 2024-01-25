package data.stack;

import java.util.Stack;

public class AsteroidCollision_735 {
  public static int[] collision(int[] nums) {
    var stack = new Stack<Integer>();

    var index = 0;
    while (index < nums.length) {
      var col = nums[index];
      while (!stack.isEmpty() && stack.peek() > 0 && col < 0) {
        var top = stack.pop();
        if (top + col> 0) {
          col = top;
        }
        if (top + col < 0) {
          col = nums[index];
        }
        if (top + col == 0) {
          col = 0;
        }
      }

      if (col != 0) {
        stack.push(col);
      }
      index++;
    }

    int len = stack.size();
    var result = new int[len];
    for (int i = 0; i < len; i++) {
      result[i] = stack.elementAt(i);
    }

    return result;
  }

  public static void main(String[] args) {
//    var asteroid = collision(new int[]{5, 10, -5});
//    var asteroid = collision(new int[]{8, -8});
//    var asteroid = collision(new int[]{10, 2, -5});
    var asteroid = collision(new int[]{-2, -1, 1, 2});
    for (int i : asteroid) {
      System.out.println(i);
    }
  }
}
