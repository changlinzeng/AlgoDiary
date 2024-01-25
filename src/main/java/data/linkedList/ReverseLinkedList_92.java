package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class ReverseLinkedList_92 {
  public static void reverse(List<Integer> list, int from, int to) {
    var virtual = new ListNode<Integer>();
    virtual.next = list.head;

    var pivot = virtual;
    for (int i = 0; i < from - 1; i++) {
      pivot = pivot.next;
    }

    var prev = pivot;
    var cur = prev.next;
    for (int i = 0; i <= to - from; i++) {
      var next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    pivot.next.next = cur;
    pivot.next = prev;

    list.head = virtual.next;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 2, 3, 4, 5,});
    reverse(list, 1, 5);
    list.print();
  }
}
