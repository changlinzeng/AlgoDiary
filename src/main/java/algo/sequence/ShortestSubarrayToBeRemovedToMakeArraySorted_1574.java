package algo.sequence;

public class ShortestSubarrayToBeRemovedToMakeArraySorted_1574 {
  public static int findLengthOfShortestSubarray(int[] arr) {
    var len = arr.length;
    int left = 0, right = len - 1;  // first and last index causes non-sorted
    while (left < len - 1 && arr[left] <= arr[left + 1]) {
      left++;
    }

    // already sorted
    if (left == len - 1) {
      return 0;
    }

    while (right > left && arr[right - 1] <= arr[right]) {
      right--;
    }

    var minLen = Math.min(len - left - 1, right);
    int i = 0, j = right;
    while (i <= left && j < len) {
      if (arr[j] >= arr[i]) {
        minLen = Math.min(j - i - 1, minLen);
        i++;
      } else {
        j++;
      }
    }

    return minLen;
  }

  public static void main(String[] args) {
    System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
    System.out.println(findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
    System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3}));
    System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,10,0,7,8,9}));
    System.out.println(findLengthOfShortestSubarray(new int[]{2,2,2,1,1,1}));
    System.out.println(findLengthOfShortestSubarray(new int[]{13,0,14,7,18,18,18,16,8,15,20}));
    System.out.println(findLengthOfShortestSubarray(new int[]{6,3,10,11,15,20,13,3,18,12}));
    System.out.println(findLengthOfShortestSubarray(new int[]{16,10,0,3,22,1,14,7,1,12,15}));
    System.out.println(findLengthOfShortestSubarray(new int[]{11,26,3,14,24,6,10,16,32,9,36,24,27,17,31,32,35,36,11,22,30}));
  }
}
