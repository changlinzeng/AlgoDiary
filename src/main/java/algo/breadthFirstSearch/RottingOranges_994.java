package algo.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class RottingOranges_994 {
  public static int orangesRotting(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    var q = new ArrayDeque<int[]>();
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (grid[i][j] == 2) {
          q.offer(new int[]{i, j});
        }
      }
    }

    var minutes = 0;
    while (!q.isEmpty()) {
      var size = q.size();
      var rottings = new ArrayList<int[]>();
      for (var i = 0; i < size; i++) {
        var rotting = q.poll();
        int row = rotting[0], col = rotting[1];
        if (row + 1 < rows && grid[row + 1][col] == 1) {
          grid[row + 1][col] = 2;
          rottings.add(new int[]{row + 1, col});
        }
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
          grid[row - 1][col] = 2;
          rottings.add(new int[]{row - 1, col});
        }
        if (col + 1 < cols && grid[row][col + 1] == 1) {
          grid[row][col + 1] = 2;
          rottings.add(new int[]{row, col + 1});
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
          grid[row][col - 1] = 2;
          rottings.add(new int[]{row, col - 1});
        }
      }
      rottings.forEach(q::offer);
      minutes++;
    }

    for (var r : grid) {
      for (var c : r) {
        if (c == 1) {
          return -1;
        }
      }
    }
    return Math.max(minutes - 1, 0);
  }

  public static void main(String[] args) {
    System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    System.out.println(orangesRotting(new int[][]{{2,2},{1,1},{0,0},{2,0}}));
  }
}
