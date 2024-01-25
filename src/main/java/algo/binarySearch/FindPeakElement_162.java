package algo.binarySearch;

public class FindPeakElement_162 {
  public static int findPeakElement(int[] nums) {
    int len = nums.length;
    int low = 0, high = len - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
              (mid == len - 1 || nums[mid] > nums[mid + 1])) {
        return mid;
      }
      if (nums[mid] < nums[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low;
  }

  public static void main(String[] args) {
    System.out.println(findPeakElement(new int[]{1,2,3,1}));
    System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    System.out.println(findPeakElement(new int[]{1}));
    System.out.println(findPeakElement(new int[]{1,2}));
    System.out.println(findPeakElement(new int[]{1,2,3}));
  }
}
