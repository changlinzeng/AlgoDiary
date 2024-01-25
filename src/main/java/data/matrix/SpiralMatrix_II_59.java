package data.matrix;

import java.util.Arrays;

public class SpiralMatrix_II_59 {
  public static int[][] generateMatrix(int n) {
    // clockwise direction
    var directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    var matrix = new int[n][n];
    int[] rowRange = new int[]{0, n - 1}, colRange = new int[]{0, n - 1};
    int row = 0, col = 0, num = 1, dir = 0;
    while (num <= n * n) {
      matrix[row][col] = num;
      num++;
      row += directions[dir][0];
      col += directions[dir][1];
      if (row < rowRange[0] || row > rowRange[1] || col < colRange[0] || col > colRange[1]) {
        row -= directions[dir][0];
        col -= directions[dir][1];
        // turn
        dir = (dir + 1) % 4;
        row += directions[dir][0];
        col += directions[dir][1];
        if (directions[dir][0] > 0) {
          rowRange[0] += directions[dir][0];
        } else if (directions[dir][0] < 0) {
          rowRange[1] += directions[dir][0];
        }
        if (directions[dir][1] > 0) {
          colRange[0] += directions[dir][1];
        } else if (directions[dir][1] < 0) {
          colRange[1] += directions[dir][1];
        }
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    Arrays.stream(generateMatrix(1)).forEach(a -> System.out.println(Arrays.deepToString(Arrays.stream(a).boxed().toArray())));
    Arrays.stream(generateMatrix(2)).forEach(a -> System.out.println(Arrays.deepToString(Arrays.stream(a).boxed().toArray())));
    Arrays.stream(generateMatrix(3)).forEach(a -> System.out.println(Arrays.deepToString(Arrays.stream(a).boxed().toArray())));
    Arrays.stream(generateMatrix(4)).forEach(a -> System.out.println(Arrays.deepToString(Arrays.stream(a).boxed().toArray())));
  }
}
