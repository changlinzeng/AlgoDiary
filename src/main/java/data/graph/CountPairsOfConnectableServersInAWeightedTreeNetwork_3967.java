package data.graph;

import java.util.*;

public class CountPairsOfConnectableServersInAWeightedTreeNetwork_3967 {
  public static int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
    var adjMap = new HashMap<Integer, List<int[]>>();
    for (var e : edges) {
      int from = e[0], to = e[1], weight = e[2];
      adjMap.putIfAbsent(from, new ArrayList<>());
      adjMap.get(from).add(new int[]{to, weight});
      adjMap.putIfAbsent(to, new ArrayList<>());
      adjMap.get(to).add(new int[]{from, weight});
    }

    var numNodes = edges.length + 1;
    var pairs = new int[numNodes];
    for (var i = 0; i < numNodes; i++) {
      if (adjMap.containsKey(i)) {
        var nodeCount = new int[adjMap.get(i).size()];
        dfs(adjMap, i, 0, signalSpeed, -1, nodeCount, new boolean[numNodes]);
        var count = 0;
        for (var j = 0; j < nodeCount.length; j++) {
          for (var k = j + 1; k < nodeCount.length; k++) {
            count += nodeCount[j] * nodeCount[k];
          }
        }
        pairs[i] = count;
      }
    }
    return pairs;
  }

  private static void dfs(Map<Integer, List<int[]>> adjMap, int node, int weight, int speed, int direction, int[] subnodes, boolean[] visited) {
    if (!adjMap.containsKey(node) || visited[node]) {
      return;
    }
    if (direction != -1 && weight % speed == 0) {
      subnodes[direction]++;
    }
    visited[node] = true;
    for (var i = 0; i < adjMap.get(node).size(); i++) {
      int child = adjMap.get(node).get(i)[0], w = adjMap.get(node).get(i)[1];
      var newDirection = direction == -1 ? i : direction;
      dfs(adjMap, child, weight + w, speed, newDirection, subnodes, visited);
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(countPairsOfConnectableServers(new int[][]{{0,1,1},{1,2,5},{2,3,13},{3,4,9},{4,5,2}}, 1)));
  }
}
