package algo.sort;

import java.util.Arrays;

public class WiggleSort {
  public static void sort(int[] nums) {
    int len = nums.length;
    var arr = new int[len];

    arr = Arrays.copyOf(nums, len);
    Arrays.sort(arr);

    int mid = len / 2;
    int right = len - 1;

    for (int i = 0; i < len; i++) {
      if (i % 2 == 1) {
        // odd
        nums[i] = arr[right];
        right--;
      } else {
        // even
        nums[i] = arr[mid];
        mid--;
      }
    }
  }

  public static void main(String[] args) {
    var arr = new int[]{5, 1, 8, 2, 3, 9};
    sort(arr);
    for (int n : arr) {
      System.out.println(n);
    }
  }

}
