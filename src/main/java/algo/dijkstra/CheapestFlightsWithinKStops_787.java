package algo.dijkstra;

import java.util.*;

public class CheapestFlightsWithinKStops_787 {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var adjList = new HashMap<Integer, List<int[]>>();
        for (var f : flights) {
            adjList.putIfAbsent(f[0], new ArrayList<>());
            adjList.get(f[0]).add(new int[]{f[1], f[2]});
        }

        return findCheapestDijkstra(n, adjList, src, dst, k);
    }

    private static int findCheapestDijkstra(int n, Map<Integer, List<int[]>> adjList, int src, int dst, int k) {
        var cost = new int[n];
        var pq = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.stops));
        Arrays.fill(cost, Integer.MAX_VALUE);

        pq.offer(new Node(src, 0, 0));
        while (!pq.isEmpty()) {
            var node = pq.poll();
            int city = node.city, dist = node.distance, stops = node.stops;
            if (!adjList.containsKey(city)) {
                continue;
            }
            if (stops > k) {
                continue;
            }
            for (var nextCity : adjList.get(city)) {
                int sibling = nextCity[0], price = nextCity[1];
                if (dist + price < cost[sibling]) {
                    cost[sibling] = dist + price;
                    pq.offer(new Node(sibling, cost[sibling], stops + 1));
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    private record Node(int city, int distance, int stops) {}

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
        System.out.println(findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
        System.out.println(findCheapestPrice(5, new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}}, 0, 2, 2));
        System.out.println(findCheapestPrice(5, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1},{3,4,1}}, 0, 4, 2));
    }
}
