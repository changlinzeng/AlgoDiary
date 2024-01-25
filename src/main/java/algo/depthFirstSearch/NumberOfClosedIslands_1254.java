package algo.depthFirstSearch;

public class NumberOfClosedIslands_1254 {
    public static int closedIsland(int[][] grid) {
        var num = 0;
        var visited = new boolean[grid.length][grid[0].length];
        for (var i = 1; i < grid.length; i++) {
            for (var j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    num += findIslands(grid, i, j, visited);
                }
            }
        }
        return num;
    }

    private static int findIslands(int[][] grid, int row, int col, boolean[][] visited) {
        if (visited[row][col] || grid[row][col] == 1) {
            return 1;
        }

        visited[row][col] = true;

        var reachBorder = false;
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
            reachBorder = true;
        }

        int num1 = 0, num2 = 0, num3 = 0, num4 = 0;
        if (row > 0) {
            num1 = findIslands(grid, row - 1, col, visited);
        }
        if (row < grid.length - 1) {
            num2 = findIslands(grid, row + 1, col, visited);
        }
        if (col > 0) {
            num3 = findIslands(grid, row, col - 1, visited);
        }
        if (col < grid[0].length - 1) {
            num4 = findIslands(grid, row, col + 1, visited);
        }

        if (reachBorder || num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(closedIsland(new int[][]{{1,1,1,1,1,1,1,0},
                                                    {1,0,0,0,0,1,1,0},
                                                    {1,0,1,0,1,1,1,0},
                                                    {1,0,0,0,0,1,0,1},
                                                    {1,1,1,1,1,1,1,0}}));
    }
}
