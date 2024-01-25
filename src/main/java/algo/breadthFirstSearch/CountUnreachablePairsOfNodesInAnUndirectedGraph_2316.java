package algo.breadthFirstSearch;

import java.util.*;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph_2316 {
  public static long countPairs(int n, int[][] edges) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    var visited = new boolean[n];

    for (var i = 0; i < n; i++) {
      adjMap.put(i, new ArrayList<>());
    }

    for (var edge : edges) {
      adjMap.get(edge[0]).add(edge[1]);
      adjMap.get(edge[1]).add(edge[0]);
    }

    /**
     * a1
     * a1 * a2
     * a1 * a2 + (a1 + a2) * a3
     * a1 * a2 + (a1 + a2) * a3 + (a1 + a2 + a3) * a4
     */
    long sum = 0; // num numbers
    long pairs = 0;
    for (var i = 0; i < n; i++) {
      if (!visited[i]) {
        var num = bfs(adjMap, i, visited);
        pairs = pairs + sum * num;
        sum += num;
      }
    }

    return pairs;
  }

  private static int bfs(Map<Integer, List<Integer>> adjMap, int node, boolean[] visited) {
    if (visited[node]) {
      return 0;
    }
    var num = 1;
    var q = new LinkedList<Integer>();
    q.offer(node);
    visited[node] = true;
    while (!q.isEmpty()) {
      var n = q.poll();
      for (var child : adjMap.get(n)) {
        if (visited[child]) {
          continue;
        }
        visited[child] = true;
        num++;
        q.offer(child);
      }
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(countPairs(3, new int[][]{{0,1},{0,2},{1,2}}));
    System.out.println(countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
  }
}
