package algo.binarySearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private static int findFirst(int[] nums, int target) {
        var len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            var mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    private static int findLast(int[] nums, int target) {
        var len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            var mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (mid < len - 1 && nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,2,3}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }
}
