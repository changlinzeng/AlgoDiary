package design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache_460 {
  static class LFUCache {
    private final int capacity;
    private final Map<Integer, Node> data;
    private final TreeMap<Integer, Node> freqFirst;  // first node with the same count
    private final Node head;
    private Node tail;

    public LFUCache(int capacity) {
      this.capacity = capacity;
      this.data = new HashMap<>();
      this.freqFirst = new TreeMap<>();
      head = new Node();
      tail = head;
    }

    public int get(int key) {
      var node = this.data.getOrDefault(key, null);
      if (node == null) {
        return -1;
      }
      moveFirst(node);
      return node.value;
    }

    public void put(int key, int value) {
      if (this.data.containsKey(key)) {
        modifyNode(key, value);
      } else {
        addNode(key, value);
      }
    }

    private void addNode(int key, int val) {
      if (this.data.size() == this.capacity) {
        // remove the first node with count
        if (this.tail.prev == this.head || this.tail.prev.count != this.tail.count) {
          freqFirst.remove(this.tail.count);
        }
        this.data.remove(this.tail.key);
        remove(this.tail);
      }
      var node = new Node(key, val, 1);
      var first = this.freqFirst.get(1);
      var target = first == null ? this.tail : first.prev;
      this.data.put(key, node);
      this.freqFirst.put(1, node);
      insertAfter(target, node);
    }

    private void modifyNode(int key, int val) {
      var node = this.data.get(key);
      moveFirst(node);
      node.value = val;
      this.data.put(key, node);
    }

    // move node as the first node with same count
    private void moveFirst(Node node) {
      var first = this.freqFirst.get(node.count);
      var nextFirst = this.freqFirst.get(node.count + 1);
      var target = nextFirst == null ? first.prev : nextFirst.prev;
      // find the next node with same count
      if (first == node) {
        if (first.next != null && first.next.count == node.count) {
          this.freqFirst.put(first.count, first.next);
        } else {
          this.freqFirst.remove(first.count);
        }
      }

      node.count++;
      this.freqFirst.put(node.count, node);
      remove(node);
      insertAfter(target, node);
    }

    private void remove(Node node) {
      var prev = node.prev;
      var next = node.next;
      prev.next = next;
      if (next != null) {
        next.prev = prev;
      }
      if (node == this.tail) {
        this.tail = prev;
      }
      node.prev = null;
      node.next = null;
    }

    private void insertAfter(Node target, Node node) {
      var next = target.next;
      node.prev = target;
      node.next = next;
      target.next = node;
      if (next != null) {
        next.prev = node;
      }
      if (target == this.tail) {
        this.tail = node;
      }
    }

    static class Node {
      public int key;
      public int value;
      public int count;
      public Node prev;
      public Node next;
      public Node() {}
      public Node(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
      }
    }
  }

  public static void main(String[] args) {
    var cache = new LFUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));
    cache.put(3, 3);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    cache.put(4, 4);
    System.out.println(cache.get(1));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));

//    var cache = new LFUCache(3);
//    cache.put(1,1);
//    cache.put(2,2);
//    cache.put(3,3);
//    cache.put(4,4);
//    System.out.println(cache.get(4));
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(2));
//    System.out.println(cache.get(1));
//    cache.put(5,5);
//    System.out.println(cache.get(1));
//    System.out.println(cache.get(2));
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(4));
//    System.out.println(cache.get(5));

//    var cache = new LFUCache(3);
//    cache.put(2,2);
//    cache.put(1,1);
//    System.out.println(cache.get(2));
//    System.out.println(cache.get(1));
//    System.out.println(cache.get(2));
//    cache.put(3,3);
//    cache.put(4,4);
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(2));
//    System.out.println(cache.get(1));
//    System.out.println(cache.get(4));

//    var cache = new LFUCache(2);
//    cache.put(2,1);
//    cache.put(2,2);
//    System.out.println(cache.get(2));
//    cache.put(1,1);
//    cache.put(4,1);
//    System.out.println(cache.get(2));
  }
}
