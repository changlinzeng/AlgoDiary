package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllOOneDataStructure_432 {
  static class AllOne {
    private Map<String, Integer> count;
    private Map<Integer, Node> freqMap;
    private Node head;
    private Node tail;

    public AllOne() {
      count = new HashMap<>();
      freqMap = new HashMap<>();
      head = new Node();
      tail = head;
    }

    public void inc(String key) {
      var freq = count.getOrDefault(key, 0);
      var curNode = freqMap.get(freq);
      var node = freqMap.get(freq + 1);
      count.put(key, freq + 1);
      if (curNode != null) {
        // remove key from current node
        curNode.keys.remove(key);
        if (curNode.keys.isEmpty()) {
          // remove empty node
          freqMap.remove(freq);
          curNode.prev.next = curNode.next;
          if (curNode.next != null) {
            curNode.next.prev = curNode.prev;
          }
          if (curNode == tail) {
            tail = curNode.prev;
          }
        }
      }
      // add key to new node
      if (node != null) {
        node.keys.add(key);
      } else {
        var newNode = new Node(freq + 1);
        newNode.keys.add(key);
        freqMap.put(freq + 1, newNode);
        if (curNode == null || curNode.keys.isEmpty()) {
          var prev = curNode == null ? head : curNode.prev;
          newNode.next = prev.next;
          if (prev.next != null) {
            prev.next.prev = newNode;
          }
          prev.next = newNode;
          newNode.prev = prev;
          if (tail == prev) {
            tail = newNode;
          }
        } else {
          newNode.next = curNode.next;
          if (curNode.next != null) {
            curNode.next.prev = newNode;
          }
          curNode.next = newNode;
          newNode.prev = curNode;
          if (curNode == tail) {
            tail = newNode;
          }
        }
      }
    }

    public void dec(String key) {
      var freq = count.get(key);
      var curNode = freqMap.get(freq);
      var node = freqMap.get(freq - 1);
      if (freq == 1) {
        count.remove(key);
      } else {
        count.put(key, freq - 1);
      }
      // remove key from current node
      curNode.keys.remove(key);
      if (curNode.keys.isEmpty()) {
        freqMap.remove(freq);
        curNode.prev.next = curNode.next;
        if (curNode.next != null) {
          curNode.next.prev = curNode.prev;
        }
        if (curNode == tail) {
          tail = tail.prev;
        }
//        curNode.prev = null;
//        curNode.next = null;
      }

      if (freq == 1) {
        return;
      }

      // add key to new node
      if (node != null) {
        node.keys.add(key);
      } else {
        var newNode = new Node(freq - 1);
        newNode.keys.add(key);
        freqMap.put(newNode.count, newNode);
        var prevNode = curNode.prev;
        newNode.next = prevNode.next;
        if (prevNode.next != null) {
          prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (prevNode == tail) {
          tail = newNode;
        }
      }
    }

    public String getMaxKey() {
      return tail == head ? "" : tail.keys.get(0);
    }

    public String getMinKey() {
      return head.next == null ? "" : head.next.keys.get(0);
    }
  }

  static class Node {
    public List<String> keys;
    public int count;
    public Node prev;
    public Node next;

    public Node() {
      keys = new ArrayList<>();
    }
    public Node(int count) {
      this.count = count;
      this.keys = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
//    AllOne allOne = new AllOne();
//    allOne.inc("hello");
//    allOne.inc("hello");
//    System.out.println(allOne.getMaxKey()); // return "hello"
//    System.out.println(allOne.getMinKey()); // return "hello"
//    allOne.inc("leet");
//    System.out.println(allOne.getMaxKey()); // return "hello"
//    System.out.println(allOne.getMinKey()); // return "leet"
//    allOne.dec("hello");
//    System.out.println(allOne.getMaxKey()); // return "hello"
//    System.out.println(allOne.getMinKey()); // return "leet"

    AllOne allOne = new AllOne();
    allOne.inc("a");
    allOne.inc("b");
    allOne.inc("b");
    allOne.inc("b");
    allOne.inc("b");
    allOne.dec("b");
    allOne.dec("b");
    System.out.println(allOne.getMaxKey());
    System.out.println(allOne.getMinKey());

//    AllOne allOne = new AllOne();
//    allOne.inc("a");
//    allOne.inc("b");
//    allOne.inc("b");
//    allOne.inc("c");
//    allOne.inc("c");
//    allOne.inc("c");
//    allOne.dec("b");
//    allOne.dec("b");
//    System.out.println(allOne.getMinKey());
//    allOne.dec("a");
//    System.out.println(allOne.getMaxKey());
//    System.out.println(allOne.getMinKey());

//    AllOne allOne = new AllOne();
//    allOne.inc("a");
//    allOne.inc("a");
//    allOne.inc("a");
//    allOne.inc("b");
//    allOne.inc("b");
//    allOne.inc("c");
//    allOne.dec("c");
//    System.out.println(allOne.getMinKey());
//    allOne.dec("a");
//    System.out.println(allOne.getMaxKey());
//    System.out.println(allOne.getMinKey());
  }
}
