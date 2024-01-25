package algo.binarySearch;

public class FindMinimumInRotatedSortedArray_153 {
  public static int findMin(int[] nums) {
    int len = nums.length;
    int low = 0, high = len - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      // nums[low] < nums[high] means we are on either the
      // left side or the right side in an increasing order
      if (nums[low] < nums[high]) {
        return nums[low];
      }
      if (nums[mid] >= nums[low]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return nums[low];
  }

  public static void main(String[] args) {
    System.out.println(findMin(new int[]{3,4,5,1,2}));
    System.out.println(findMin(new int[]{4,5,6,7,8,0,1,2}));
  }
}
