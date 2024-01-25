package algo.binarySearch;

public class SearchInRotatedSortedArray_33 {
  public static int sort(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (nums[mid] > nums[low]) {  // in the upper
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] < nums[high]) {  // in the lower
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        // low = high - 1
        if (mid == low) {
          low++;
        }
        if (mid == high) {
          high--;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{5, 7, 9, 1, 3};
    System.out.println(sort(nums, 5));
    System.out.println(sort(nums, 7));
    System.out.println(sort(nums, 9));
    System.out.println(sort(nums, 1));
    System.out.println(sort(nums, 3));
    System.out.println(sort(nums, 2));
  }
}
