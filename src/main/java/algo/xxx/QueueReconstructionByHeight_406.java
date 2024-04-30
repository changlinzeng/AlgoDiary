package algo.xxx;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstructionByHeight_406 {
  public int[][] reconstructQueue(int[][] people) {
    var len = people.length;
    var result = new int[len][2];
    var cells = new ArrayList<Integer>();
    for (var i = 0; i < len; i++) {
      cells.add(i);
    }

    Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    for (var p : people) {
      var pos = cells.remove(p[1]);
      result[pos] = p;
    }
    return result;
  }
}
