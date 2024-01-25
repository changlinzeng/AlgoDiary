package design;

import java.util.*;

public class MaximumFrequencyStack_895 {
  static class FreqStack {
    private final ArrayList<Integer> data;
    private final Map<Integer, Node> freq;  // {val -> freq}
    private final Node head;  // maintain the order of freq
    private Node tail;

    public FreqStack() {
      this.data = new ArrayList<>();
      this.freq = new HashMap<>();
      this.head = new Node();
      this.tail = this.head;
    }

    public void push(int val) {
      this.data.add(val);

      if (!this.freq.containsKey(val)) {
        var node = new Node(val);
        freq.put(val, node);
        // insert node after tail
        tail.next = node;
        node.prev = tail;
        tail = node;
      } else {
        var node = freq.get(val);
        node.count++;
        var cur = node.prev;
        while (cur != head && cur.count < node.count) {
          cur = cur.prev;
        }
        // move node
        if (cur != node.prev) {
          Node prev = node.prev, next = node.next;
          if (node == tail) {
            tail = node.prev;
          }
          // remove
          prev.next = next;
          if (next != null) {
            next.prev = prev;
          }
          // insert
          next = cur.next;
          node.prev = cur;
          node.next = next;
          cur.next = node;
          if (next != null) {
            next.prev = node;
          }
        }
      }
    }

    public int pop() {
      if (head.next == null) {
        return -1;
      }
      var count = head.next.count;
      var candidates = new HashSet<Integer>();
      for (var cur = head.next; cur != null && cur.count == count; cur = cur.next) {
        candidates.add(cur.val);
      }
      Node candidate = null;
      int removed = -1;
      for (var i = data.size() - 1; i >= 0; i--) {
        if (candidates.contains(data.get(i))) {
          candidate = freq.get(data.get(i));
          removed = data.remove(i);
          break;
        }
      }
      if (candidate != null) {
        candidate.count--;
        if (candidate.count == 0) {
          freq.remove(candidate.val);
          if (candidate == tail) {
            tail = candidate.prev;
          }
          candidate.prev.next = candidate.next;
          if (candidate.next != null) {
            candidate.next.prev = candidate.prev;
          }
          candidate.prev = null;
          candidate.next = null;
          return removed;
        }
        // move candidate afterward
        if (candidate != tail && candidate.next.count > candidate.count) {
          var cur = candidate.next;
          while (cur != null && cur.count >= candidate.count) {
            cur = cur.next;
          }
          if (cur == null) {
            // move candidate to tail
            candidate.prev.next = candidate.next;
            candidate.next.prev = candidate.prev;
            tail.next = candidate;
            candidate.prev = tail;
            tail = candidate;
            candidate.next = null;
          } else {
            if (cur != candidate.next) {
              // move candidate before cur
              var prev = cur.prev;
              // remove
              candidate.prev.next = candidate.next;
              candidate.next.prev = candidate.prev;
              // insert
              candidate.next = cur;
              candidate.prev = prev;
              cur.prev = candidate;
              prev.next = candidate;
            }
          }
        }
      }

      return removed;
    }
  }

  static class Node {
    public int val;
    public int count;
    public Node prev;
    public Node next;
    public Node() {}
    public Node(int val) {
      this.val = val;
      this.count = 1;
    }
  }

  public static void main(String[] args) {
//    var stack = new FreqStack();
//    stack.push(5);
//    stack.push(7);
//    stack.push(5);
//    stack.push(7);
//    stack.push(4);
//    stack.push(5);
//    System.out.println(stack.pop());
//    System.out.println(stack.pop());
//    System.out.println(stack.pop());
//    System.out.println(stack.pop());

    var stack = new FreqStack();
    for (var n : List.of(8,2,2,2,8,8,9,9,8,8,2,2,8,2,9,9,9,2,9,8,8,2,2,2,8,2,2,8,9,8,8,8,9,2,9,2,9,2,9,9,8,9,2,9,2,8,8,9,9,2)) {
      stack.push(n);
    }
    for (var i = 0; i < 50; i++) {
      System.out.println(stack.pop());
    }
  }
}
