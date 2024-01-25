package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class ShortestBridge_934 {
  public static int shortestBridge(int[][] grid) {
    var len = grid.length;
    var island1 = new ArrayList<int[]>();
    var island2 = new ArrayList<int[]>();

    var done = false;
    for (var i = 0; i < len && !done; i++) {
      for (var j = 0; j < len && !done; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, i, j, island1, new boolean[len][len]);
          done = true;
        }
      }
    }

    done = false;
    for (var i = 0; i < len && !done; i++) {
      for (var j = 0; j < len && !done; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, i, j, island2, new boolean[len][len]);
          done = true;
        }
      }
    }

    var min = Integer.MAX_VALUE;
    for (var m : island1) {
      for (var n : island2) {
        min = Math.min(min, Math.abs(m[0] - n[0]) + Math.abs(m[1] - n[1]) - 1);
      }
    }
    return min;
  }

  private static void dfs(int[][] grid, int row, int col, List<int[]> cells, boolean[][] visited) {
    if (visited[row][col]) {
      return;
    }
    if (grid[row][col] != 1) {
      return;
    }
    var len = grid.length;
    var added = false;
    visited[row][col] = true;
    grid[row][col] = 2;
    if (row + 1 < len) {
      if (grid[row + 1][col] == 0) {
        added = true;
        cells.add(new int[]{row, col});
      }
      dfs(grid, row + 1, col, cells, visited);
    }
    if (row - 1 >= 0) {
      if (grid[row - 1][col] == 0 && !added) {
        added = true;
        cells.add(new int[]{row, col});
      }
      dfs(grid, row - 1, col, cells, visited);
    }
    if (col + 1 < len) {
      if (grid[row][col + 1] == 0 && !added) {
        added = true;
        cells.add(new int[]{row, col});
      }
      dfs(grid, row, col + 1, cells, visited);
    }
    if (col - 1 >= 0) {
      if (grid[row][col - 1] == 0 && !added) {
        cells.add(new int[]{row, col});
      }
      dfs(grid, row, col - 1, cells, visited);
    }
  }

  public static void main(String[] args) {
    System.out.println(shortestBridge(new int[][]
            {{0, 1, 0, 0, 0},
             {1, 1, 0, 0, 0},
             {0, 0, 0, 0, 1},
             {0, 0, 0, 1, 1},
             {0, 0, 0, 0, 1}}));
  }
}
