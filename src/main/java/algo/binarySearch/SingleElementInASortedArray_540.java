package algo.binarySearch;

public class SingleElementInASortedArray_540 {
    public static int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int from, int to) {
        var mid = from + (to - from) / 2;
        if (mid == from) {
            return nums[mid];
        }

        if (nums[mid] == nums[mid + 1]) {
            if ((to - mid + 1) % 2 == 0) {
                return binarySearch(nums, from, mid - 1);
            } else {
                return binarySearch(nums, mid, to);
            }
        } else if (nums[mid] == nums[mid - 1]) {
            if ((mid - from + 1) % 2 == 0) {
                return binarySearch(nums, mid + 1, to);
            } else {
                return binarySearch(nums, from, mid);
            }
        } else {
            return nums[mid];
        }
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,10,11}));
    }
}
