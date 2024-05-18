package algo.depthFirstSearch;

public class PathWithMaximumGold_1219 {
  public static int getMaximumGold(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    var maxGold = 0;
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (grid[i][j] != 0) {
          maxGold = Math.max(maxGold, dfs(grid, i, j, new boolean[rows][cols]));
        }
      }
    }
    return maxGold;
  }

  private static int dfs(int[][] grid, int row, int col, boolean[][] visited) {
    int rows = grid.length, cols = grid[0].length;
    if (grid[row][col] == 0 || visited[row][col]) {
      return 0;
    }
    visited[row][col] = true;
    var directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    var gold = grid[row][col];
    var maxGold = 0;

    for (var dir : directions) {
      int i = row + dir[0], j = col + dir[1];
      if (i >= 0 && i < rows && j >= 0 && j < cols) {
        maxGold = Math.max(maxGold, dfs(grid, i, j, visited));
      }
    }
    visited[row][col] = false;

    return gold + maxGold;
  }

  public static void main(String[] args) {
    System.out.println(getMaximumGold(new int[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}}));
  }
}
