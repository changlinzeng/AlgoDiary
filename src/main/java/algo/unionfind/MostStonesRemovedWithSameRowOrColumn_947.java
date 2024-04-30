package algo.unionfind;

import java.util.*;
import java.util.stream.Collectors;

public class MostStonesRemovedWithSameRowOrColumn_947 {
  public static int removeStones(int[][] stones) {
    var len = stones.length;
    var stonesInRow = new HashMap<Integer, List<Integer>>();  // row number -> stone index
    var stonesInColumn = new HashMap<Integer, List<Integer>>();  // column number -> stone index
    var union = new int[len];
    for (var i = 0; i < len; i++) {
      union[i] = i;
    }

    for (var i = 0; i < len; i++) {
      int row = stones[i][0], col = stones[i][1];
      stonesInRow.putIfAbsent(row, new ArrayList<>());
      stonesInColumn.putIfAbsent(col, new ArrayList<>());
      var rowStones = stonesInRow.get(row);
      var colStones = stonesInColumn.get(col);
      if (!rowStones.isEmpty() && !colStones.isEmpty()) {
        var rowParent = union[stonesInRow.get(row).getFirst()];
        var colParent = union[stonesInColumn.get(col).getFirst()];
        // merge two sets
        if (rowParent != colParent) {
          for (var j = 0; j < union.length; j++) {
            if (union[j] == colParent) {
              union[j] = rowParent;
            }
          }
        }
        union[i] = rowParent;
      } else if (!rowStones.isEmpty()) {
        // there is stone in the same row, add current stone to set
        union[i] = union[stonesInRow.get(row).getFirst()];
      } else if (!colStones.isEmpty()) {
        union[i] = union[stonesInColumn.get(col).getFirst()];
      }
      rowStones.add(i);
      colStones.add(i);
    }

    // only retain one stone in each set
    return len - Arrays.stream(union).boxed().collect(Collectors.toSet()).size();
  }

  public static void main(String[] args) {
    System.out.println(removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
    System.out.println(removeStones(new int[][]{{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}}));
  }
}
