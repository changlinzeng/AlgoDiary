package algo.twoPointers;

public class LongestMountainInArray_845 {
  public static int longestMountain(int[] arr) {
    var start = 0;
    var maxLen = 0;
    while (start < arr.length - 1) {
      if (arr[start] < arr[start + 1]) {
        // try to find mountain
        var end = start;
        while (end < arr.length - 1 && arr[end] < arr[end + 1]) {
          end++;
        }
        if (end == arr.length - 1) {
          break;
        }
        if (arr[end] == arr[end + 1]) {
          start = end + 1;
          continue;
        }
        while (end < arr.length - 1 && arr[end] > arr[end + 1]) {
          end++;
        }
        maxLen = Math.max(maxLen, end - start + 1);
        start = end;
      } else {
        start++;
      }
    }
    return maxLen;
  }

  public static int longestMountain_2(int[] arr) {
    var len = arr.length;
    var longest = 0;
    for (var i = 0; i < len; i++) {
      int j = i, left = i, right = i;
      // check left
      while (j > 0 && arr[j - 1] < arr[j]) {
        j--;
      }
      left = j;
      // check right
      j = i;
      while (j < len - 1 && arr[j] > arr[j + 1]) {
        j++;
      }
      right = j;
      if (left != i && right != i) {
        longest = Math.max(longest, right - left + 1);
      }
    }
    return longest;
  }

  public static void main(String[] args) {
    System.out.println(longestMountain_2(new int[]{2,1,4,7,3,2,5}));
    System.out.println(longestMountain_2(new int[]{2, 2, 2}));
    System.out.println(longestMountain_2(new int[]{2,1,4,7,3,2}));
    System.out.println(longestMountain_2(new int[]{1,4,7,3,2}));
    System.out.println(longestMountain_2(new int[]{1,4,7,6,5,6}));
    System.out.println(longestMountain_2(new int[]{7,4,8}));
    System.out.println(longestMountain_2(new int[]{2,3,1,2,3,4,5,6}));
    System.out.println(longestMountain_2(new int[]{875,884,239,731,723,685}));
    System.out.println(longestMountain_2(new int[]{0,0,1,0,0,1,1,1,1,1}));
  }
}
