package algo.depthFirstSearch;

import java.util.*;

public class MinimumHeightTrees_310 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            return List.of(0);
        }

        var minHeight = Integer.MAX_VALUE;
        var adjMap = new HashMap<Integer, List<Integer>>();

        for (var i = 0; i < n; i++) {
            adjMap.put(i, new ArrayList<>());
        }
        for (var edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }

        var heightMap = new HashMap<Integer, List<Integer>>();
        var visited = new boolean[n];
        var q = new ArrayDeque<Integer>();
        q.offer(0);
        while (!q.isEmpty()) {
            var node = q.poll();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            var superHeight = false;
            int maxH = Integer.MIN_VALUE;
            var hmap = new HashMap<Integer, List<Integer>>();  // height -> child nodes
            for (var c : adjMap.get(node)) {
                var v = new boolean[n];
                v[node] = true;
                var h = height(adjMap, c, v);
                if (h > minHeight) {
                    superHeight = true;
                    break;
                }
                if (h >= maxH) {
                    maxH = h;
                    if (!hmap.containsKey(h)) {
                        hmap.put(h, new ArrayList<>());
                    }
                    hmap.get(h).add(c);
                }
            }
            if (superHeight) {
                continue;
            }
            minHeight = Math.min(maxH, minHeight);
            if (!heightMap.containsKey(maxH)) {
                heightMap.put(maxH, new ArrayList<>());
            }
            heightMap.get(maxH).add(node);
            // continue with the sub tree with the max height
            for (var entry : hmap.entrySet()) {
                if (entry.getKey() == maxH) {
                    entry.getValue().forEach(q::offer);
                    break;
                }
            }
        }
        return heightMap.get(minHeight);
    }

    private static int height(Map<Integer, List<Integer>> adjMap, int node, boolean[] visited) {
        if (visited[node] || adjMap.get(node).isEmpty()) {
            return 0;
        }
        var h = 0;
        visited[node] = true;
        for (var child : adjMap.get(node)) {
            h = Math.max(h, 1 + height(adjMap, child, visited));
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
        System.out.println(findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
        System.out.println(findMinHeightTrees(7, new int[][]{{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}}));
    }
}
