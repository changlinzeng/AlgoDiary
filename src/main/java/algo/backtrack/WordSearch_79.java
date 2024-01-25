package algo.backtrack;

public class WordSearch_79 {
    public static boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        var visited = new boolean[board.length][board[0].length];
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (search(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, int row, int col, String word, int direction, boolean[][] visited) {
        if (visited[row][col] || board[row][col] != word.charAt(0)) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }

        visited[row][col] = true;
        var found = false;
        // up
        if (row > 0 && direction != 2) {
            if (search(board, row - 1, col, word.substring(1), 4, visited)) {
                found = true;
            }
        }
        // down
        if (row < board.length - 1 && direction != 4) {
            if (search(board, row + 1, col, word.substring(1), 2, visited)) {
                found = true;
            }
        }
        // left
        if (col > 0 && direction != 1) {
            if (search(board, row, col - 1, word.substring(1), 3, visited)) {
                found = true;
            }
        }
        // right
        if (col < board[0].length - 1 && direction != 3) {
            if (search(board, row, col + 1, word.substring(1), 1, visited)) {
                found = true;
            }
        }

        visited[row][col] = false;

        return found;
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
