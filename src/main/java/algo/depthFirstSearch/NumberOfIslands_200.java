package algo.depthFirstSearch;

public class NumberOfIslands_200 {
    public static int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        var visited = new boolean[row][col];
        var num = 0;
        for (var i = 0; i < row; i++) {
            for (var j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return num;
    }

    private static void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        if (row - 1 >= 0) {
            dfs(grid, row - 1, col, visited);
        }
        if (row + 1 < grid.length) {
            dfs(grid, row + 1, col, visited);
        }
        if (col - 1 >= 0) {
            dfs(grid, row, col - 1, visited);
        }
        if (col + 1 < grid[0].length) {
            dfs(grid, row, col + 1, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                                                   {'1', '1', '0', '1', '0'},
                                                   {'1', '1', '0', '0', '0'},
                                                   {'0', '0', '0', '0', '0'},
        }));
        System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '0'},
                                                   {'1', '1', '0', '0', '0'},
                                                   {'0', '0', '1', '0', '0'},
                                                   {'0', '0', '0', '1', '1'},
        }));
    }
}
