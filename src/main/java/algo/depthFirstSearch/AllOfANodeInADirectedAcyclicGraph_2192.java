package algo.depthFirstSearch;

import java.util.*;
import java.util.stream.Collectors;

public class AllOfANodeInADirectedAcyclicGraph_2192 {
  public static List<List<Integer>> getAncestors(int n, int[][] edges) {
    var roots = new HashSet<Integer>();
    var adjMap = new HashMap<Integer, List<Integer>>();
    for (var i = 0; i < n; i++) {
      roots.add(i);
      adjMap.put(i, new ArrayList<>());
    }
    for (var edge : edges) {
      roots.remove(edge[1]);
      adjMap.get(edge[0]).add(edge[1]);
    }

    var ancestors = new HashMap<Integer, Set<Integer>>();
    for (var r : roots) {
      dfs(adjMap, r, ancestors, new TreeSet<>());
    }

    return ancestors.values().stream().map(ArrayList::new).collect(Collectors.toList());
  }

  private static void dfs(Map<Integer, List<Integer>> adjMap, int node,
                          Map<Integer, Set<Integer>> ancestors, Set<Integer> ancestor) {
    if (!ancestors.containsKey(node)) {
      ancestors.put(node, new TreeSet<>());
    }
    ancestors.get(node).addAll(ancestor);

    for (var child : adjMap.get(node)) {
      ancestor.add(node);
      dfs(adjMap, child, ancestors, ancestor);
      ancestor.remove(node);
    }
  }

  public static void main(String[] args) {
    getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}).forEach(System.out::println);
  }
}
