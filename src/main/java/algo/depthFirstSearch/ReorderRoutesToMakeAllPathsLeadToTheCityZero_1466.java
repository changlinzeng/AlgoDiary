package algo.depthFirstSearch;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero_1466 {
  public static int minReorder(int n, int[][] connections) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    var routes = new HashSet<String>();  // route of [from, to]
    for (var conn : connections) {
      adjMap.putIfAbsent(conn[0], new ArrayList<>());
      adjMap.get(conn[0]).add(conn[1]);
      adjMap.putIfAbsent(conn[1], new ArrayList<>());
      adjMap.get(conn[1]).add(conn[0]);
      routes.add(conn[0] + "-" + conn[1]);
    }
    var visited = new boolean[n];
    visited[0] = true;
    return dfs(adjMap, routes, 0, visited);
  }

  private static int dfs(Map<Integer, List<Integer>> adjMap, Set<String> routes, int node, boolean[] visited) {
    if (!adjMap.containsKey(node)) {
      return 0;
    }
    var count = 0;
    for (var n : adjMap.get(node)) {
      if (visited[n]) {
        continue;
      }
      visited[n] = true;
      // this route is from 0 to outside, need to reverse
      if (routes.contains(node + "-" + n)) {
        count++;
      }
      count += dfs(adjMap, routes, n, visited);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    System.out.println(minReorder(5, new int[][]{{4,3},{2,3},{1,2},{1,0}}));
  }
}
