package algo.breadthFirstSearch;

import java.util.ArrayDeque;

public class CountServersThatCommunicate_1267 {
  public int countServers(int[][] grid) {
    var count = 0;
    for (var i = 0; i < grid.length; i++) {
      for (var j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          var num = bfs(grid, i, j);
          // make sure there are connected servers
          if (num > 1) {
            count += num;
          }
        }
      }
    }
    return count;
  }

  private int bfs(int[][] grid, int row, int col) {
    int rows = grid.length, cols = grid[0].length;
    var q = new ArrayDeque<int[]>();
    q.offer(new int[]{row, col});
    grid[row][col] = -1;

    var count = 0;
    while (!q.isEmpty()) {
      var cell = q.poll();
      int srow = cell[0], scol = cell[1];
      count++;
      // add servers on the same column to q
      for (var i = 0; i < rows; i++) {
        if (grid[i][scol] == 1) {
          q.offer(new int[]{i, scol});
          grid[i][scol] = -1;
        }
      }
      // add servers on the same row to q
      for (var i = 0; i < cols; i++) {
        if (grid[srow][i] == 1) {
          q.offer(new int[]{srow, i});
          grid[srow][i] = -1;
        }
      }
    }
    return count;
  }
}
