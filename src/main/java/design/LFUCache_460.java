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
//      this.freqFirst.put(0, head);
    }

    public int get(int key) {
      if (!data.containsKey(key)) {
        return -1;
      }
      var node = data.get(key);
      node.count++;
      moveFront(node);
      return node.value;
    }

    public void put(int key, int value) {
      // remove last node
      if (!data.containsKey(key) && data.size() == this.capacity) {
        var node = data.get(tail.key);
        if (freqFirst.get(node.count) == node) {
          freqFirst.remove(node.count);
        }
        data.remove(tail.key);
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
      }
      if (data.containsKey(key)) {
        var node = data.get(key);
        node.value = value;
        node.count++;
        moveFront(node);
      } else {
        var node = new Node(key, value, 1);
        data.put(key, node);
        tail.next = node;
        node.prev = tail;
        tail = node;
        moveFront(node);
        if (tail.next != null) {
          tail = tail.next;
        }
      }
    }

    private void moveFront(Node node) {
      // head -> prev -> node -> current -> next
      Node prev = null, next = node.next;
//      while (prev != head && prev.count <= node.count) {
//        prev = prev.prev;
//      }

      if (freqFirst.isEmpty()) {
        prev = head;
      } else {
        // find the first node with the same count
        for (var k : freqFirst.keySet()) {
          if (k > node.count) {
            break;
          }
          prev = freqFirst.get(k);
        }
        if (prev != null) {
          prev = prev.prev;
        }
      }

      var currentFirst = freqFirst.get(node.count - 1);
      // if current node is the first node of the group, then update with the next
      if (currentFirst == node) {
        if (currentFirst.next != null && currentFirst.next.count == node.count - 1) {
          freqFirst.put(node.count - 1, currentFirst.next);
        } else {
          // remove current if it is the only node
          freqFirst.remove(node.count - 1);
        }
      }
      freqFirst.put(node.count, node);

      // no other nodes have the same or smaller count so no need to move
      if (prev == null) {
        return;
      }

      // no need to move
      if (prev == node.prev) {
        return;
      }

      if (node == tail) {
        tail = node.prev;
      }

      node.prev.next = next;
      if (next != null) {
        next.prev = node.prev;
      }

      node.next = prev.next;
      node.prev = prev;
      prev.next.prev = node;
      prev.next = node;

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
//    var cache = new LFUCache(2);
//    cache.put(1, 1);
//    cache.put(2, 2);
//    System.out.println(cache.get(1));
//    cache.put(3, 3);
//    System.out.println(cache.get(2));
//    System.out.println(cache.get(3));
//    cache.put(4, 4);
//    System.out.println(cache.get(1));
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(4));

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

    var cache = new LFUCache(3);
    cache.put(2,2);
    cache.put(1,1);
    System.out.println(cache.get(2));
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
    cache.put(3,3);
    cache.put(4,4);
    System.out.println(cache.get(3));
    System.out.println(cache.get(2));
    System.out.println(cache.get(1));
    System.out.println(cache.get(4));

//    var cache = new LFUCache(2);
//    cache.put(2,1);
//    cache.put(2,2);
//    System.out.println(cache.get(2));
//    cache.put(1,1);
//    cache.put(4,1);
//    System.out.println(cache.get(2));
  }
}
