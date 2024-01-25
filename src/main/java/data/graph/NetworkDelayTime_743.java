package data.graph;

import java.util.*;

public class NetworkDelayTime_743 {
  public static int networkDelayTime(int[][] times, int n, int k) {
    var adjMap = new HashMap<Integer, List<int[]>>();
    var delays = new int[n + 1];
    Arrays.fill(delays, Integer.MAX_VALUE);
    delays[0] = 0;
    delays[k] = 0;
    for (var time : times) {
      if (!adjMap.containsKey(time[0])) {
        adjMap.put(time[0], new ArrayList<>());
      }
      adjMap.get(time[0]).add(new int[]{time[1], time[2]});
    }

    shortestPath(adjMap, k, delays, new boolean[n + 1]);

    var max = 0;
    for (var d : delays) {
      if (d != 0) {
        if (d == Integer.MAX_VALUE) {
          return -1;
        }
        max = Math.max(max, d);
      }
    }
    return max;
  }

  private static void shortestPath(Map<Integer, List<int[]>> adjMap, int k, int[] delays, boolean[] visited) {
    var pq = new PriorityQueue<Integer>(Comparator.comparingInt(a -> delays[a]));
    pq.offer(k);
    while (!pq.isEmpty()) {
      var node = pq.poll();
      if (visited[node]) {
        continue;
      }
      if (!adjMap.containsKey(node)) {
        continue;
      }
      visited[node] = true;
      for (var next : adjMap.get(node)) {
        int sibling = next[0], distance = next[1];
        delays[sibling] = Math.min(delays[sibling], delays[node] + distance);
        pq.offer(sibling);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    System.out.println(networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
  }
}
