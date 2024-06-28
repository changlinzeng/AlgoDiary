package data.matrix;

import java.util.ArrayList;

public class SetMatrixZeroes_73 {
  public void setZeroes(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    var zero = new ArrayList<int[]>();
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        if (matrix[i][j] == 0) {
          zero.add(new int[]{i, j});
        }
      }
    }

    zero.forEach(z -> {
      for (var i = 0; i < rows; i++) {
        matrix[i][z[1]] = 0;
      }
      for (var j = 0; j < cols; j++) {
        matrix[z[0]][j] = 0;
      }
    });
  }
}
