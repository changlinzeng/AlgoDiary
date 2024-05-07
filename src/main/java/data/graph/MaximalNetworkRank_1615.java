package data.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaximalNetworkRank_1615 {
  public static int maximalNetworkRank(int n, int[][] roads) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    for (var r : roads) {
      int from = r[0], to = r[1];
      adjMap.putIfAbsent(from, new ArrayList<>());
      adjMap.get(from).add(to);
      adjMap.putIfAbsent(to, new ArrayList<>());
      adjMap.get(to).add(from);
    }

    var maxRank = 0;
    for (var i = 0; i < n; i++) {
      for (var j = i + 1; j < n; j++) {
        var rank = 0;
        if (adjMap.containsKey(i)) {
          rank = adjMap.get(i).size();
        }
        if (adjMap.containsKey(j)) {
          rank += adjMap.get(j).size();
        }
        if (adjMap.containsKey(i) && adjMap.get(i).contains(j)) {
          rank--;
        }
        maxRank = Math.max(maxRank, rank);
      }
    }
    return maxRank;
  }
}
