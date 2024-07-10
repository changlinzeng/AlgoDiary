package algo.depthFirstSearch;

public class SurroundedRegions_130 {
    public static void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        var visited = new boolean[rows][cols];
        for (var r : new int[]{0, rows - 1}) {
            for (var j = 0; j < cols; j++) {
                edgeDfs(board, r, j, visited);
            }
        }
        for (var c : new int[]{0, cols - 1}) {
            for (var i = 0; i < rows; i++) {
                edgeDfs(board, i, c, visited);
            }
        }

        // count the cells whose value is 'O' and not visited
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * Start dfs from edges and find the cells that can be reached from edge.
     * The rest cells are the ones that isolated from edges
     */
    private static void edgeDfs(final char[][] board, final int row, final int col, boolean[][] visited) {
        int rows = board.length, cols = board[0].length;
        if (visited[row][col]) {
            return;
        }
        if (board[row][col] == 'X') {
            return;
        }
        visited[row][col] = true;
        var directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (var direction : directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                edgeDfs(board, nextRow, nextCol, visited);
            }
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
