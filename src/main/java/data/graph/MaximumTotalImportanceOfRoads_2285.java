package data.graph;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MaximumTotalImportanceOfRoads_2285 {
    public static long maximumImportance(int n, int[][] roads) {
        // calculate degree and sort in descending order
        var degree = new HashMap<Integer, Integer>();
        var pq = new PriorityQueue<Integer>((a, b) -> degree.get(b) - degree.get(a));
        for (var road : roads) {
            degree.put(road[0], degree.getOrDefault(road[0], 0) + 1);
            degree.put(road[1], degree.getOrDefault(road[1], 0) + 1);
        }

        for (var key : degree.keySet()) {
            pq.offer(key);
        }

        long max = 0;
        var importance = n;
        while (!pq.isEmpty()) {
            var city = pq.poll();
            max += (long) degree.get(city) * importance;
            importance--;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
        System.out.println(maximumImportance(5, new int[][]{{0,3},{2,4},{1,3}}));
    }
}
