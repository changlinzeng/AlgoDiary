package algo.sort;

import datautil.list.List;
import datautil.list.ListNode;

public class InsertionSortList_147 {
  public static void insertionSort(List<Integer> list) {
    var virtual = new ListNode<Integer>();
    var cur = list.head;
    ListNode<Integer> pos;

    while (cur != null) {
      for (pos = virtual; pos.next != null && pos.next.value < cur.value; pos = pos.next) {
      }

      // insert cur after pos
      var next = cur.next;
      cur.next = pos.next;
      pos.next = cur;
      cur = next;
    }

    list.head = virtual.next;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 4});
    insertionSort(list);
    list.print();
  }
}
