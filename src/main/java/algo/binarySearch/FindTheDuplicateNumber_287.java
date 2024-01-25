package algo.binarySearch;

public class FindTheDuplicateNumber_287 {
  public static int findDuplicate(int[] nums) {
    int len = nums.length;
    int begin = 0, end = len - 1;
    while (begin < end) {
      int mid = begin + (end - begin) / 2;
      // count numbers that are less than mid
      int count = 0;
      for (int i = 0; i < len; i++) {
        if (nums[i] <= mid) {
          count++;
        }
      }

      // if the number of numbers less than mid greater than mid,
      // it means there are duplicates between [1, mid]
      // Otherwise, the duplicates are in [mid + 1, end]
      if (count > mid) {
        end = mid;
      } else {
        begin = mid + 1;
      }
    }

    return begin;
  }

  public static void main(String[] args) {
    System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
  }
}
