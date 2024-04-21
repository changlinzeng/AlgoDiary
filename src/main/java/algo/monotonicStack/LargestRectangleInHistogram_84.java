package algo.monotonicStack;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {
  public static int largestRectangleArea(int[] heights) {
    var len = heights.length;
    var maxStack = new Stack<Integer>();  // index of height in increasing order
    int maxArea = 0, top = 0;

    for (var i = 0; i < len; i++) {
      if (maxStack.isEmpty() || heights[maxStack.peek()] < heights[i]) {
        maxStack.push(i);
      } else {
        while (!maxStack.isEmpty() && heights[maxStack.peek()] >= heights[i]) {
          top = maxStack.pop();
          // calculate the area from top backward till height < height[i]
          maxArea = Math.max(maxArea, (i - top) * heights[top]);

        }
        // update height > height[i] to height[i]
        // so all heights between top and i equal to height[i] and the stack is still monotonic
        heights[top] = heights[i];
        maxStack.push(top);
      }
    }
    // calculate for the indices left in the stack
    while (!maxStack.isEmpty()) {
      top = maxStack.pop();
      maxArea = Math.max(maxArea, (len - top) * heights[top]);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    System.out.println(largestRectangleArea(new int[]{2,4}));
    System.out.println(largestRectangleArea(new int[]{1,1}));
  }
}
