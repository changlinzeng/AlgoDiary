package data.graph;

import java.util.*;

public class CourseSchedule_IV_1462 {
  public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    for (var pre : prerequisites) {
      if (pre.length > 0) {
        if (!adjMap.containsKey(pre[0])) {
          adjMap.put(pre[0], new ArrayList<>());
        }
        adjMap.get(pre[0]).add(pre[1]);
      }
    }

    var result = new ArrayList<Boolean>();
    for (var q : queries) {
      result.add(checkPrerequisite(adjMap, q[0], q[1], new HashSet<>()));
    }
    return result;
  }

  private static boolean checkPrerequisite(Map<Integer, List<Integer>> adjMap, int node, int to, Set<Integer> pre) {
    if (node == to) {
      return true;
    }
    if (!adjMap.containsKey(node)) {
      return false;
    }
    // find circle
    if (pre.contains(node)) {
      return false;
    }
    pre.add(node);
    for (var child : adjMap.get(node)) {
      if (checkPrerequisite(adjMap, child, to, pre)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    checkIfPrerequisite(2, new int[][]{{1,0}}, new int[][]{{0,1},{1,0}}).forEach(System.out::println);
    checkIfPrerequisite(2, new int[][]{{}}, new int[][]{{0,1},{1,0}}).forEach(System.out::println);
    checkIfPrerequisite(3, new int[][]{{1,2},{1,0},{2,0}}, new int[][]{{1,0},{1,2}}).forEach(System.out::println);
  }
}
