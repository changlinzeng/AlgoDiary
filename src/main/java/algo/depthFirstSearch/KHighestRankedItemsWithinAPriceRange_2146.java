package algo.depthFirstSearch;

import java.util.*;

public class KHighestRankedItemsWithinAPriceRange_2146 {
    public static List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[2]));
        dfs(grid, pricing, start, 0, new boolean[grid.length][grid[0].length], pq);

        var result = new ArrayList<List<Integer>>();
        var i = 0;
        while (i++ < k && !pq.isEmpty()) {
            var e = pq.poll();
            result.add(List.of(e[0], e[1]));
        }

        return result;
    }

    private static void dfs(int[][] grid, int[] pricing, int[] pos, int dist, boolean[][] visited, Queue<int[]> pq) {
        int row = pos[0], col = pos[1];
        if (visited[row][col] || grid[row][col] == 0) {
            return;
        }
        dist++;
        visited[row][col] = true;
        if (grid[row][col] >= pricing[0] && grid[row][col] <= pricing[1]) {
            pq.offer(new int[]{row, col, dist});
        }
        if (row > 0) {
            dfs(grid, pricing, new int[]{row - 1, col}, dist, visited, pq);
        }
        if (row + 1 < grid.length) {
            dfs(grid, pricing, new int[]{row + 1, col}, dist, visited, pq);
        }
        if (col > 0) {
            dfs(grid, pricing, new int[]{row, col - 1}, dist, visited, pq);
        }
        if (col + 1 < grid[0].length) {
            dfs(grid, pricing, new int[]{row, col + 1}, dist, visited, pq);
        }
    }

    public static void main(String[] args) {
        highestRankedKItems(new int[][]{{1,2,0,1},{1,3,0,1},{0,2,5,1}}, new int[]{2,5}, new int[]{0,0}, 3).forEach(System.out::println);
    }
}
