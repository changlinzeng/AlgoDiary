package algo.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        var mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);

        // optimization for best cases. In this case, the first part and second part are already sorted
        if (nums[mid] > nums[mid + 1]) {
//        merge(nums, start, mid, end);
            inplaceMerge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] arr = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                arr[k++] = nums[i++];
            } else {
                arr[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = nums[i++];
        }
        while (j <= end) {
            arr[k++] = nums[j++];
        }

        for (int m = start; m <= end; m++) {
            nums[m] = arr[m - start];
        }
    }

    private static void inplaceMerge(int[] nums, int start, int mid, int end) {
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                i++;
            } else {
                // shift elements in range (i, j - 1)
                int k = j, tmp = nums[j];
                while (k > i) {
                    nums[k] = nums[k - 1];
                    k--;
                }
                nums[i] = tmp;
                i++;
                j++;
                mid++;
            }
        }
    }

    public static void main(String[] args) {
//        var arr = new int[]{2,1};
//        var arr = new int[]{1,1};
//        var arr = new int[]{1};
//        var arr = new int[]{1,2,3};
//        var arr = new int[]{3,2,1};
        var arr = new int[]{1,2,3,2,1};
//        var arr = new int[]{};
        mergeSort(arr);
        Arrays.stream(arr).asLongStream().forEach(System.out::println);
    }

}
