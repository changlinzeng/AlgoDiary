package design;

import java.util.*;

public class InsertDeleteGetRandomO1_380 {
  static class RandomizedSet {
    private final Map<Integer, Integer> position; // map of {val: position}
    private final List<Integer> data;
    private final Random rand;

    public RandomizedSet() {
      data = new ArrayList<>();
      position = new HashMap<>();
      rand = new Random();
    }

    public boolean insert(int val) {
      if (position.containsKey(val)) {
        return false;
      }
      data.add(val);
      position.put(val, data.size() - 1);
      return true;
    }

    public boolean remove(int val) {
      if (!position.containsKey(val)) {
        return false;
      }
      int pos = position.get(val);
      position.remove(val);
      if (pos == data.size() - 1) {
        data.removeLast();
      } else {
        // move the last element to pos and remove the last element
        var last = data.getLast();
        data.set(pos, last);
        data.removeLast();
        position.put(last, pos);
      }
      return true;
    }

    public int getRandom() {
      return data.get(rand.nextInt(data.size()));
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
