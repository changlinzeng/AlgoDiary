package data.graph;

import java.util.*;

public class CheapestFlightsWithinKStops_787 {
    private static int minPrice = Integer.MAX_VALUE;

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var adjList = new HashMap<Integer, List<int[]>>();
        for (var i = 0; i < n ;i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (var f : flights) {
            adjList.get(f[0]).add(new int[]{f[1], f[2]});
        }

//        return findCheapestDFS(adjList, src, dst, k);
        return findCheapestDijkstra(adjList, src, dst, k);
    }

    private static int findCheapestDijkstra(Map<Integer, List<int[]>> adjList, int src, int dst, int k) {
        var cost = new int[adjList.size()];
        var pq = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.stops));
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        pq.offer(new Node(src, 0, 0));
        while (!pq.isEmpty()) {
            var node = pq.poll();
            int dist = node.distance, stops = node.stops;
            for (var n : adjList.get(node.city)) {
                int sibling = n[0], price = n[1];
                if (stops <= k && dist + price < cost[sibling]) {
                    cost[sibling] = dist + price;
                    pq.offer(new Node(sibling, cost[sibling], stops + 1));
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    private record Node(int city, int distance, int stops) {}

    /**
     * dfs has time limit exceeded issue
     */
    private static int findCheapestDFS(Map<Integer, List<int[]>> adjList, int src, int dst, int k) {
        findPrice(adjList, src, dst, k + 1, 0);
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    private static void findPrice(Map<Integer, List<int[]>> adjList, int current, int dst, int k, int total) {
        if (k < 0) {
            return;
        }
        if (current == dst) {
            minPrice = Math.min(total, minPrice);
            return;
        }
        for (var neighbour : adjList.get(current)) {
            findPrice(adjList, neighbour[0], dst, k - 1, total + neighbour[1]);
        }
    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
        System.out.println(findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
        System.out.println(findCheapestPrice(5, new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}}, 0, 2, 2));
        System.out.println(findCheapestPrice(5, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1},{3,4,1}}, 0, 4, 2));
    }
}
