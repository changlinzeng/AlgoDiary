package algo.monotonicStack;

import java.util.Stack;

public class FindTheMostCompetitiveSubsequence_1673 {
  public static int[] mostCompetitive(int[] nums, int k) {
    // use increasing stack and remove larger numbers from tack.
    // ensure the total number of elements in the stack and the remaining in the array equal to k
    var stack = new Stack<Integer>();
    for (int i = 0; i < nums.length; i++) {
      int size = stack.size() + nums.length - i;
      while (size > k && !stack.isEmpty() && stack.peek() > nums[i]) {
        stack.pop();
        size = stack.size() + nums.length - i;
      }
      stack.push(nums[i]);
    }

    int[] competitive = new int[k];
    for (int i = 0; i < k; i++) {
      competitive[i] = stack.elementAt(i);
    }

    return competitive;
  }

  public static void main(String[] args) {
//    var nums = mostCompetitive(new int[]{3, 5, 2, 6}, 2);
//    var nums = mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
    var nums = mostCompetitive(new int[]{84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71}, 24);
    for (var i : nums) {
      System.out.println(i);
    }
  }
}
