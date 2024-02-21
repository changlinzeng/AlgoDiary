package algo.depthFirstSearch;

import java.util.*;

public class MinimumHeightTrees_310 {
    /**
     * the roots of MHT must be the mid points of the longest leaf to leaf path in the tree.
     * And to find the longest path, we can first find the farthest leaf from any node, and then find
     * the farthest leaf from the node found above. Then these two nodes we found are the end points
     * of the longest path. And last, we find the centers of the longest path
     */
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        var degree = new int[n];
        var adjMap = new HashMap<Integer, List<Integer>>();
        for (var e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
            if (!adjMap.containsKey(e[0])) {
                adjMap.put(e[0], new ArrayList<>());
            }
            adjMap.get(e[0]).add(e[1]);
            if (!adjMap.containsKey(e[1])) {
                adjMap.put(e[1], new ArrayList<>());
            }
            adjMap.get(e[1]).add(e[0]);
        }

        // add leaf nodes to queue
        var q = new ArrayDeque<Integer>();
        for (var i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        var nodes = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            nodes.clear();
            var size = q.size();
            for (var i = 0; i < size; i++) {
                var node = q.poll();
                nodes.add(node);
                degree[node]--;
                for (var child : adjMap.get(node)) {
                    degree[child]--;
                    if (degree[child] == 1) {
                        q.offer(child);
                    }
                }
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
        System.out.println(findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
        System.out.println(findMinHeightTrees(7, new int[][]{{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}}));
    }
}
