package algo.binarySearch;

import java.util.Arrays;

public class HIndex_II_275 {
  public static int hIndex(int[] citations) {
    int len = citations.length;
    int low = 0, high = len - 1, mid;
    Arrays.sort(citations);

    while (low <= high) {
      mid = low + (high - low) / 2;
      if (len - mid > citations[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return len - low;
  }

  public static void main(String[] args) {
    System.out.println(hIndex(new int[]{3,0,6,1,5}));
    System.out.println(hIndex(new int[]{1,3,1}));
//    System.out.println(hIndex(new int[]{0,1,3,5,6}));
//    System.out.println(hIndex(new int[]{1,2,100}));
//    System.out.println(hIndex(new int[]{1,2,3,4}));
//    System.out.println(hIndex(new int[]{100}));
  }
}
