package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class RotateList_61 {
  public static void rotate(List<Integer> list, int k) {
    var virtual = new ListNode<Integer>();
    virtual.next = list.head;

    int len = 0;
    var end = virtual;
    for (int i = 0; i <= k && end != null; i++) {
      end = end.next;
      len++;
    }
    len--;

    // if k > list length, calculate the actual offset
    if (end == null) {
      var kk = k % len;
      end = virtual;
      for (int i = 0; i <= kk; i++) {
        end = end.next;
      }
    }

    var start = virtual.next;
    while (end.next != null) {
      end = end.next;
      start = start.next;
    }

    end.next = virtual.next;
    list.head = start.next;
    start.next = null;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 2, 3, 4, 5});
    rotate(list, 12);
    list.print();
  }
}
