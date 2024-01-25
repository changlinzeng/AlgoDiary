package design;

import datautil.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode_382 {
  static class Solution {
    private final List<Integer> data;
    private final Random rand;

    public Solution(ListNode<Integer> head) {
      this.data = new ArrayList<>();
      this.rand = new Random();
      var cur = head;
      while (cur != null) {
        this.data.add(cur.val);
        cur = cur.next;
      }
    }

    public int getRandom() {
      var bound = this.data.size();
      var idx = rand.nextInt(bound);
      return this.data.get(idx);
    }
  }
}
