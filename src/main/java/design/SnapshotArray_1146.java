package design;

import java.util.ArrayList;
import java.util.List;

public class SnapshotArray_1146 {
  static class SnapshotArray {

    private int[] data;
    private List<List<int[]>> snapshot;  // changes to index value for each snapshot

    public SnapshotArray(int length) {
      data = new int[length];
      snapshot = new ArrayList<>();
      snapshot.add(new ArrayList<>());
    }

    public void set(int index, int val) {
      // modify the latest snapshot
      var latest = snapshot.getLast();
      if (latest.isEmpty() || index < latest.getFirst()[0]) {
        latest.addFirst(new int[]{index, val});
        return;
      }
      if (index > latest.getLast()[0]) {
        latest.add(new int[]{index, val});
        return;
      }
      // binary search the position to add
      int start = 0, end = latest.size() - 1;
      var pos = -1;
      while (start <= end) {
        var mid = start + (end - start) / 2;
        if (latest.get(mid)[0] == index) {
          latest.get(mid)[1] = val;
          return;
        } else if (latest.get(mid)[0] > index) {
          if (latest.get(mid - 1)[0] < index) {
            pos = mid;
            break;
          } else {
            end = mid - 1;
          }
        } else {
          if (mid < latest.size() - 1 && latest.get(mid + 1)[0] > index) {
            pos = mid + 1;
            break;
          } else {
            start = mid + 1;
          }
        }
      }
      latest.add(pos, new int[]{index, val});
    }

    public int snap() {
      // create a new snapshot and return the prev snapshot id
      snapshot.add(new ArrayList<>());
      return snapshot.size() - 2;
    }

    public int get(int index, int snap_id) {
      // search snapshot top down
      for (var i = snap_id; i >= 0; i--) {
        // binary search the value
        var level = snapshot.get(i);
        if (level.isEmpty() || index < level.getFirst()[0] || index > level.getLast()[0]) {
          continue;
        }

        int start = 0, end = level.size() - 1;
        while (start <= end) {
          var mid = start + (end - start) / 2;
          if (level.get(mid)[0] == index) {
            return level.get(mid)[1];
          } else if (level.get(mid)[0] < index) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
        }
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
