package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions_130 {
    public static void solve(char[][] board) {
        var row = board.length;
        var column = board[0].length;
        var visited = new boolean[row][column];
        for (var i = 0; i < row; i++) {
            for (var j = 0; j < column; j++) {
                var region = new ArrayList<int[]>();
                if (!visited[i][j]) {
                    captureRegion(board, i, j, visited, region);
                    for (var cell : region) {
                        if (cell[0] == 0 || cell[0] == row - 1 || cell[1] == 0 || cell[1] == column - 1) {
                            // revert consumed cells if we consumed cells on border
                            for (var r : region) {
                                board[r[0]][r[1]] = 'O';
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void captureRegion(char[][] board, int row, int column, boolean[][] visited, List<int[]> region) {
        if (board[row][column] == 'X' || visited[row][column]) {
            return;
        }
        visited[row][column] = true;
        board[row][column] = 'X';
        region.add(new int[]{row, column});
        if (column + 1 < board[0].length) {
            captureRegion(board, row, column + 1, visited, region);
        }
        if (column > 0) {
            captureRegion(board, row, column - 1, visited, region);
        }
        if (row + 1 < board.length) {
            captureRegion(board, row + 1, column, visited, region);
        }
        if (row > 0) {
            captureRegion(board, row - 1, column, visited, region);
        }
    }

    public static void main(String[] args) {
//        var board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        var board = new char[][]{{'X','O','O','X','X','X','O','X','O','O'},
//                                 {'X','O','X','X','X','X','X','X','X','X'},
//                                 {'X','X','X','X','O','X','X','X','X','X'},
//                                 {'X','O','X','X','X','O','X','X','X','O'},
//                                 {'O','X','X','X','O','X','O','X','O','X'},
//                                 {'X','X','O','X','X','O','O','X','X','X'},
//                                 {'O','X','X','O','O','X','O','X','X','O'},
//                                 {'O','X','X','X','X','X','O','X','X','X'},
//                                 {'X','O','O','X','X','O','X','X','O','O'},
//                                 {'X','X','X','O','O','X','O','X','X','O'}};
        var board = new char[][]{{'O','X','O','O','X','X'},
                                 {'O','X','X','X','O','X'},
                                 {'X','O','O','X','O','O'},
                                 {'X','O','X','X','X','X'},
                                 {'O','O','X','O','X','X'},
                                 {'X','X','O','O','O','O'}};
        solve(board);
        for (var row : board) {
            System.out.println(row);
        }
    }
}
