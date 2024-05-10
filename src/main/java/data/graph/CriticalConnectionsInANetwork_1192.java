package data.graph;

import java.util.*;

public class CriticalConnectionsInANetwork_1192 {
  // TODO Timeout!!
  // a critical connection is the edge not in a circle
  // so the question is to find circles and then keep the edges not in circle
  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    var edges = new HashSet<String>();
    for (var conn : connections) {
      int from = conn.get(0), to = conn.get(1);
      adjMap.putIfAbsent(from, new ArrayList<>());
      adjMap.get(from).add(to);
      adjMap.putIfAbsent(to, new ArrayList<>());
      adjMap.get(to).add(from);
      if (from < to) {
        edges.add(from + "_" + to);
      } else {
        edges.add(to + "_" + from);
      }
    }

    dfs(adjMap, -1, 0, new ArrayList<>(), edges);

    return edges.stream().map(e -> List.of(Integer.valueOf(e.split("_")[0]), Integer.valueOf(e.split("_")[1]))).toList();
  }

  // find circles and then discard the edges in the circle
  private static void dfs(Map<Integer, List<Integer>> adjMap, int parent, int node, List<Integer> path, Set<String> edges) {
    if (!adjMap.containsKey(node)) {
      return;
    }
    if (path.contains(node)) {
      // detect circle
      var cur = node;
      while (path.getLast() != node) {
        var last = path.removeLast();
        if (cur < last) {
          edges.remove(cur + "_" + last);
        } else {
          edges.remove(last + "_" + cur);
        }
        cur = last;
      }
      var last = path.removeLast();
      if (cur < last) {
        edges.remove(cur + "_" + last);
      } else {
        edges.remove(last + "_" + cur);
      }
      return;
    }
    path.add(node);
    for (var child : adjMap.get(node)) {
      if (child == parent) {
        continue;
      }
      var from = node > child ? child : node;
      var to = node > child ? node : child;
      if (edges.contains(from + "_" + to)) {
        dfs(adjMap, node, child, new ArrayList<>(path), edges);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(criticalConnections(4, List.of(List.of(0,1), List.of(1,2), List.of(2,0), List.of(1,3))));
  }
}
