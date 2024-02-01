package design;

public class MinStack_155 {
  static class MinStack {

    private final Node head;
    private Node tail;
    public MinStack() {
      this.head = new Node();
      this.tail = head;
    }

    public void push(int val) {
      var node = new Node(val);
      head.next = node;
      node.prev = tail;
      if (tail == head) {
        node.min = node.val;
      } else {
        node.min = Math.min(tail.min, node.val);
      }
      tail = node;
    }

    public void pop() {
      tail.prev.next = tail.next;
      tail = tail.prev;
    }

    public int top() {
      return tail.val;
    }

    public int getMin() {
      return tail.min;
    }
  }

  static class Node {
    public int val;
    public int min;  // min val in the range of head to current node
    public Node prev;
    public Node next;
    public Node() {}
    public Node(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    var ms = new MinStack();
    ms.push(-2);
    ms.push(0);
    ms.push(-3);
    System.out.println(ms.getMin());
    ms.pop();
    System.out.println(ms.top());
    System.out.println(ms.getMin());
  }
}
