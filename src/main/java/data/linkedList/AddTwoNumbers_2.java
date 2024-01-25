package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

public class AddTwoNumbers_2 {
  public static ListNode<Integer> add(List<Integer> l1, List<Integer> l2) {
    var cur1 = l1.head;
    var cur2 = l2.head;
    var virtual = new ListNode<Integer>();
    int carry = 0;

    while (cur1 != null || cur2 != null || carry != 0) {
      int sum = carry;
      carry = 0;
      if (cur1 != null) {
        sum += cur1.value;
        cur1 = cur1.next;
      }
      if (cur2 != null) {
        sum += cur2.value;
        cur2 = cur2.next;
      }

      if (sum > 9) {
        carry = 1;
        sum = sum % 10;
      }
      var newNode = new ListNode<>(sum);
      newNode.next = virtual.next;
      virtual.next = newNode;
    }

    return virtual.next;
  }

  public static void main(String[] args) {
    var list1 = List.fromArray(new Integer[]{1, 2, 3});
    var list2 = List.fromArray(new Integer[]{1, 2, 8});
    var result = new List<Integer>();
    result.head = add(list1, list2);
    result.print();
  }
}
