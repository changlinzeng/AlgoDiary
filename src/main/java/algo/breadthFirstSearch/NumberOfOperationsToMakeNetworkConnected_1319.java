package algo.breadthFirstSearch;

import java.util.*;

public class NumberOfOperationsToMakeNetworkConnected_1319 {
    public static int makeConnected(int n, int[][] connections) {
        var edges = new boolean[connections.length];
        var union = new int[n];
        for (var i = 0; i <n; i++) {
            union[i] = i;
        }
        connect(connections, connections[0][0], union, edges);

        // not used edges
        var leftEdges = 0;
        for (var edge : edges) {
            if (!edge) {
                leftEdges += 1;
            }
        }

        var groups = new HashSet<Integer>();
        for (var group : union) {
            groups.add(group);
        }

        if (groups.size() == 1) {
            return 0;
        }
        if (leftEdges >= groups.size() - 1) {
            return groups.size() - 1;
        } else {
            return -1;
        }
    }

    private static void connect(int[][] connections, int node, int[] union, boolean[] edges) {
        for (var i = 0; i < connections.length; i++) {
            var edge = connections[i];
            int from = edge[0], to = edge[1];
            // add edge to forest if the target node is not in the forest
            if (union[from] != union[to]) {
                edges[i] = true;
                // connect to groups
                var par = union[to];
                for (var k = 0; k < union.length; k++) {
                    if (union[k] == par) {
                        union[k] = union[from];
                    }
                }
            }
        }
    }

    public static int makeConnectedBfs(int n, int[][] connections) {
        var adjMap = new HashMap<Integer, List<Integer>>();
        var visited = new boolean[n];

        if (connections.length < n - 1) {
            return -1;
        }

        for (var i = 0; i < n; i++) {
            adjMap.put(i, new ArrayList<>());
        }
        for (var conn : connections) {
            adjMap.get(conn[0]).add(conn[1]);
            adjMap.get(conn[1]).add(conn[0]);
        }

        var group = 0;
        for (var i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(adjMap, i, visited);
                group++;
            }
        }

        return group - 1;
    }

    private static void bfs(Map<Integer, List<Integer>> adjMap, int node, boolean[] visited) {
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
                q.offer(child);
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(makeConnected(4, new int[][]{{0,1},{0,2},{1,2}}));
//        System.out.println(makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
//        System.out.println(makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}}));
//        System.out.println(makeConnected(12, new int[][]{{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}}));
//        System.out.println(makeConnected(5, new int[][]{{0,1},{0,2},{3,4},{2,3}}));

        System.out.println(makeConnectedBfs(4, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(makeConnectedBfs(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
    }
}
