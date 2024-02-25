package data.graph;

import java.util.*;

public class AllAncestorsOfANodeInADirectedAcyclicGraph_2192 {
    /**
     * Topology sort
     */
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        var indegree = new int[n];
        var adjMap = new HashMap<Integer, List<Integer>>();
        for (var e : edges) {
            indegree[e[1]]++;
            if (!adjMap.containsKey(e[0])) {
                adjMap.put(e[0], new ArrayList<>());
            }
            adjMap.get(e[0]).add(e[1]);
        }

        var q = new ArrayDeque<Integer>();
        for (var i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        var ancestors = new ArrayList<Set<Integer>>(n);
        for (var i = 0; i < n; i++) {
            ancestors.add(new TreeSet<>());
        }
        while (!q.isEmpty()) {
            var parent = q.poll();
            if (!adjMap.containsKey(parent)) {
                continue;
            }
            for (var child : adjMap.get(parent)) {
                ancestors.get(child).add(parent);
                ancestors.get(child).addAll(ancestors.get(parent));
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.offer(child);
                }
            }
        }
        return ancestors.stream().map(List::copyOf).toList();
    }

    public static void main(String[] args) {
        getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}).forEach(System.out::println);
        getAncestors(5, new int[][]{{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}).forEach(System.out::println);
    }
}
