package algo.greedy;

import java.util.*;

/**
 * Scheduling problems can be solved with greedy algorithm. Backtrack has a high complexity
 */
public class CourseSchedule_III_630 {
  public static int scheduleCourse(int[][] courses) {
//    return backtrack(courses, 0, new boolean[courses.length], new HashSet<>());
    return greedy(courses);
  }

  private static int greedy(int[][] courses) {
    int count = 0, start = 0;
    var pq = new PriorityQueue<Integer>((a, b) -> b - a); // store the duration
    // sort by deadline and then duration
    Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

    for (var cs : courses) {
      start += cs[0];
      if (start <= cs[1]) {
        count++;
        pq.offer(cs[0]);
      } else {
        if (!pq.isEmpty() && pq.peek() > cs[0]) {
          // remove the job with longest duration and add current one
          var duration = pq.poll();
          start -= duration;
          pq.offer(cs[0]);
        } else {
          // revert
          start -= cs[0];
        }
      }
    }

    return count;
  }

  private static int backtrack(int[][] courses, int start, boolean[] visited, Set<String> states) {
    var avail = availableCourses(courses, start, visited);
    if (avail.isEmpty()) {
      return 0;
    }
    var max = 0;
    // skip the states we already processed. Otherwise it will causes timeout !!
    var state = start + ":" + Arrays.toString(avail.toArray());
    if (!states.add(state)) {
      return 0;
    }
    for (int cs : avail) {
      var next = courses[cs];
      visited[cs] = true;
      max = Math.max(max, 1 + backtrack(courses, start + next[0], visited, states));
      visited[cs] = false;
    }
    return max;
  }

  private static List<Integer> availableCourses(int[][] courses, int start, boolean[] visited) {
    var avail = new ArrayList<Integer>();
    for (var i = 0; i < courses.length; i++) {
      if (!visited[i] && courses[i][0] + start <= courses[i][1]) {
        avail.add(i);
      }
    }
    return avail;
  }

  public static void main(String[] args) {
//    System.out.println(scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}}));
//    System.out.println(scheduleCourse(new int[][]{{1,2}}));
//    System.out.println(scheduleCourse(new int[][]{{3,2},{4,3}}));
    System.out.println(scheduleCourse(new int[][]{{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}}));
//    System.out.println(scheduleCourse(new int[][]{{2,5},{2,19},{1,8},{1,3}}));
//    System.out.println(scheduleCourse(new int[][]{{914,9927},{333,712},{163,5455},{835,5040},{905,8433},{417,8249},{921,9553},{913,7394},{303,7525},{582,8658},{86,957},{40,9152},{600,6941},{466,5775},{718,8485},{34,3903},{380,9996},{316,7755}}));
  }
}
