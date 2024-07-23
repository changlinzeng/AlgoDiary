package algo.depthFirstSearch;

public class WordSearch_79 {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        if (rows == 1 && cols == 1 && word.length() == 1) {
            return board[0][0] == word.charAt(0);
        }
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j, new boolean[rows][cols])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[row][col] = true;
        for (var direction : directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
                if (dfs(board, word, index + 1, nextRow, nextCol, visited)) {
                    return true;
                }
            }
        }
        // revert if we could not find word from current cell so current cell can be used in other search paths
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},
                                              {'S','F','C','S'},
                                              {'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},
                                              {'S','F','C','S'},
                                              {'A','D','E','E'}}, "ABCB"));
        System.out.println(exist(new char[][]{{'E'}}, "E"));
        System.out.println(exist(new char[][]{{'E', 'E'}}, "EE"));
        System.out.println(exist(new char[][]{{'a','a','b','a','a','b'},
                                              {'a','a','b','b','b','a'},
                                              {'a','a','a','a','b','a'},
                                              {'b','a','b','b','a','b'},
                                              {'a','b','b','a','b','a'},
                                              {'b','a','a','a','a','b'}}, "bbbaabbbbbab"));
    }
}
