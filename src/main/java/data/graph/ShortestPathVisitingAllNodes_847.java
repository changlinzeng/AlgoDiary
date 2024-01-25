package data.graph;

import java.util.*;

public class ShortestPathVisitingAllNodes_847 {
  public static int shortestPathLength(int[][] graph) {
    var len = graph.length;
    var degree = new int[len];
    var adjMap = new HashMap<Integer, List<Integer>>();

    for (var i = 0; i < len; i++) {
      if (!adjMap.containsKey(i)) {
        adjMap.put(i, new ArrayList<>());
      }
      for (var n : graph[i]) {
        degree[i]++;
        degree[n]++;
        adjMap.get(i).add(n);
      }
    }

    adjMap.values().forEach(v -> v.sort(Comparator.comparingInt(a -> degree[a])));

    var minDegree = Integer.MAX_VALUE;
    for (var i = 0; i < len; i++) {
      degree[i] = degree[i] / 2;
      minDegree = Math.min(minDegree, degree[i]);
    }

    var minPath = Integer.MAX_VALUE;
    for (var i = 0; i < len; i++) {
      if (degree[i] == minDegree) {
        minPath = Math.min(minPath, dfs(adjMap, 0, i, new boolean[len]));
      }
    }

    return minPath;
  }

  private static int dfs(Map<Integer, List<Integer>> adjMap, int path, int node, boolean[] visited) {
    visited[node] = true;
    var children = adjMap.get(node);
    for (var child : children) {
      if (visited[child]) {
        continue;
      }
      path++;
      path += dfs(adjMap, 0, child, visited);
      for (var v : visited) {
        if (!v) {
          // if we have not completed, we need to return to parent node
          path++;
          break;
        }
      }
    }
    return path;
  }

  public static void main(String[] args) {
    System.out.println(shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}}));
    System.out.println(shortestPathLength(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}}));
    System.out.println(shortestPathLength(new int[][]{{1},{0,2,4},{1,3},{2},{1,5},{4}}));
    System.out.println(shortestPathLength(new int[][]{{1,4},{0,3,10},{3},{1,2,6,7},{0,5},{4},{3},{3},{10},{10},{1,9,8}}));
  }
}
