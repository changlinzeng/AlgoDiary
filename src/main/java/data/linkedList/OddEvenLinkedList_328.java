package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class OddEvenLinkedList_328 {
  public static ListNode<Integer> oddEvenLinkedList(List<Integer> list) {
    var oddHead = new ListNode<Integer>();
    var oddTail = oddHead;
    var evenHead = new ListNode<Integer>();
    var evenTail = evenHead;
    var cur = list.head;

    while (cur != null) {
      oddTail.next = cur;
      oddTail = oddTail.next;

      cur = cur.next;
      if (cur != null) {
        evenTail.next = cur;
        evenTail = evenTail.next;
        cur = cur.next;
      }
    }

    oddTail.next = evenHead.next;
    evenTail.next = null;

    return oddHead.next;
  }

  public static void main(String[] args) {
    var list = List.fromArray(new Integer[]{1, 2, 3, 4, 5});
    list.head = oddEvenLinkedList(list);
    list.print();
  }
}
