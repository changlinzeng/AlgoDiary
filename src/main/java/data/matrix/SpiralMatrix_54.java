package data.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
  public static List<Integer> spiralOrder(int[][] matrix) {
    var directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int rows = matrix.length, cols = matrix[0].length;
    int row = 0, col = 0, idx = 0, total = rows * cols;
    var visited = new boolean[rows][cols];
    var result = new ArrayList<Integer>();
    visited[0][0] = true;
    result.add(matrix[0][0]);
    for (;;) {
      var d = directions[idx];
      row += d[0];
      col += d[1];
      while (row < rows && row >= 0 && col < cols && col >= 0 && !visited[row][col]) {
        visited[row][col] = true;
        result.add(matrix[row][col]);
        row += d[0];
        col += d[1];
      }
      row -= d[0];
      col -= d[1];
      if (result.size() == total) {
        break;
      }
      idx = (idx + 1) % 4;
    }

    return result;
  }

  public static void main(String[] args) {
    spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).forEach(System.out::println);
    spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}).forEach(System.out::println);
  }
}
