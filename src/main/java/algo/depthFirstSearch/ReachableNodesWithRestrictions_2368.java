package algo.depthFirstSearch;

import java.util.*;

public class ReachableNodesWithRestrictions_2368 {
    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        var visited = new boolean[n];
        var restrictedNodes = new HashSet<Integer>();
        var adjMap = new HashMap<Integer, List<Integer>>();

        Arrays.stream(restricted).forEach(restrictedNodes::add);

        for (var edge : edges) {
            int from = edge[0], to = edge[1];
            if (!adjMap.containsKey(from)) {
                var list = new ArrayList<Integer>();
                list.add(to);
                adjMap.put(from, list);
            }
            if (!adjMap.containsKey(to)) {
                var list = new ArrayList<Integer>();
                list.add(from);
                adjMap.put(to, list);
            }
            adjMap.get(from).add(to);
            adjMap.get(to).add(from);
        }

//        return bfs(adjMap, restrictedNodes, visited);
        return dfs(adjMap, restrictedNodes, 0, visited);
    }

    private static int bfs(Map<Integer, List<Integer>> adjMap, Set<Integer> restricted, boolean[] visited) {
        var num = 0;
        var queue = new ArrayDeque<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (!visited[node] && !restricted.contains(node)) {
                num++;
                visited[node] = true;
                for (var child : adjMap.get(node)) {
                    if (!visited[child]) {
                        queue.offer(child);
                    }
                }
            }
        }

        return num;
    }

    private static int dfs(Map<Integer, List<Integer>> adjMap, Set<Integer> restricted, int node, boolean[] visited) {
        if (restricted.contains(node) || visited[node]) {
            return 0;
        }
        var num = 1;
        visited[node] = true;
        for (var child : adjMap.get(node)) {
            num += dfs(adjMap, restricted, child, visited);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(reachableNodes(7, new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}}, new int[]{4,5}));
    }
}
