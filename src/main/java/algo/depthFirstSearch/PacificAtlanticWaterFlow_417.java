package algo.depthFirstSearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow_417 {
  public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    var pacific = new HashSet<String>();
    var atlantic = new HashSet<String>();
    for (var i = 0; i < heights.length; i++) {
      for (var j = 0; j < heights[0].length; j++) {
        dfsPacific(heights, i, j, pacific, new boolean[heights.length][heights[0].length]);
      }
    }
    for (var i = heights.length - 1; i >= 0; i--) {
      for (var j = heights[0].length - 1; j >= 0; j--) {
        dfsAtlantic(heights, i, j, atlantic, new boolean[heights.length][heights[0].length]);
      }
    }
    pacific.retainAll(atlantic);
    return pacific.stream().map(e -> {
      var nums = e.split("-");
      return List.of(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]));
    }).toList();
  }

  private static boolean dfsPacific(int[][] heights, int row, int col, Set<String> pacific, boolean[][] visited) {
    int rows = heights.length, cols = heights[0].length;
    var cell = row + "-" + col;
    if (visited[row][col]) {
      return pacific.contains(cell);
    }
    visited[row][col] = true;
    if (row == 0 || col == 0) {
      pacific.add(cell);
      return true;
    }
    if (pacific.contains(cell)) {
      return true;
    }
    if (row > 0 && heights[row - 1][col] <= heights[row][col]) {
      if (dfsPacific(heights, row - 1, col, pacific, visited)) {
        pacific.add(cell);
        return true;
      }
    }
    if (col > 0 && heights[row][col - 1] <= heights[row][col]) {
      if (dfsPacific(heights, row, col - 1, pacific, visited)) {
        pacific.add(cell);
        return true;
      }
    }
    if (row < rows - 1 && heights[row + 1][col] <= heights[row][col]) {
      if (dfsPacific(heights, row + 1, col, pacific, visited)) {
        pacific.add(cell);
        return true;
      }
    }
    if (col < cols - 1 && heights[row][col + 1] <= heights[row][col]) {
      if (dfsPacific(heights, row, col + 1, pacific, visited)) {
        pacific.add(cell);
        return true;
      }
    }
    return false;
  }

  private static boolean dfsAtlantic(int[][] heights, int row, int col, Set<String> atlantic, boolean[][] visited) {
    int rows = heights.length, cols = heights[0].length;
    var cell = row + "-" + col;
    if (visited[row][col]) {
      return atlantic.contains(cell);
    }
    visited[row][col] = true;
    if (row == rows - 1 || col == cols - 1) {
      atlantic.add(cell);
      return true;
    }
    if (atlantic.contains(cell)) {
      return true;
    }
    if (row > 0 && heights[row - 1][col] <= heights[row][col]) {
      if (dfsAtlantic(heights, row - 1, col, atlantic, visited)) {
        atlantic.add(cell);
        return true;
      }
    }
    if (col > 0 && heights[row][col - 1] <= heights[row][col]) {
      if (dfsAtlantic(heights, row, col - 1, atlantic, visited)) {
        atlantic.add(cell);
        return true;
      }
    }
    if (row < rows - 1 && heights[row + 1][col] <= heights[row][col]) {
      if (dfsAtlantic(heights, row + 1, col, atlantic, visited)) {
        atlantic.add(cell);
        return true;
      }
    }
    if (col < cols - 1 && heights[row][col + 1] <= heights[row][col]) {
      if (dfsAtlantic(heights, row, col + 1, atlantic, visited)) {
        atlantic.add(cell);
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(pacificAtlantic(new int[][]{{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}}));
    System.out.println(pacificAtlantic(new int[][]{{1,2,3},{8,9,4},{7,6,5}}));
  }
}
