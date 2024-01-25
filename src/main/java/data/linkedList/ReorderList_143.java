package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class ReorderList_143 {
  /**
   * 1 -> 2 -> 3 -> 4 -> 5 reverse to 1 -> 2 -> 3 <- 4 <- 5
   * 1 -> 2 -> 3 -> 4 -> 5 -> 6 reverse to 1 -> 2 -> 3 <- 4 <- 5 <- 6
   * and then build new list from both ends
   * @param list
   * @return
   */
  public static ListNode<Integer> reorder(List<Integer> list) {
    var virtual = new ListNode<Integer>();
    var mid = list.head;
    var fast = list.head;

    // find mid
    while (fast.next != null) {
      fast = fast.next;
      if (fast.next != null) {
        fast = fast.next;
        mid = mid.next;
      }
    }

    // reverse from mid to end
    var prev = mid;
    var cur = prev.next;
    while (cur != null) {
      var next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    mid.next = null;

    // build new list from both ends
    var start = list.head;
    var tail = virtual;
    while (start != mid) {
      var next = start.next;
      tail.next = start;
      tail = tail.next;
      start = next;

      next = fast.next;
      tail.next = fast;
      tail = tail.next;
      fast = next;
    }
    tail.next = mid;
    mid.next = fast;
    fast.next = null;

    return virtual.next;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 2, 3, 4, 5});
    list.head = reorder(list);
    list.print();
  }
}
