package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class RemoveNthNodeFromEndOfList_19 {
  public static void remove(List<Integer> list, int n) {
    var virtual = new ListNode<Integer>();
    virtual.next = list.head;

    // determine the window
    var end = virtual;
    for (int i = 0; i < n && end != null; i++) {
      end = end.next;
    }
    if (end == null) {
      return;
    }

    // move window to the end
    var prev = virtual;
    var start = virtual.next;
    while (end.next != null) {
      prev = prev.next;
      start = start.next;
      end = end.next;
    }

    // remove
    prev.next = start.next;
    if (start == list.head) {
      list.head = prev.next;
    }
    start.next = null;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 2, 3, 4, 5});
    remove(list, 6);
    list.print();
  }
}
