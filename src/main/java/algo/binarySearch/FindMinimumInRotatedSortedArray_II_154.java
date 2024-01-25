package algo.binarySearch;

public class FindMinimumInRotatedSortedArray_II_154 {
  public static int findMin(int[] nums) {
    // 4 4 5 6 7 0 0 1 3 4
    int len = nums.length, low = 0, high = len - 1;
    if (nums[0] < nums[len - 1]) {
      return nums[0];
    }

    while (low < high) {
      var mid = low + (high - low) / 2;
      if (mid == low) {
        return Math.min(nums[low], nums[high]);
      } else {
        // determine which side we are on
        var allEqual = true;
        if (nums[low] == nums[high] && nums[mid] == nums[low]) {
          for (var i = low; i < mid; i++) {
            if (nums[i] < nums[low]) {
              // on the right
              allEqual = false;
              high = mid;
              break;
            }
          }
          for (var i = mid; i < high; i++) {
            if (nums[i] < nums[low]) {
              // on the left
              allEqual = false;
              low = mid;
              break;
            }
          }
          // all elements are equal
          if (allEqual) {
            return nums[mid];
          }
        } else if (nums[mid] >= nums[low]) {
          // on the left
          while (mid < high && nums[mid] == nums[high] && nums[mid + 1] == nums[low]) {
            mid++;
          }
          low = mid;
        } else if (nums[mid] <= nums[high]) {
          // on the right
          while (mid > low && nums[mid] == nums[high] && nums[mid - 1] == nums[high]) {
            mid--;
          }
          high = mid;
        }
      }
    }
    return nums[low];
  }

  public static void main(String[] args) {
    System.out.println(findMin(new int[]{1,3,5}));
    System.out.println(findMin(new int[]{2,2,2,0,1}));
    System.out.println(findMin(new int[]{4,4,5,6,0,1,4}));
    System.out.println(findMin(new int[]{4,4,5,6,0,1,2,4}));
    System.out.println(findMin(new int[]{1,1,1}));
    System.out.println(findMin(new int[]{1,1,2,1,1}));
    System.out.println(findMin(new int[]{1,1,2,1}));
    System.out.println(findMin(new int[]{10,1,10,10,10}));
    System.out.println(findMin(new int[]{3,3,1,3}));
    System.out.println(findMin(new int[]{2,0,1,1,1}));
  }
}
