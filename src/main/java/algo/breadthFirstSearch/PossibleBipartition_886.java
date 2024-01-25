package algo.breadthFirstSearch;

import java.util.*;

public class PossibleBipartition_886 {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }

        var colors = new int[n + 1];
        var adjMap = new HashMap<Integer, List<Integer>>();
        for (var dis : dislikes) {
            if (adjMap.containsKey(dis[0])) {
                adjMap.get(dis[0]).add(dis[1]);
            } else {
                var list = new ArrayList<Integer>();
                list.add(dis[1]);
                adjMap.put(dis[0], list);
            }
            if (adjMap.containsKey(dis[1])) {
                adjMap.get(dis[1]).add(dis[0]);
            } else {
                var list = new ArrayList<Integer>();
                list.add(dis[0]);
                adjMap.put(dis[1], list);
            }
        }

        for (var i = 1; i <= n; i++) {
            if (colors[i] == 0) {
//                if (!bfs(i, adjMap, colors)) {
//                    return false;
//                }
                if (!dfs(i, adjMap, 1, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(int node, Map<Integer, List<Integer>> adjMap, int[] colors) {
        if (!adjMap.containsKey(node)) {
            return true;
        }
        colors[node] = 1;
        var queue = new LinkedList<Integer>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            var parent = queue.poll();
            for (var child : adjMap.get(parent)) {
                if (colors[child] == colors[parent]) {
                    return false;
                }
                if (colors[child] == 0) {
                    colors[child] = -1 * colors[parent];
                    queue.offer(child);
                }
            }
        }

        return true;
    }

    private static boolean dfs(int node, Map<Integer, List<Integer>> adjMap, int color, int[] colors) {
        // node is colored with the other color
        if (colors[node] != 0 && colors[node] != color) {
            return false;
        } else if (colors[node] == color) {
            return true;
        }
        colors[node] = color;
        if (!adjMap.containsKey(node)) {
            return true;
        }
        for (var child : adjMap.get(node)) {
            if (!dfs(child, adjMap, -1 * color, colors)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
        System.out.println(possibleBipartition(3, new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(possibleBipartition(10, new int[][]{{1,2},{3,4},{5,6},{6,7},{8,9},{7,8}}));
        System.out.println(possibleBipartition(5, new int[][]{{1,2},{3,4},{4,5},{3,5}}));
    }
}
