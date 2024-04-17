package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray_1146 {
  static class SnapshotArray {

    private int[] data;
    private List<Map<Integer, Integer>> snapshot;

    public SnapshotArray(int length) {
      data = new int[length];
      snapshot = new ArrayList<>();
      snapshot.add(new HashMap<>());
    }

    public void set(int index, int val) {
      // modify the latest snapshot
      var latest = snapshot.getLast();
      latest.put(index, val);
    }

    public int snap() {
      // create a new snapshot and return the prev snapshot id
      snapshot.add(new HashMap<>());
      return snapshot.size() - 2;
    }

    public int get(int index, int snap_id) {
      // search snapshot top down
      for (var i = snap_id; i >= 0; i--) {
        // search the value
        var level = snapshot.get(i);
        if (!level.containsKey(index)) {
          continue;
        }
        return level.get(index);
      }

      // if not found in snapshot, return the value in original data
      return data[index];
    }
  }

  public static void main(String[] args) {
    var snapshotArray = new SnapshotArray(4);
    snapshotArray.set(0, 0);
    snapshotArray.set(2, 2);
    snapshotArray.set(4, 4);
    snapshotArray.set(1, 1);
    System.out.println(snapshotArray.snap());
    snapshotArray.set(0, 6);
    System.out.println(snapshotArray.get(0, 0));
  }
}
