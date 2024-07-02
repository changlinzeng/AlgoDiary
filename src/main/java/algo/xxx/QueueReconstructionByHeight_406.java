package algo.xxx;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstructionByHeight_406 {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> {
      // sort by height descending and then by the number of higher people in front
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return b[0] - a[0];
    });

    var result = new ArrayList<int[]>();
    for (var p : people) {
      // insert into position p[1] so that there are p[1] people before that are not less than p[0]
      result.add(p[1], p);
    }
    var queue = new int[people.length][];
    return result.toArray(queue);
  }
}
