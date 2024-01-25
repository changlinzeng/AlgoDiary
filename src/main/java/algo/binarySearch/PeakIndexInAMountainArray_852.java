package algo.binarySearch;

public class PeakIndexInAMountainArray_852 {
    public static int peakIndexInMountainArray(int[] arr) {
        var len = arr.length;
        var start = 0;
        var end = len - 1;

        while (start < end) {
            var mid = start + (end - start) / 2;
            if (mid > 0 && mid < len - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] < arr[mid + 1]) {
                // we are on the left side
                start = mid + 1;
            }
            if (arr[mid] > arr[mid + 1]) {
                // we are on the right side
                end = mid - 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,2,3,0}));
        System.out.println(peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }
}
