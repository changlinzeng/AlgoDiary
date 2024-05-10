package data.graph;

import java.util.*;

public class CourseSchedule_II_210 {
    // Topology sort according to indegree
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        var degree = new int[numCourses];
        var adjMap = new HashMap<Integer, List<Integer>>();
        for (var pre : prerequisites) {
            adjMap.putIfAbsent(pre[1], new ArrayList<>());
            adjMap.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }

        var order = new ArrayList<Integer>();
        var q = new ArrayDeque<Integer>();
        for (var i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            var c = q.poll();
            order.add(c);
            if (adjMap.containsKey(c)) {
                for (var n : adjMap.get(c)) {
                    degree[n]--;
                    if (degree[n] == 0) {
                        q.offer(n);
                    }
                }
            }
        }
        if (order.size() < numCourses) {
            return new int[0];
        }

        var arr = new int[numCourses];
        for (var i = 0; i < arr.length; i++) {
            arr[i] = order.get(i);
        }
        return arr;
    }

    public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        var adjMap = new HashMap<Integer, List<Integer>>();
        var visited = new boolean[numCourses];
        var roots = new HashSet<Integer>();
        for (var i = 0; i < numCourses; i++) {
            roots.add(i);
            adjMap.put(i, new ArrayList<>());
        }
        for (var pre : prerequisites) {
            roots.remove(pre[1]);
            adjMap.get(pre[0]).add(pre[1]);
        }

        var path = new ArrayList<Integer>();
        for (var r : roots) {
            var seq = new ArrayList<Integer>();
            if (dfs(adjMap, r, seq, new int[numCourses], visited)) {
                path.addAll(seq);
            }
        }
        // make sure all nodes are visited
        for (var v : visited) {
            if (!v) {
                return new int[0];
            }
        }
        return path.stream().mapToInt(n -> n).toArray();
    }

    /**
     * Backorder traversal
     */
    private static boolean dfs(Map<Integer, List<Integer>> adjMap, int node, List<Integer> seq, int[] color, boolean[] visited) {
        switch (color[node]) {
            // mark the node as visited
            case 0 -> color[node] = 1;
            // find cycle
            case 1 -> {
                return false;
            }
            case 2 -> {
                return true;
            }
        }

        for (var child : adjMap.get(node)) {
            if (!dfs(adjMap, child, seq, color, visited)) {
                return false;
            }
        }

        // mark node as confirmed when all children are confirmed
        color[node] = 2;
        // prevent duplicate
        if (!visited[node]) {
            visited[node] = true;
            seq.add(node);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0},{2,0},{3,1},{3,2}})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{0,1}})));
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{1,0},{2,0}})));
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{2,0},{2,1}})));
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{1,0},{1,2},{0,1}})));
    }
}
