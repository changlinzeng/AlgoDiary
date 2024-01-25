package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates_802 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        var safeNodes = new ArrayList<Integer>();
        for (var i = 0; i < graph.length; i++) {
            if (isSafeNode(graph, i, new boolean[graph.length], new boolean[graph.length])) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    public static boolean isSafeNode(int[][] graph, int node, boolean[] path, boolean[] visited) {
        if (path[node]) {
            // found cycle
            return false;
        }
        if (visited[node]) {
            return true;
        }
        path[node] = true;
        visited[node] = true;
        for (var child : graph[node]) {
            if (!isSafeNode(graph, child, path, visited)) {
                return false;
            }
        }
        path[node] = false;
        return true;
    }

    public static boolean isSafeNodeColor(int[][] graph, int node, int[] color) {
        if (color[node] != 0) {
            // if it is a grey node, then we find a cycle
            return color[node] == 2;
        }
        // grey
        color[node] = 1;
        for (var child : graph[node]) {
            if (!isSafeNodeColor(graph, child, color)) {
                return false;
            }
        }
        // there is no cycle in sub graph so we mark it as black
        color[node] = 2;
        return true;
    }

    public static void main(String[] args) {
//        var nodes = eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}});
//        var nodes = eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}});
        var nodes = eventualSafeNodes(new int[][]{{},{0,2,3,4},{3},{4},{}});
        for (var n : nodes) {
            System.out.println(n);
        }
    }
}
