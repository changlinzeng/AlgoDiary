package algo.binarySearch;

public class SearchInRotatedSortedArray_II_81 {
  public static boolean search(int[] nums, int target) {
    int len = nums.length;
    int low = 0, high = len - 1;
    int mid;

    while (low <= high) {
      mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[mid] > nums[low]) {  // in upper section
        if (target < nums[mid] && target >= nums[low]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] < nums[high]) {  // in lower section
        if (target <= nums[high] && target > nums[mid]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        if (nums[mid] == nums[low]) {
          low++;
        }
        if (nums[mid] == nums[high]) {
          high--;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(search(new int[]{2,5,6,0,0,1,2}, 0));
    System.out.println(search(new int[]{2,5,6,0,0,1,2}, 3));
    System.out.println(search(new int[]{2,5,6,0,0,1,2}, 2));
    System.out.println(search(new int[]{2,5,6,0,0,1,2}, 7));
    System.out.println(search(new int[]{2,5,6,0,0,1,2}, 6));
    System.out.println(search(new int[]{1,0,1,1,1}, 0));
  }
}
