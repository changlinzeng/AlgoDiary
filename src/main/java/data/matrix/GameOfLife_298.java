package data.matrix;

import java.util.Arrays;

public class GameOfLife_298 {
  public void gameOfLife(int[][] board) {
    int rows = board.length, cols = board[0].length;
    var snapshot = new int[rows][];
    for (var i = 0; i < rows; i++) {
      snapshot[i] = Arrays.copyOf(board[i], cols);
    }

    int[][] neighbours = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        int countLive = 0;
        for (var n : neighbours) {
          int nrow = i + n[0], ncol = j + n[1];
          if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols) {
            if (snapshot[nrow][ncol] == 1) {
              countLive++;
            }
          }
        }
        // reproduce
        if (snapshot[i][j] == 0 && countLive == 3) {
          board[i][j] = 1;
        }
        // die
        if (snapshot[i][j] == 1 && (countLive < 2 || countLive > 3)) {
          board[i][j] = 0;
        }
      }
    }
  }
}
