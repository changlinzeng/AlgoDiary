package algo.breadthFirstSearch;

import java.util.ArrayDeque;

public class AsFarFromLandAsPossible_1162 {
  public int maxDistance(int[][] grid) {
    var directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows = grid.length, cols = grid[0].length;
    var q = new ArrayDeque<int[]>();  // {row, col, dist}
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          q.offer(new int[]{i, j, 0});
        }
      }
    }

    var visited = new boolean[rows][cols];
    var maxDist = -1;
    while (!q.isEmpty()) {
      var cell = q.poll();
      int r = cell[0], c = cell[1], dist = cell[2];
      if (visited[r][c]) {
        continue;
      }
      visited[r][c] = true;
      if (grid[r][c] == 0) {
        maxDist = Math.max(maxDist, dist);
      }
      for (var direction : directions) {
        int nextRow = r + direction[0], nextCol = c + direction[1];
        if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 0) {
          q.offer(new int[]{nextRow, nextCol, dist + 1});
        }
      }
    }
    return maxDist;
  }
}
