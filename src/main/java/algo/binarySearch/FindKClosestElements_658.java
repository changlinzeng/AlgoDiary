package algo.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements_658 {
  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    int len = arr.length;
    int low = 0, high = len - k;
    var result = new ArrayList<Integer>();

    while (low < high) {
      var mid = low + (high - low) / 2;
      if (x - arr[mid] > arr[mid + k] - x) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    for (int i = low; i < low + k; i++) {
      result.add(arr[i]);
    }

    return result;
  }

  public static void main(String[] args) {
//    var result = findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
//    var result = findClosestElements(new int[]{1,2,3,4,5}, 4, -1);
//    var result = findClosestElements(new int[]{1,2,3,4,5}, 4, 6);
//    var result = findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9);
    var result = findClosestElements(new int[]{1,1,2,2,2,2,2,3,3}, 3, 3);
    for (var n : result) {
      System.out.println(n);
    }
  }
}
