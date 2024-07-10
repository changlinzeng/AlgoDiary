package data.matrix;

public class ValidTicTacToeState_794 {
  public boolean validTicTacToe(String[] board) {
    int countX = 0, countO = 0;
    for (var row : board) {
      for (var i = 0; i < row.length(); i++) {
        if (row.charAt(i) == 'X') {
          countX++;
        }
        if (row.charAt(i) == 'O') {
          countO++;
        }
      }
    }
    if (countX - countO > 1 || countX < countO) {
      return false;
    }

    if (win(board, 'X') && win(board, 'O')) {
      return false;
    }

    if (win(board, 'X') && countX - countO != 1) {
      return false;
    }

    if (win(board, 'O') && countX != countO) {
      return false;
    }

    return true;
  }

  private boolean win(String[] board, char player) {
    var len = board.length;
    var winStr = (player + "").repeat(3);
    for (var row : board) {
      if (row.equals(winStr)) {
        return true;
      }
    }

    var col = "";
    for (var i = 0; i < len; i++) {
      for (var j = 0; j < len; j++) {
        col += board[j].charAt(i);
      }
      if (col.equals(winStr)) {
        return true;
      }
    }

    var cross = "";
    for (var i = 0; i < len; i++) {
      cross += board[i].charAt(i);
    }
    if (cross.equals(winStr)) {
      return true;
    }

    cross = "";
    for (var i = 0; i < len; i++) {
      cross += board[i].charAt(len - i - 1);
    }
    if (cross.equals(winStr)) {
      return true;
    }

    return false;
  }
}
