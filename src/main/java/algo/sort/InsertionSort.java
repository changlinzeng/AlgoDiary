package algo.sort;

import datautil.list.List;
import datautil.list.ListNode;

public class InsertionSort {

  public static void sortArray(int[] nums) {
    int i, pos = 1;
    while (pos < nums.length) {
      for (i = 0; i < pos && nums[i] < nums[pos]; i++) {
      }
      int val = nums[pos];
      for (int j = pos; j > i; j--) {
        nums[j] = nums[j - 1];
      }
      nums[i] = val;
      pos++;
    }
  }

  /**
   * @param list
   * @return the new head of the sorted list
   */
  public static ListNode<Integer> sortList(List<Integer> list) {
    ListNode<Integer> virtualHead = new ListNode<>();
    ListNode<Integer> prev = virtualHead;
    ListNode<Integer> cur = list.head;

    while (cur != null) {
      // find the place to insert
      while (prev.next != null &&  prev.next.value < cur.value) {
        prev = prev.next;
      }

      // insert after prev
      ListNode<Integer> next = cur.next;
      cur.next = prev.next;
      prev.next = cur;
      prev= virtualHead;

      // move next
      cur = next;
    }

    return virtualHead.next;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{4};
//    sortArray(nums);
//    for (int i : nums) {
//      System.out.println(i);
//    }

    var list = List.fromArray(new Integer[]{4, 7, 1, 0, -5, 8, 41});
    list.head = sortList(list);
    list.print();
  }

}
