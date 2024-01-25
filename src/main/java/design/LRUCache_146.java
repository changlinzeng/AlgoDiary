package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
  static class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> data;
    private final Node head;
    private Node tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.data = new HashMap<>();
      this.head = new Node();
      tail = head;
    }

    public int get(int key) {
      if (!data.containsKey(key)) {
        return -1;
      }
      var node = data.get(key);

      // last element node need to move
      if (node.prev == head) {
        return node.val;
      }

      // move node to front
      remove(node);
      insertHead(node);

      return node.val;
    }

    public void put(int key, int value) {
      if (data.containsKey(key)) {
        // update node
        var node = data.get(key);
        node.val = value;
        remove(node);
        insertHead(node);
      } else {
        if (this.data.size() == this.capacity) {
          // remove last node
          var node = data.remove(tail.key);
          remove(node);
        }
        // insert node at front
        var node = new Node(key, value);
        data.put(key, node);
        insertHead(node);
      }
    }

    private void insertHead(Node node) {
      var next = head.next;
      node.prev = head;
      node.next = next;
      head.next = node;
      if (next != null) {
        next.prev = node;
      } else {
        tail = node;
      }
    }

    private void remove(Node node) {
      Node prev = node.prev, next = node.next;
      if (node == tail) {
        tail = prev;
      }
      prev.next = next;
      if (next != null) {
        next.prev = prev;
      }
      node.prev = null;
      node.next = null;
    }

  }

  static class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;
    public Node() {
    }
    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public static void main(String[] args) {
//    var cache = new LRUCache(2);
//    cache.put(1, 1);
//    cache.put(2, 2);
//    cache.get(1);
//    cache.put(3, 3);
//    cache.get(2);
//    cache.put(4, 4);
//    cache.get(1);
//    cache.get(3);
//    cache.get(4);

//    var cache = new LRUCache(1);
//    cache.put(2, 1);
//    cache.get(2);

    var cache = new LRUCache(2);
    cache.put(2, 6);
    cache.put(1, 5);
    cache.put(1, 2);
    cache.get(1);
    cache.get(2);
    cache.get(2);
  }
}
