package data.linkedList;

import datautil.list.List;
import datautil.list.ListNode;

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodes_1171 {
  public static ListNode<Integer> removeZeroSumConsecutive(List<Integer> list) {
    var sum = 0;
    var head = list.head;
    var cur = head;
    var sumMap = new HashMap<Integer, ListNode<Integer>>();
    var virtual = new ListNode<Integer>();
    virtual.next = head;

    sumMap.put(0, virtual);

    // calculate sum
    while (cur != null) {
      sum += cur.value;
      if (sumMap.containsKey(sum)) {
        // find the same sum in the map so there is a zero segment
        // remove node from 'from' to 'to'
        var from = sumMap.get(sum);
        var to = cur;

        // clean entries for the removed nodes
        for (var p = from.next; p != cur; p = p.next) {
          for (var e : sumMap.entrySet()) {
            if (e.getValue() == p) {
              sumMap.remove(e.getKey());
              break;
            }
          }
        }

        from.next = to.next;
        cur = to.next;

      } else {
        sumMap.put(sum, cur);
        cur = cur.next;
      }
    }

    return virtual.next;
  }

  public static void main(String[] args) {
//    var list = List.fromArray(new Integer[]{1, 2, -3, 3, 1});
//    var list = List.fromArray(new Integer[]{1, 2, 3, -3, 4});
//    var list = List.fromArray(new Integer[]{1, 2, 3, -3, -2});
//    var list = List.fromArray(new Integer[]{1, 3, 2, -3, -2, 5, 5, -5, 1});
    var list = List.fromArray(new Integer[]{0, 0});
//    var list = List.fromArray(new Integer[]{2, 2, -2, 1, -1, -1});
    list.head = removeZeroSumConsecutive(list);
    list.print();
  }
}
