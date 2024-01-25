package data.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CircularArrayLoop_457 {
  public static boolean circularArrayLoop(int[] nums) {
    // turn the array into a graph and then check if there is cycle in the graph
    var len = nums.length;
    var graph = new HashMap<Integer, Integer>();
    var roots = new HashSet<Integer>();
    for (var i = 0; i < nums.length; i++) {
      var next = i + nums[i];
      while (next < 0) {
        next += len;
      }
      next = next % len;
      if (next != i) {
        graph.put(i, next);
      }
      roots.add(i);
      roots.remove(next);
    }

    for (var r : roots) {
      if (hasCircle(graph, r, new int[len])) {
        return true;
      }
    }
    return false;

//    for (var i = 0; i < len; i++) {
//      if (graph.containsKey(i)) {
//        // check cycle
//        var visited = new boolean[len];
//        var node = i;
//        while (graph.containsKey(node)) {
//          if (visited[node]) {
//            return true;
//          }
//          visited[node] = true;
//          node = graph.get(node);
//        }
//      }
//    }
//
//    return false;
  }

  private static boolean hasCircle(Map<Integer, Integer> adjMap, int node, int[] visited) {
    // grey means there is a circle
    if (visited[node] == 1) {
      return true;
    }
    if (visited[node] == 2) {
      return false;
    }
    visited[node] = 1;
    if (adjMap.containsKey(node) && hasCircle(adjMap, adjMap.get(node), visited)) {
      return true;
    }
    visited[node] = 2; // mark as done
    return false;
  }

  public static void main(String[] args) {
    System.out.println(circularArrayLoop(new int[]{2,-1,1,2,2}));
    System.out.println(circularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));
    System.out.println(circularArrayLoop(new int[]{1,-1,5,1,4}));
    System.out.println(circularArrayLoop(new int[]{-2,1,-1,-2,-2}));
  }
}
