package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class SwapNodesInPairs_24 {
  public static void swap(List<Integer> list) {
    var virtual = new ListNode<Integer>();
    virtual.next = list.head;

    var prev = virtual;
    var odd = virtual.next;
    var even = odd.next;

    while (odd != null && even != null) {
      // swap
      prev.next = even;
      odd.next = even.next;
      even.next = odd;

      // move
      prev = odd;
      odd = odd.next;
      if (odd != null) {
        even = odd.next;
      }
    }

    list.head = virtual.next;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1});
    swap(list);
    list.print();
  }
}
