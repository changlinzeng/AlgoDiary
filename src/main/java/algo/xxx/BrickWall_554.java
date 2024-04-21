package algo.xxx;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class BrickWall_554 {
  public static int leastBricks(List<List<Integer>> wall) {
    // to cross through least bricks equals to cross through more edges
    // so record positions of edges
    var edges = new HashMap<Integer, Integer>();
    wall.forEach(row -> {
      int left = 0, right = 0;
      for (var brick : row) {
        right = left + brick;
        if (left > 0) {
          edges.put(left, edges.getOrDefault(left, 0) + 1);
        }
        left = right;
      }
    });

    if (edges.isEmpty()) {
      return wall.size();
    }

    var pq = new PriorityQueue<Integer>((a, b) -> edges.get(b) - edges.get(a));
    edges.keySet().forEach(pq::offer);
    return wall.size() - edges.get(pq.peek());
  }

  public static void main(String[] args) {
    System.out.println(leastBricks(List.of(List.of(1,2,2,1), List.of(3,1,2), List.of(1,3,2), List.of(2,4), List.of(3,1,2), List.of(1,3,1,1))));
  }
}
