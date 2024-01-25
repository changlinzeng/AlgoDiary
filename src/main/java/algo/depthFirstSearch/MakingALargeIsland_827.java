package algo.depthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;

public class MakingALargeIsland_827 {
  public static int largestIsland(int[][] grid) {
    var areaMap = new HashMap<Integer, Integer>();
    var maxArea = 0;
    var color = 2;
    for (var i = 0; i < grid.length; i++) {
      for (var j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          var area = dfs(grid, i, j, color, 0);
          areaMap.put(color, area);
          maxArea = Math.max(maxArea, area);
          color++;
        } else if (grid[i][j] == 0) {
          // check if we can connect two islands with this cell
          var area = 0;
          var included = new HashSet<Integer>();
          if (i > 0 && grid[i - 1][j] != 0) {
            if (grid[i - 1][j] != 1) {
              area += areaMap.get(grid[i - 1][j]);
              included.add(grid[i - 1][j]);
            } else {
              var a = dfs(grid, i - 1, j, color, 0);
              area += a;
              areaMap.put(color, a);
              included.add(color);
              color++;
            }
          }
          if (i < grid.length - 1 && grid[i + 1][j] != 0) {
            if (grid[i + 1][j] != 1) {
              if (included.add(grid[i + 1][j])) {
                area += areaMap.get(grid[i + 1][j]);
              }
            } else {
              var a = dfs(grid, i + 1, j, color, 0);
              area += a;
              areaMap.put(color, a);
              included.add(color);
              color++;
            }
          }
          if (j > 0 && grid[i][j - 1] != 0) {
            if (grid[i][j - 1] != 1) {
              if (included.add(grid[i][j - 1])) {
                area += areaMap.get(grid[i][j - 1]);
              }
            } else {
              var a = dfs(grid, i, j - 1, color, 0);
              area += a;
              areaMap.put(color, a);
              included.add(color);
              color++;
            }
          }
          if (j < grid[0].length - 1 && grid[i][j + 1] != 0) {
            if (grid[i][j + 1] != 1) {
              if (included.add(grid[i][j + 1])) {
                area += areaMap.get(grid[i][j + 1]);
              }
            } else {
              var a = dfs(grid, i, j + 1, color, 0);
              area += a;
              areaMap.put(color, a);
              included.add(color);
              color++;
            }
          }
          if (area != 0) {
            area++;
            maxArea = Math.max(maxArea, area);
          }
        }
      }
    }

    return Math.max(maxArea, 1);
  }

  private static int dfs(int[][] grid, int row, int col, int color, int area) {
    if (grid[row][col] != 1) {
      return area;
    }
    grid[row][col] = color;
    area++;
    if (row + 1 < grid.length) {
      area = dfs(grid, row + 1, col, color, area);
    }
    if (row - 1 >= 0) {
      area = dfs(grid, row - 1, col, color, area);
    }
    if (col + 1 < grid[0].length) {
      area = dfs(grid, row, col + 1, color, area);
    }
    if (col - 1 >= 0) {
      area = dfs(grid, row, col - 1, color, area);
    }
    return area;
  }

  public static void main(String[] args) {
    System.out.println(largestIsland(new int[][]{
            {1,0},
            {1,1}}));
    System.out.println(largestIsland(new int[][]{
            {1,1},
            {1,1}}));
    System.out.println(largestIsland(new int[][]{
            {1,0,0,0,0},
            {0,1,1,0,0},
            {0,0,1,0,1}}));
  }
}
