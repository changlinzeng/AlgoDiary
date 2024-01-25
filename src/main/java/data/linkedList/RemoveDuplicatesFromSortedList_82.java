package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class RemoveDuplicatesFromSortedList_82 {
  public static void removeDuplicates(List<Integer> list) {
    var virtual = new ListNode<Integer>();
    virtual.next = list.head;

    var prev = virtual;
    var to = virtual.next;

    while (prev.next != null) {
      // find duplicates
      while (to != null && to.value == prev.next.value) {
        to = to.next;
      }

      // remove
      if (prev.next.next != to) {
        prev.next = to;
      } else {
        prev = prev.next;
      }
    }

    list.head = virtual.next;
  }

  public static void main(String[] args) {
//    var list = List.fromArray(new Integer[]{3, 3, 1});
//    var list = List.fromArray(new Integer[]{1, 2, 3, 3, 4, 4, 5});
    var list = List.fromArray(new Integer[]{1, 1, 1, 2, 3});
    removeDuplicates(list);
    list.print();
  }
}
