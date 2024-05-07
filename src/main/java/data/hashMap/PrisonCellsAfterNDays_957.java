package data.hashMap;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonCellsAfterNDays_957 {
  public static int[] prisonAfterNDays(int[] cells, int n) {
    var cycle = new HashMap<String, Integer>();
    var k = n;
    while (k > 0) {
      cycle.put(Arrays.toString(cells), k);
      var flip = new int[8];
      for (var i = 1; i < cells.length - 1; i++) {
        if (cells[i - 1] == cells[i + 1]) {
          flip[i] = 1;
        }
      }
      k--;
      System.arraycopy(flip, 0, cells, 0, 8);
      // find a cycle from n to current
      if (cycle.containsKey(Arrays.toString(cells))) {
        k = k % (cycle.get(Arrays.toString(cells)) - k);
      }
    }
    return cells;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7)));
  }
}
