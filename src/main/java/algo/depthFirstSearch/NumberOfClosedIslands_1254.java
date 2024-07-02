package algo.depthFirstSearch;

public class NumberOfClosedIslands_1254 {
    public static int closedIsland(int[][] grid) {
        var num = 0;
        var visited = new boolean[grid.length][grid[0].length];
        for (var i = 1; i < grid.length; i++) {
            for (var j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && findIslands(grid, i, j, visited)) {
                    num++;
                }
            }
        }
        return num;
    }

    private static boolean findIslands(final int[][] grid, final int row, final int col, final boolean[][] visited) {
        int rows = grid.length, cols = grid[0].length;
        if (visited[row][col] || grid[row][col] == 1) {
            return true;
        }
        visited[row][col] = true;

        // we need to visit other cells even if we reach border so that we can mark all cells visited
        var reachBorder = row == 0 || row == rows - 1 || col == 0 || col == cols - 1;

        var directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        var result = true;
        for (var direction : directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                if (!findIslands(grid, nextRow, nextCol, visited)) {
                    // we can not return from here as we need to visit all cells
                    result = false;
                }
            }
        }
        return !reachBorder && result;
    }

    public static void main(String[] args) {
        System.out.println(closedIsland(new int[][]{{1,1,1,1,1,1,1,0},
                                                    {1,0,0,0,0,1,1,0},
                                                    {1,0,1,0,1,1,1,0},
                                                    {1,0,0,0,0,1,0,1},
                                                    {1,1,1,1,1,1,1,0}}));
    }
}
