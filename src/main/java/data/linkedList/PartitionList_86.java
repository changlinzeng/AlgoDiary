package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class PartitionList_86 {
  public static ListNode<Integer> partition(List<Integer> list, int x) {
    var virtual = new ListNode<Integer>();
    virtual.next = list.head;

    var newVirtual = new ListNode<Integer>();
    var tail = newVirtual;

    var cur = virtual;
    while (cur.next != null) {
      // remove node from origin list and append to new list
      if (cur.next.value >= x) {
        tail.next = cur.next;
        cur.next = cur.next.next;
        tail = tail.next;
        tail.next = null;
      } else {
        cur = cur.next;
      }
    }

    for (cur = virtual; cur.next != null; cur = cur.next) {
    }

    cur.next = newVirtual.next;

    return virtual.next;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 4, 3, 2, 5, 2});
    var plist = new List<Integer>();
    plist.head = partition(list, 5);
    plist.print();
  }
}
