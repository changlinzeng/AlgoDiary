package algo.twoPointers;

public class MedianOfTwoSortedArrays_4 {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    var mid = (len1 + len2) / 2;
    var even = (len1 + len2) % 2 == 0;
    int i = 0, j = 0, count = 0, cur = 0;
    while (i < len1 && j < len2 && count < mid) {
      while (i < len1 && count < mid && nums1[i] <= nums2[j]) {
        cur = nums1[i];
        i++;
        count++;
      }
      while (j < len2 && i < len1 && count < mid && nums2[j] < nums1[i]) {
        cur = nums2[j];
        j++;
        count++;
      }
    }
    if (count < mid) {
      while (i < len1 && count < mid) {
        cur = nums1[i];
        i++;
        count++;
      }
      while (j < len2 && count < mid) {
        cur = nums2[j];
        j++;
        count++;
      }
    }
    var next1 = i < len1 ? nums1[i] : Integer.MAX_VALUE;
    var next2 = j < len2 ? nums2[j] : Integer.MAX_VALUE;
    if (even) {
      return (cur + Math.min(next1, next2)) / 2.0;
    } else {
      return Math.min(next1, next2);
    }
  }

  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3}));
    System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{1,2}));
    System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,5,7}));
    System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2}));
  }
}
