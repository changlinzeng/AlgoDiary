package design;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DinnerPlateStacks_1172 {
  static class DinnerPlates {

    private final int capacity;
    private final List<List<Integer>>data;
    private TreeSet<Integer> available;   // hold the index of available bucket

    public DinnerPlates(int capacity) {
      this.capacity = capacity;
      this.data = new ArrayList<>();
      this.available = new TreeSet<>();
    }

    public void push(int val) {
      List<Integer> bucket;
      if (available.isEmpty()) {
        bucket = new ArrayList<>();
        this.data.add(bucket);
        bucket.add(val);
        if (bucket.size() != this.capacity) {
          available.add(this.data.size() - 1);
        }
      } else {
        bucket = this.data.get(available.first());
        bucket.add(val);
        if (bucket.size() == this.capacity) {
          available.removeFirst();
        }
      }
    }

    public int pop() {
      if (data.isEmpty()) {
        return -1;
      }
      var last = data.getLast();
      while (!data.isEmpty() && last.isEmpty()) {
        available.remove(data.size() - 1);
        data.removeLast();
        last = data.getLast();
      }
      var e = last.removeLast();
      if (last.isEmpty()) {
        if (!data.isEmpty()) {
          available.remove(data.size() - 1);
        }
        data.removeLast();
      } else {
        available.add(this.data.size() - 1);
      }
      return e;
    }

    public int popAtStack(int index) {
      if (index >= data.size()) {
        return -1;
      }
      var bucket = data.get(index);
      if (bucket.isEmpty()) {
        return -1;
      }
      available.add(index);
      return bucket.removeLast();
    }
  }

  public static void main(String[] args) {
    var plates = new DinnerPlates(2);
    plates.push(1);
    plates.push(2);
    plates.push(3);
    plates.push(4);
    plates.push(5);
    plates.popAtStack(0);
    plates.push(20);
    plates.push(21);
    plates.popAtStack(0);
    plates.popAtStack(2);
    plates.pop();
    plates.pop();
    plates.pop();
    plates.pop();
    plates.pop();

//    var plates = new DinnerPlates(1);
//    plates.push(1);
//    plates.push(2);
//    plates.push(3);
//    plates.popAtStack(1);
//    plates.pop();
//    plates.pop();

//    var plates = new DinnerPlates(1);
//    plates.push(1);
//    plates.push(2);
//    plates.popAtStack(1);
//    plates.pop();
//    plates.push(1);
//    plates.push(2);
//    plates.pop();
//    plates.pop();
  }
}
