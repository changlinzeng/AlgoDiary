package algo.depthFirstSearch;

public class NumberOfEnclaves_1020 {
    public static int numEnclaves(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        var visited = new boolean[row][col];
        var num = 0;
        for (var i = 0; i < row; i++) {
            for (var j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    num += Math.max(0, dfs(grid, i, j, visited));
                }
            }
        }

        return num;
    }

    private static int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return 0;
        }
        if (grid[row][col] != 1) {
            return 0;
        }

        visited[row][col] = true;

        int num1 = 0, num2 = 0, num3 = 0, num4 = 0;
        if (row + 1 < grid.length) {
            num1 = dfs(grid, row + 1, col, visited);
        }
        if (row - 1 >= 0) {
            num2 = dfs(grid, row - 1, col, visited);
        }
        if (col + 1 < grid[0].length) {
            num3 = dfs(grid, row, col + 1, visited);
        }
        if (col - 1 >=0) {
            num4 = dfs(grid, row, col - 1, visited);
        }

        // we are at border
        var reachBorder = false;
        if (row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1) {
            reachBorder = true;
        }

        if (reachBorder || num1 == -1 || num2 == -1 || num3 == -1 || num4 == -1) {
            return -1;
        } else {
            return 1 + num1 + num2 + num3 + num4;
        }
    }

    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println(numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
    }
}
