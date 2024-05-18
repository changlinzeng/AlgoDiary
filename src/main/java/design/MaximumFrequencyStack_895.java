package design;

import java.util.*;

public class MaximumFrequencyStack_895 {
  static class FreqStack {
    private Map<Integer, Integer> freq;
    private Queue<Node> pq;
    private int seq;

    public FreqStack() {
      this.freq = new HashMap<>();  // val -> freq
      this.pq = new PriorityQueue<>((a, b) -> {
        if (a.count == b.count) {
          return b.seq - a.seq;
        }
        return b.count - a.count;
      });
      this.seq = 0;
    }

    public void push(int val) {
      this.seq++;
      this.freq.put(val, this.freq.getOrDefault(val, 0) + 1);
      this.pq.offer(new Node(val, this.seq, this.freq.get(val)));
    }

    public int pop() {
      if (this.pq.isEmpty()) {
        return -1;
      }
      var node = this.pq.poll();
      this.freq.put(node.val, this.freq.get(node.val) - 1);
      return node.val;
    }
  }

  static class Node {
    public int val;
    public int seq;
    public int count;
    public Node(int val, int seq, int count) {
      this.val = val;
      this.seq = seq;
      this.count = count;
    }
  }

  public static void main(String[] args) {
    var stack = new FreqStack();
    stack.push(5);
    stack.push(7);
    stack.push(5);
    stack.push(7);
    stack.push(4);
    stack.push(5);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
