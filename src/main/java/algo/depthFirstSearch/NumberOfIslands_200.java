package algo.depthFirstSearch;

public class NumberOfIslands_200 {
    public static int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        var num = 0;
        for (var i = 0; i < row; i++) {
            for (var j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num += dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private static int dfs(char[][] grid, int row, int col) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (grid[row][col] == '0') {
            return 0;
        }
        grid[row][col] = '0';
        for (var direction : directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
                    && grid[nextRow][nextCol] == '1') {
                dfs(grid, nextRow, nextCol);
            }
        }
        return 1;
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
