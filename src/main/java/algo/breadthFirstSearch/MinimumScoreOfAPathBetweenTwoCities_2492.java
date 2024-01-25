package algo.breadthFirstSearch;

import java.util.*;

public class MinimumScoreOfAPathBetweenTwoCities_2492 {
    public static int minScore(int n, int[][] roads) {
        var adjMap = new HashMap<Integer, List<int[]>>();
        for (var road : roads) {
            int city = road[0], target = road[1], score = road[2], visited = 0;
            if (!adjMap.containsKey(city)) {
                adjMap.put(city, new ArrayList<>());
            }
            adjMap.get(city).add(new int[]{city, target, score, visited});
            if (!adjMap.containsKey(target)) {
                adjMap.put(target, new ArrayList<>());
            }
            adjMap.get(target).add(new int[]{target, city, score, visited});
        }

//        return dfs(n, adjMap, 1, Integer.MAX_VALUE);
        return bfs(n, adjMap);
    }

    private static int bfs(int n, Map<Integer, List<int[]>> adjMap) {
        var q = new LinkedList<Integer>();
        var visited = new boolean[n + 1];
        var minCost = Integer.MAX_VALUE;
        q.offer(1);
        while (!q.isEmpty()) {
            var city = q.poll();
            if (visited[city]) {
                continue;
            }
            visited[city] = true;
            for (var neighbour : adjMap.get(city)) {
                int target = neighbour[1], cost = neighbour[2];
                minCost = Math.min(cost, minCost);
                q.offer(target);
            }
        }
        return minCost;
    }

    /**
     * Timeout !!
     */
    private static int dfs(int n, Map<Integer, List<int[]>> adjMap, int city, int cost) {
        if (city == n) {
            return cost;
        }
        var minCost = cost;
        for (var neighbour : adjMap.get(city)) {
            if (neighbour[3] != 0) {
                continue;
            }
            neighbour[3] = 1;
            var c = dfs(n, adjMap, neighbour[1], neighbour[2]);
            minCost = Math.min(c, minCost);
        }
        return minCost;
    }

    public static void main(String[] args) {
//        System.out.println(minScore(4, new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}}));
//        System.out.println(minScore(4, new int[][]{{1,2,2},{1,3,4},{3,4,7}}));
        System.out.println(minScore(7, new int[][]{{1,3,1484},{3,2,3876},{2,4,6823},{6,7,579},{5,6,4436},{4,5,8830}}));
    }
}
