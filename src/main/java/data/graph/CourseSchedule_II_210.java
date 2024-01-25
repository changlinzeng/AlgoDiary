package data.graph;

import java.util.*;

public class CourseSchedule_II_210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // calculate degree of each node
        var degree = new HashMap<Integer, Integer>();
        var sibling = new HashMap<Integer, List<Integer>>();
        var visited = new boolean[numCourses];
        for (var pre : prerequisites) {
            degree.put(pre[0], degree.getOrDefault(pre[0], 0) + 1);
            if (sibling.containsKey(pre[1])) {
                sibling.get(pre[1]).add(pre[0]);
            } else {
                var list = new ArrayList<Integer>();
                list.add(pre[0]);
                sibling.put(pre[1], list);
            }
        }
        for (var i = 0; i < numCourses; i++) {
            if (!degree.containsKey(i)) {
                degree.put(i, 0);
            }
        }

        var schedule = new ArrayList<Integer>();
        for (var course : degree.keySet()) {
            if (!visited[course] && degree.get(course) == 0) {
                dfs(course, sibling, degree, visited, schedule);
            }
        }

        // check if there are nodes whose degree is not zero as any nodes in a cycle will have degree > 0
        for (var key : degree.keySet()) {
            if (degree.get(key) > 0) {
                return new int[0];
            }
        }

        var result = new int[schedule.size()];
        for (var i = 0; i < schedule.size(); i++) {
            result[i] = schedule.get(i);
        }
        return result;
    }

    private static void dfs(int course, Map<Integer, List<Integer>> sibling, Map<Integer, Integer> degree,
                               boolean[] visited, List<Integer> schedule) {
        if (visited[course]) {
            return;
        }
        // consume the node if degree is 0 otherwise there are prerequisites not fulfilled
        if (degree.get(course) == 0) {
            visited[course] = true;
            schedule.add(course);
            if (sibling.containsKey(course)) {
                for (var i : sibling.get(course)) {
                    degree.put(i, Math.max(degree.get(i) - 1, 0));
                    dfs(i, sibling, degree, visited, schedule);
                }
            }
        }
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
//        var order = findOrder(2, new int[][]{{1, 0}});
        var order = findOrder2(4, new int[][]{{1, 0},{2,0},{3,1},{3,2}});
//        var order = findOrder(2, new int[][]{{0,1}});
//        var order = findOrder2(3, new int[][]{{1,0},{2,0}});
//        var order = findOrder(3, new int[][]{{2,0},{2,1}});
//        var order = findOrder2(3, new int[][]{{1,0},{1,2},{0,1}});
        for (var i : order) {
            System.out.println(i);
        }
    }
}
