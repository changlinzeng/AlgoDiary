package algo.slidingWindow;

public class MaxConsecutiveOnes_III_1004 {
  // similar to 424 (Longest Repeating Character Replacement)
  public static int longestOnes(int[] nums, int k) {
    int len = nums.length;
    int left = 0, right = 0;
    int maxlen = 0;
    int zeroCount = 0;
    while (right < len) {
      if (nums[right] == 0) {
        zeroCount++;
      }
      if (zeroCount <= k) {
        maxlen = Math.max(maxlen, right - left + 1);
      } else {
        while (left < right && zeroCount > k) {
          if (nums[left] == 0) {
            zeroCount--;
          }
          left++;
        }
      }
      right++;
    }

    return maxlen;
  }

  public static void main(String[] args) {
    System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    System.out.println(longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
    System.out.println(longestOnes(new int[]{0,0}, 0));
    System.out.println(longestOnes(new int[]{0}, 1));
  }
}
