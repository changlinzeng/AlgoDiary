package data.linkedList;

import datautil.list.List;

import java.util.Stack;

public class NextGreaterNodeInLinkedList_1019 {
  public static int[] nextGreaterNode(List<Integer> list) {
    var len = 0;
    for (var p = list.head; p != null; p = p.next) {
      len++;
    }

    var result = new int[len];
    var stack = new Stack<Integer>();
    var cur = list.head;
    var index = 0;

    while (cur != null) {
      if (stack.isEmpty() || cur.value <= stack.peek()) {
        stack.push(cur.value);
        cur = cur.next;
        index++;
      } else {
        var count = index - 1;
        while (!stack.isEmpty() && stack.peek() < cur.value) {
          if (result[count] == 0) {
            stack.pop();
            result[count] = cur.value;
          }
          count--;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
//    var list = List.fromArray(new Integer[]{9, 7, 5, 3, 4, 8});
//    var list = List.fromArray(new Integer[]{1, 7, 5, 1, 9, 2, 5, 1});
//    var list = List.fromArray(new Integer[]{2, 7, 4, 3, 5});
    var list = List.fromArray(new Integer[]{2, 1, 5});
    int[] result = nextGreaterNode(list);
    for (int i : result) {
      System.out.println(i);
    }
  }
}
