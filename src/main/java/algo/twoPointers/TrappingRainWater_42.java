package algo.twoPointers;

public class TrappingRainWater_42 {
  public static int trap2(int[] height) {
    int left = 0, right = 0, len = height.length;
    var sum = 0;
    while (left < len) {
      if (left == len - 1) {
        break;
      }
      // find right
      right = left + 1;
      if (height[right] < height[left]) {
        var r = right;
        for (var h = height[left]; h > height[right]; h--) {
          while (r < len && height[r] < h) {
            r++;
          }
          if (r < len) {
            break;
          } else {
            r = right;
          }
        }
        right = r;
        if (right < len) {
          // calculate water between left and right
//          System.out.printf("%d - %d\n", left, right);
          var min = Math.min(height[left], height[right]);
          for (var i = left + 1; i < right; i++) {
            sum += (min - height[i]);
          }
          left = right;
        } else {
          left++;
        }
      } else {
        left++;
      }
    }

    return sum;
  }

  /**
   * Find the max value after each position i and then calculate for each element from i to max
   */
  public static int trap(int[] height) {
    var len = height.length;
    var position = new int[len]; // the position of the max value after i
    var max = len - 1;
    for (var i = len - 2; i >= 0; i--) {
      if (height[i + 1] >= height[max]) {
        max = i + 1;
      }
      position[i] = max;
    }

    int from = 0, to = 1, sum = 0;
    while (to < len) {
      var maxPos = position[from];
      var maxH = Math.min(height[from], height[maxPos]);
      while (to < maxPos && height[to] < height[from]) {
        sum += maxH - height[to];
        to++;
      }
      from = to;
      to = from + 1;
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(trap(new int[]{4,2,0,3,2,5}));
    System.out.println(trap(new int[]{4,2,3}));
    System.out.println(trap(new int[]{3,2,1,2,1,3}));

    System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(trap2(new int[]{4,2,0,3,2,5}));
    System.out.println(trap2(new int[]{4,2,3}));
    System.out.println(trap2(new int[]{3,2,1,2,1,3}));
  }
}
