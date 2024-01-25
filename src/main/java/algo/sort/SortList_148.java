package algo.sort;

import datautil.list.ListNode;

public class SortList_148 {
  // Sort a linked list in O(n log n) time using constant space complexity.
  // Only merge sort can achieve this
  public ListNode<Integer> sortList(ListNode<Integer> head) {
    if (head == null || head.next == null) {
      return head;
    }

    // find middle
    var middle = findMiddle(head);

    // split list into two
    var next = middle.next;
    middle.next = null;
    middle = next;

    // sort each list and merge two sorted lists
    var head1 = sortList(head);
    var head2 = sortList(middle);
    return merge(head1, head2);
  }

  private ListNode<Integer> findMiddle(ListNode<Integer> head) {
    var slow = head;
    var fast = head;
    while (fast != null) {
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
        if (fast != null) {
          slow = slow.next;
        }
      }
    }

    return slow;
  }

  private ListNode<Integer> merge(ListNode<Integer> list1, ListNode<Integer> list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    if (list1.value < list2.value) {
      list1.next = merge(list1.next, list2);
      return list1;
    } else {
      list2.next = merge(list2.next, list1);
      return list2;
    }
  }
}
