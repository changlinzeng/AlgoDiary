package data.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfWaysToArriveAtDestination_1976 {
    private static final long mod = 1_000_000_007;
    private static long minTime = Long.MAX_VALUE;
    private static long count = 0;
    public static int countPaths(int n, int[][] roads) {
        var adjList = new HashMap<Integer, List<int[]>>();
        for (var r : roads) {
            if (adjList.containsKey(r[0])) {
                adjList.get(r[0]).add(new int[]{r[1], r[2]});
            } else {
                var list = new ArrayList<int[]>();
                list.add(new int[]{r[1], r[2]});
                adjList.put(r[0], list);
            }
        }
        paths(adjList, 0, n - 1, 0);
        return (int)count;
    }

    private static void paths(Map<Integer, List<int[]>> adjList, int from, int to, int time) {
        if (from == to) {
            if (time < minTime) {
                minTime = time;
                count = 1;
            }
            if (time == minTime) {
                count = (count + 1) % mod;
            }
            return;
        }
        if (adjList.containsKey(from)) {
            for (var neighbour : adjList.get(from)) {
                paths(adjList, neighbour[0], to, time + neighbour[1]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countPaths(7, new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }
}
