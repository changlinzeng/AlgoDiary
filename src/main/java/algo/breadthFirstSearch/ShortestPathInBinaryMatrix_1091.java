package algo.breadthFirstSearch;

import java.util.*;

public class ShortestPathInBinaryMatrix_1091 {
  public static int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] != 0) {
      return -1;
    }
    int rows = grid.length, cols = grid[0].length;
    var directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    var distance = new HashMap<String, Integer>();  // shortest distance from [0, 0] to cell [i, j]
    var pq = new PriorityQueue<String>(Comparator.comparingInt(distance::get));
    var visited = new HashSet<String>();
    distance.put("0_0", 0);
    pq.offer("0_0");
    while (!pq.isEmpty()) {
      var cell = pq.poll();
      if (!visited.add(cell)) {
        continue;
      }
      var row = Integer.parseInt(cell.split("_")[0]);
      var col = Integer.parseInt(cell.split("_")[1]);
      for (var dir : directions) {
        int nextRow = row + dir[0], nextCol = col + dir[1];
        if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 0) {
          var key = nextRow + "_" + nextCol;
          if (!distance.containsKey(key)) {
            distance.put(key, distance.get(row + "_" + col) + 1);
          } else {
            var minDist = Math.min(distance.get(key), distance.get(row + "_" + col) + 1);
            distance.put(key, minDist);
          }
          pq.offer(key);
        }
      }
    }
    return distance.getOrDefault((rows - 1) + "_" + (cols - 1), -2) + 1;
  }

  public static void main(String[] args) {
    System.out.println(shortestPathBinaryMatrix(new int[][]{{0,1}, {1,0}}));
    System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,1,0}, {1,1,0}}));
  }
}
