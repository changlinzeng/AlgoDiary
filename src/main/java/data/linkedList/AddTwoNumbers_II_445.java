package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

import java.util.Stack;

public class AddTwoNumbers_II_445 {
  public static ListNode<Integer> add(List<Integer> list1, List<Integer> list2) {
    var virtual = new ListNode<Integer>();
    var num1 = new Stack<Integer>();
    var num2 = new Stack<Integer>();

    for (var cur1 = list1.head; cur1 != null; cur1 = cur1.next) {
      num1.push(cur1.value);
    }

    for (var cur2 = list2.head; cur2 != null; cur2 = cur2.next) {
      num2.push(cur2.value);
    }

    int carry = 0;
    while (!num1.empty() || !num2.empty()) {
      var sum = carry;
      if (!num1.empty()) {
        sum += num1.pop();
      }
      if (!num2.empty()) {
        sum += num2.pop();
      }

      if (sum > 9) {
        sum = sum % 10;
        carry = 1;
      } else {
        carry = 0;
      }

      var newNode = new ListNode<>(sum);
      var next = virtual.next;
      virtual.next = newNode;
      newNode.next = next;
    }

    if (carry != 0) {
      var newNode = new ListNode<>(carry);
      var next = virtual.next;
      virtual.next = newNode;
      newNode.next = next;
    }

    return virtual.next;
  }

  public static void main(String[] args) {
//    var list1 = List.fromArray(new Integer[]{7, 2, 4, 3});
//    var list2 = List.fromArray(new Integer[]{5, 6, 4});
    var list1 = List.fromArray(new Integer[]{5});
    var list2 = List.fromArray(new Integer[]{5});
    var result = new List<Integer>();
    result.head = add(list1, list2);
    result.print();
  }
}
