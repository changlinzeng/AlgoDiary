package algo.breadthFirstSearch;

import java.util.*;

public class CountTheNumberOfCompleteComponents_2685 {
  public static int countCompleteComponents(int n, int[][] edges) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    for (var edge : edges) {
      adjMap.putIfAbsent(edge[0], new ArrayList<>());
      adjMap.get(edge[0]).add(edge[1]);
      adjMap.putIfAbsent(edge[1], new ArrayList<>());
      adjMap.get(edge[1]).add(edge[0]);
    }

    var count = 0;
    var visited = new boolean[n];
    for (var i = 0; i < n; i++) {
      if (!visited[i]) {
        count += bfs(adjMap, i, visited);
      }
    }
    return count;
  }

  private static int bfs(Map<Integer, List<Integer>> adjMap, int node, boolean[] visited) {
    int nodeCount = 0, edgeCount = 0;
    var q = new ArrayDeque<Integer>();
    q.offer(node);
    while (!q.isEmpty()) {
      var e = q.poll();
      if (visited[e]) {
        continue;
      }
      visited[e] = true;
      nodeCount++;
      if (adjMap.containsKey(e)) {
        for (var c : adjMap.get(e)) {
          edgeCount++;
          q.offer(c);
        }
      }
    }

    edgeCount /= 2;
    if (edgeCount == nodeCount * (nodeCount - 1) / 2) {
      return 1;
    }
    return 0;
  }
}
