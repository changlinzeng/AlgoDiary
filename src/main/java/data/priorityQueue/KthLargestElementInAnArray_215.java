package data.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementInAnArray_215 {
  public static int findKthLargest(int[] nums, int k) {
    // min heap
    var minheap = new ArrayList<Integer>();
    for (var num : nums) {
      if (minheap.size() < k) {
        minheap.add(num);
        if (minheap.size() == k) {
          // heapify
          for (int i = k / 2; i >= 0; i--) {
            heapify(minheap, i);
          }
        }
      } else {
        if (num > minheap.get(0)) {
          minheap.remove(0);
          minheap.add(num);
          // heapify
          for (int i = k / 2; i >= 0; i--) {
            heapify(minheap, i);
          }
        }
      }
    }

    return minheap.get(0);
  }

  private static void heapify(List<Integer> list, int index) {
    var left = index * 2 + 1;
    var right = index * 2 + 2;
    var root = index;
    var min = root;
    if (left < list.size() && list.get(left) < list.get(min)) {
      min = left;
    }
    if (right < list.size() && list.get(right) < list.get(min)) {
      min = right;
    }
    if (min != root) {
      // swap
      var tmp = list.get(root);
      list.set(root, list.get(min));
      list.set(min, tmp);
    }
  }

  /**
   * Pick a pivot and put nums greater than pivot to the left and the smaller ones to the right
   * Check the position of pivot.
   * If position == k - 1, return.
   * If position < k - 1, repeat from position to end
   * If position > k - 1, repeat from 0 to position
   */
  public static int quickSelect(int[] nums, int start, int end) {
    int pivot = start;
    while (start < end) {
      while (start < end && nums[start] >= nums[pivot]) {
        start++;
      }
      while (end > pivot && nums[end] <= nums[pivot]) {
        end--;
      }
      if (start < end) {
        swap(nums, start, end);
      }
    }
    swap(nums, pivot, end);
    return end;
  }

  public static int quickFindKthLargest(int[] nums, int k) {
    int len = nums.length, pivot = 0, start = 0, end = len - 1;
    while (pivot != k - 1) {
      if (pivot > k - 1) {
        pivot = quickSelect(nums, 0, pivot - 1);
      } else if (pivot < k - 1) {
        pivot = quickSelect(nums, pivot, end);
      }
    }
    return nums[pivot];
  }

  private static void swap(int[] nums, int a, int b) {
    var tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }

  public static void main(String[] args) {
//    System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
//    System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
//    System.out.println(findKthLargest(new int[]{2, 1}, 2));
//    System.out.println(quickFindKthLargest(new int[]{3,2,1,5,6,4}, 2));
//    System.out.println(quickFindKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    System.out.println(quickFindKthLargest(new int[]{2,1}, 2));
  }
}
