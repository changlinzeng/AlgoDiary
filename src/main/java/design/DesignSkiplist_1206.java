package design;

import java.util.ArrayList;
import java.util.List;

public class DesignSkiplist_1206 {
  static class Skiplist {
    private final List<Level> levels;

    public Skiplist() {
      levels = new ArrayList<>();
    }

    public boolean search(int target) {
      return find(target) != null;
    }

    public void add(int num) {
      if (levels.isEmpty()) {
        var level = new Level();
        level.head.next = new Node(num, level);
        level.tail = level.tail.next;
        levels.add(level);
        return;
      }
      var levelNum = getIndexLevel();
      if (levelNum >= levels.size()) {
        // add new index level
        for (var i = levels.size(); i <= levelNum; i++) {
          var level = new Level();
          level.head.nextLevel = levels.get(i - 1).head;
          levels.add(level);
        }
      }
      Node prevLevel = null;
      while (levelNum >= 0) {
        var currentLevel = levels.get(levelNum);
        currentLevel.size++;
        Node cur = currentLevel.head;
        while (cur.next != null && cur.next.val < num) {
          cur = cur.next;
        }
        // add index after cur
        var node = new Node(num, currentLevel);
        node.next = cur.next;
        cur.next = node;
        if (cur == currentLevel.tail) {
          currentLevel.tail = node;
        }
        if (prevLevel != null) {
          prevLevel.nextLevel = node;
        }
        prevLevel = node;
        levelNum--;
      }
    }

    public boolean erase(int num) {
      var levelNum = levels.size() - 1;
      while (levelNum >= 0) {
        var currentLevel = levels.get(levelNum);
        Node cur = currentLevel.head;
        while (cur.next != null) {
          if (cur.next.val < num) {
            cur = cur.next;
          } else if (cur.next.val == num) {
            // remove node top down
//            currentLevel.size--;
            while (cur != null) {
              var thisLevel = cur.level;
              if (cur.next == thisLevel.tail) {
                currentLevel.tail = cur;
              }
              thisLevel.size--;
              cur.next = cur.next.next;
              cur = cur.nextLevel;
            }
            return true;
          } else {
            break;
          }
        }
        levelNum--;
      }
      return false;
    }

    private int getIndexLevel() {
      var level = 1;
      double maxLevel = Math.log(levels.get(0).size);
      float threshold = 0.5f;
      while (Math.random() < threshold && level < maxLevel) {
        level++;
      }
      return level;
    }

    /**
     * Return the prev node of target node on the highest level
     */
    private Node find(int num) {
      var levelNum = levels.size() - 1;
      while (levelNum >= 0) {
        var currentLevel = levels.get(levelNum);
        Node cur = currentLevel.head;
        while (cur.next != null) {
          if (cur.next.val < num) {
            cur = cur.next;
          } else if (cur.next.val == num) {
            return cur;
          } else {
            break;
          }
        }
        levelNum--;
      }
      return null;
    }
  }

  static class Level {
    public Node head;
    public Node tail;
    public int size;
    public Level() {
      this.head = new Node(Integer.MAX_VALUE, this);
      this.tail = head;
    }
  }

  static class Node {
    public int val;
    public Node next;
    public Node nextLevel;
    public Level level;
    public Node() {}
    public Node(int val, Level level) {
      this.val = val;
      this.level = level;
    }
  }

  public static void main(String[] args) {
    var sl = new Skiplist();
    sl.add(16);
    sl.add(5);
    sl.add(14);
    sl.add(13);
    sl.add(0);
    sl.add(3);
    sl.add(12);
    sl.add(9);
    sl.add(12);
    System.out.println(sl.erase(3));
    System.out.println(sl.search(6));
    sl.add(7);
    System.out.println(sl.erase(0));
    System.out.println(sl.erase(1));
    System.out.println(sl.erase(10));
    sl.add(5);
    System.out.println(sl.search(12));
    System.out.println(sl.search(7));
    System.out.println(sl.search(16));
    System.out.println(sl.erase(7));
    System.out.println(sl.search(0));
  }
}
