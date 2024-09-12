package algo.depthFirstSearch;

public class MaxAreaOfIsland_695 {
  public int maxAreaOfIsland(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    var visited = new boolean[rows][cols];
    var maxArea = 0;
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
        }
      }
    }
    return maxArea;
  }

  private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
    if (visited[row][col]) {
      return 0;
    }
    var area = 1;
    var directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    visited[row][col] = true;
    for (var direction : directions) {
      int nextRow = row + direction[0], nextCol = col + direction[1];
      if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
              && grid[nextRow][nextCol] == 1) {
        area += dfs(grid, nextRow, nextCol, visited);
      }
    }
    return area;
  }
}
