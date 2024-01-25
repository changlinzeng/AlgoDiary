package algo.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeNeededToInformAllEmployees_1376 {
  public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    var adjMap = new HashMap<Integer, List<Integer>>();
    for (var i = 0; i < manager.length; i++) {
      if (!adjMap.containsKey(manager[i])) {
        adjMap.put(manager[i], new ArrayList<>());
      }
      adjMap.get(manager[i]).add(i);
    }

    var time = 0;
    var q = new ArrayDeque<EmployeeTime>();
    q.offer(new EmployeeTime(headID, 0));
    while (!q.isEmpty()) {
      var mng = q.poll();
      time = Math.max(time, mng.time());
      if (adjMap.containsKey(mng.employeeId())) {
        for (var emp : adjMap.get(mng.employeeId())) {
          q.offer(new EmployeeTime(emp, mng.time() + informTime[mng.employeeId()]));
        }
      }
    }
    return time;
  }

  private record EmployeeTime (int employeeId, int time) {}

  public static void main(String[] args) {
    System.out.println(numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
  }
}
