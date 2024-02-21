package algo.interval;

import java.util.*;

public class DivideIntervalsIntoMinimumNumberOfGroups_2406 {
    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // important: sort by interval end
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
        for (var interval : intervals) {
            if (!pq.isEmpty() && pq.peek()[1] < interval[0]) {
                pq.poll();
            }
            pq.offer(interval);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        System.out.println(minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}}));
        System.out.println(minGroups(new int[][]{{1,3},{5,6},{8,10},{11,13}}));
    }
}
