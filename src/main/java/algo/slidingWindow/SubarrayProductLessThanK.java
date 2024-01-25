package algo.slidingWindow;

public class SubarrayProductLessThanK {
  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    int count = 0;
    int left = 0, right = 0;
    int product = 1;

    while (left <= right && right < nums.length) {
      product = product * nums[right];
      if (product < k) {
        System.out.println(left + "-" + right);
        count++;
      } else {
      }
      while (left < right) {
        product = product / nums[left];
        left++;
        if (product < k) {
          count++;
          System.out.println(left + ":" + right);
        }
      }
      right++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
  }
}
