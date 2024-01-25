package algo.binarySearch;

public class BinarySearch {
  /**
   * Binary search with time complexity O(logn)
   * Work with strictly increasing or decreasing sequence
   */
  public static int binarySearch(int[] nums, int target) {
    int begin = 0, end = nums.length - 1;

    while (begin <= end) {
      int mid = begin + (end - begin) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }
    }

    return -1;
  }

  /**
   * Search the first element equals to target in a sorted sequence
   */
  public static int searchFirstEqual(int[] nums, int target) {
    int begin = 0, end = nums.length - 1;

    while (begin <= end) {
      int mid = begin + (end - begin) / 2;
      if (target == nums[mid]) {
        // check if previous element equals to target
        if (mid > 0 && target == nums[mid - 1]) {
          end = mid - 1;
        } else {
          return mid;
        }
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }
    }

    return -1;
  }

  /**
   * Search the first element equals or greater than target in a sorted sequence
   */
  public static int searchFirstEqualOrGreater(int[] nums, int target) {
    int begin = 0, end = nums.length - 1;

    int mid = begin + (end - begin) / 2;
    while (begin <= end) {
      mid = begin + (end - begin) / 2;
      if (target == nums[mid]) {
        if (mid > 0 && target == nums[mid - 1]) {
          end = mid - 1;
        } else {
          return mid;
        }
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }
    }

    if (target > nums[mid]) {
      return mid < nums.length - 1 ? mid + 1 : -1;
    } else {
      return mid;
    }
  }

  /**
   * Search the last element that is equal to less than target in strictly sorted sequence
   */
  public static int searchLastEqualOrLess(int[] nums, int target) {
    int start = 0, end = nums.length - 1, mid;
    while (start < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        if (mid < nums.length - 1 && nums[mid + 1] > target) {
          return mid;
        } else if (mid < nums.length - 1 && nums[mid + 1] == target) {
          return mid + 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (mid > 0 && nums[mid - 1] <= target) {
          return mid - 1;
        } else {
          end = mid - 1;
        }
      }
    }

    return start;
  }
}
