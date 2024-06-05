package data.graph;

import java.util.*;

/**
 * Check cycle from each node whose indegreee is 0
 */
public class CourseSchedule_207 {
  public static boolean canFinish2(int numCourses, int[][] prerequisites) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    var visited = new boolean[numCourses];
    var roots = new HashSet<Integer>();
    for (var i = 0; i < numCourses; i++) {
      roots.add(i);
      adjMap.put(i, new ArrayList<>());
    }
    for (var pre : prerequisites) {
      if (pre[0] == pre[1]) {
        return false;
      }
      adjMap.get(pre[1]).add(pre[0]);
      roots.remove(pre[0]);
    }
    if (roots.isEmpty()) {
      return false;
    }
    // dfs from nodes with indegree 0
    for (var r : roots) {
      if (!dfs(adjMap, r, new int[numCourses], visited)) {
        return false;
      }
    }
    for (var v : visited) {
      if (!v) {
        return false;
      }
    }
    return true;
  }

  private static boolean dfs(Map<Integer, List<Integer>> adjMap, int node, int[] color, boolean[] visited) {
    switch (color[node]) {
      // mark the node as visited
      case 0 -> color[node] = 1;
      case 1 -> {
        // find cycle
        return false;
      }
      case 2 -> {
        return true;
      }
    }
    for (var child : adjMap.get(node)) {
      if (!dfs(adjMap, child, color, visited)) {
        return false;
      }
    }
    // mark node as confirmed if all children are confirmed
    color[node] = 2;
    visited[node] = true;
    return true;
  }

  // Topological sort
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    var degree = new int[numCourses];
    var adjMap = new HashMap<Integer, List<Integer>>();
    for (var pre : prerequisites) {
      adjMap.putIfAbsent(pre[1], new ArrayList<>());
      adjMap.get(pre[1]).add(pre[0]);
      degree[pre[0]]++;
    }

    var q = new ArrayDeque<Integer>();
    for (var i = 0; i < degree.length; i++) {
      if (degree[i] == 0) {
        q.offer(i);
      }
    }

    // no nodes with degree 0 found, so there are circles
    if (q.isEmpty()) {
      return false;
    }

    var visited = new HashSet<Integer>();
    while (!q.isEmpty()) {
      var course = q.poll();
      if (!visited.add(course)) {
        return false;
      }
      if (!adjMap.containsKey(course)) {
        continue;
      }
      for (var child : adjMap.get(course)) {
        degree[child]--;
        if (degree[child] == 0) {
          q.offer(child);
        }
      }
    }

    return visited.size() == numCourses;
  }

  public static void main(String[] args) {
    System.out.println(canFinish(2, new int[][]{{1,0}}));
    System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
    System.out.println(canFinish(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
    System.out.println(canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
    System.out.println(canFinish(3, new int[][]{{2,0},{2,1}}));
    System.out.println(canFinish(8, new int[][]{{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5}}));
  }
}
