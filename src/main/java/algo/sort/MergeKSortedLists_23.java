package algo.sort;

import datautil.list.List;
import datautil.list.ListNode;

public class MergeKSortedLists_23 {
    public static ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
        ListNode<Integer> node = null;
        for (var list : lists) {
            node = merge(node, list);
        }
        return node;
    }

    private static ListNode<Integer> merge(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null) {
            return list2;
        }

        var head = new ListNode<Integer>();
        var tail = head;
        ListNode<Integer> cur1 = list1, cur2 = list2;
        while (cur1 != null && cur2 != null) {
            while (cur1 != null && cur2 != null && cur1.val <= cur2.val) {
                tail.next = cur1;
                cur1 = cur1.next;
                tail = tail.next;
            }
            while (cur1 != null && cur2 != null && cur2.val <= cur1.val) {
                tail.next = cur2;
                tail = tail.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            tail.next = cur2;
        }
        if (cur2 == null) {
            tail.next = cur1;
        }

        return head.next;
    }

    public static void main(String[] args) {
        var list1 = List.fromArray(new Integer[]{1,4,5});
        var list2 = List.fromArray(new Integer[]{1,3,4});
        var list3 = List.fromArray(new Integer[]{2,6});
        var lists = new ListNode[]{list1.head, list2.head};
        mergeKLists(lists);
    }
}
