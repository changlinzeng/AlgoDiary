package algo.breadthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class SlidingPuzzle_773 {
  private static final String TARGET_STATE = "123450";
  private static final Map<Integer, int[]> DIRECTIONS = new HashMap<>()
  {
    {
      put(0, new int[]{1, 3});
      put(1, new int[]{0, 2, 4});
      put(2, new int[]{1, 5});
      put(3, new int[]{0, 4});
      put(4, new int[]{1, 3, 5});
      put(5, new int[]{2, 4});
    }
  };

  public static int slidingPuzzle(int[][] board) {
    return bfs(board, 0);
  }

  private static int bfs(int[][] state, int steps) {
    var states = new LinkedList<String>();
    var visited = new HashSet<String>();
    var initial = serialize(state);
    states.offer(initial);
    visited.add(initial);
    while (!states.isEmpty()) {
      var size = states.size();
      while (size-- > 0) {
        var st = states.poll();
        if (st.equals(TARGET_STATE)) {
          return steps;
        }
        var pos = st.indexOf('0');
        var dir = DIRECTIONS.get(pos);
        for (var d : dir) {
          var tmp = st.charAt(d);
          var next = st.replace('0', '6').replace(tmp, '0').replace('6', tmp);
          if (visited.add(next)) {
            states.offer(next);
          }
        }
      }
      steps++;
    }
    return -1;
  }

  private static String serialize(int[][] state) {
    var ser = "";
    for (var s : state) {
      for (var v : s) {
        ser += v;
      }
    }
    return ser;
  }

  public static void main(String[] args) {
    System.out.println(slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
    System.out.println(slidingPuzzle(new int[][]{{1,2,3},{5,4,0}}));
    System.out.println(slidingPuzzle(new int[][]{{4,1,2},{5,0,3}}));
  }
}
