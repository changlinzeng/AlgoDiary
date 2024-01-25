package algo.twoPointers;

public class LongestMountainInArray_845 {
  public static int longestMountain(int[] arr) {
    int len = arr.length;
    int longest = 0;

    int start = -1, peak = -1;
    for (var i = 1; i < len; i++) {
      if (arr[i] > arr[i - 1] && start == -1) {
        start = i - 1;
        peak = -1;
      }
      if (arr[i] == arr[i - 1]) {
        if (start != -1 && peak != -1) {
          longest = Math.max(longest, i - start);
        }
        start = -1;
        peak = -1;
      }
      if (arr[i] < arr[i - 1] && peak == -1 && start != -1) {
        peak = i - 1;
      }
      if (start != -1 && peak != -1) {
        if (arr[i] >= arr[i - 1]) {
          longest = Math.max(longest, i - start);
          start = i - 1;
          peak = -1;
        } else {
          if (i == len - 1) {
            longest = Math.max(longest, len - start);
            start = -1;
            peak = -1;
          }
        }
      }
    }

    return longest;
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
