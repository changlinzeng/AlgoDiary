package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1_380 {
  static class RandomizedSet {
    private final Map<Integer, Node> nodeMap; // map of {position: node}
    private final Node data;
    private Node tail;
    private final Random rand;

    public RandomizedSet() {
      data = new Node(0, -1);
      tail = data;
      nodeMap = new HashMap<>();
      rand = new Random();
    }

    public boolean insert(int val) {
      if (nodeMap.containsKey(val)) {
        return false;
      }
      var nextIndex = tail.index + 1;
      var node = new Node(val, nextIndex);
      nodeMap.put(val, node);
      tail.next = node;
      node.prev = tail;
      tail = tail.next;
      return true;
    }

    public boolean remove(int val) {
      if (!nodeMap.containsKey(val)) {
        return false;
      }
      var node = nodeMap.get(val);
      nodeMap.remove(val);
      // remove node from list
      var prev = node.prev;
      prev.next = node.next;
      if (node.next != null) {
        node.next.prev = prev;
      }
      if (node == tail) {
        tail = node.prev;
      }
      // update index from removed node afterward
      var idx = prev.index + 1;
      var cur = prev.next;
      while (cur != null) {
        cur.index = idx++;
        cur = cur.next;
      }
      return true;
    }

    public int getRandom() {
      var index = rand.nextInt(tail.index + 1);
      var cur = data.next;
      while (cur != null && cur.index != index) {
        cur = cur.next;
      }
      return cur.val;
    }

    static class Node {
      public int val;
      public int index;
      public Node prev;
      public Node next;
      public Node(int val, int index) {
        this.val = val;
        this.index = index;
      }
    }
  }

  public static void main(String[] args) {
    var rs = new RandomizedSet();
    rs.insert(1);
    rs.remove(2);
    rs.insert(2);
    rs.getRandom();
    rs.remove(1);
    rs.insert(2);
    rs.getRandom();
//    rs.insert(3);
//    rs.remove(3);
//    rs.remove(0);
//    rs.insert(3);
//    rs.getRandom();
//    rs.remove(0);
  }
}
