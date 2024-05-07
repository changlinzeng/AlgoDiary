package algo.twoPointers;

public class TrappingRainWater_42 {
  /**
   * find the max value on the left of i and max value on the right of i
   * then the trapped water is determined by min(left max, right max) - height[i]
   */
  public static int trap(int[] height) {
    var len = height.length;
    var leftMax = new int[len];
    var maxIdx = 0;
    for (var i = 1; i < len; i++) {
      if (height[i] > height[maxIdx]) {
        maxIdx = i;
      }
      leftMax[i] = maxIdx;
    }

    var rightMax = new int[len];
    rightMax[len - 1] = len - 1;
    maxIdx = len - 1;
    for (var i = len -2; i >= 0; i--) {
      if (height[i] > height[maxIdx]) {
        maxIdx = i;
      }
      rightMax[i] = maxIdx;
    }

    var trapped = 0;
    for (var i = 1; i < len - 1; i++) {
      var water = Math.min(height[leftMax[i]], height[rightMax[i]]) - height[i];
      trapped += water;
    }
    return trapped;
  }

  public static void main(String[] args) {
    System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(trap(new int[]{4,2,0,3,2,5}));
    System.out.println(trap(new int[]{4,2,3}));
    System.out.println(trap(new int[]{3,2,1,2,1,3}));
  }
}
