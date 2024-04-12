package data.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II_503 {
  public static int[] nextGreaterElement(int[] nums) {
    var len = nums.length;
    var result = new int[len];
    var stack = new Stack<Integer>();  // store the index of the element in the array

    Arrays.fill(result, -1);

    for (int i = 0; i < len * 2; i++) {
      var k = i % len;

      while (!stack.isEmpty() && nums[stack.peek()] < nums[k]) {
        result[stack.pop()] = nums[k];
      }

      stack.push(k);
    }

    return result;
  }

  public static void main(String[] args) {
    var arr = nextGreaterElement(new int[]{1, 2, 1});
//    var arr = nextGreaterElement(new int[]{9, 7, 5, 3, 4, 8});
//    var arr = nextGreaterElement(new int[]{1, 7, 5, 1, 9, 2, 5, 1});
//    var arr = nextGreaterElement(new int[]{2, 7, 4, 3, 5});
//    var arr = nextGreaterElement(new int[]{1});
//    var arr = nextGreaterElement(new int[]{1,2,3,4,5,6,5,4,5,1,2,3});
//    var arr = nextGreaterElement(new int[]{1,2,2,2,2,2,2,2,2,2,2,2,100});
    for (int i : arr) {
      System.out.println(i);
    }
  }
}
