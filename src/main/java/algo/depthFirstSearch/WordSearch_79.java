package algo.depthFirstSearch;

public class WordSearch_79 {
    public static boolean exist(char[][] board, String word) {
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (search(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        int rows = board.length, cols = board[0].length;
        // reach the end
        if (index == word.length()) {
            return true;
        }
        if (visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        if (index == word.length() - 1) {
            return true;
        }

        var found = false;
        if (row > 0) {
            if (search(board, row - 1, col, word, index + 1, visited)) {
                found = true;
            }
        }
        if (!found && row < board.length - 1) {
            if (search(board, row + 1, col, word, index + 1, visited)) {
                found = true;
            }
        }
        if (!found && col > 0) {
            if (search(board, row, col - 1, word, index + 1, visited)) {
                found = true;
            }
        }
        if (!found && col < board[0].length - 1) {
            if (search(board, row, col + 1, word, index + 1, visited)) {
                found = true;
            }
        }

        // revert visited as one cell may be used more than once for different words
        if (!found) {
            visited[row][col] = false;
        }

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
