package algo.interval;

import java.util.*;

public class DivideIntervalsIntoMinimumNumberOfGroups_2406 {
    public static int minGroups(int[][] intervals) {
        var intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        var groups = new HashMap<Integer, int[]>();
        var pq = new PriorityQueue<Integer>(Comparator.comparingInt(a -> groups.get(a)[1]));

        groups.put(0, intervalList.get(0));
        pq.offer(0);

        var i = 1;
        while (i < intervalList.size()) {
            var g = pq.peek();
            var prev = groups.get(g);
            var findGroup = false;
            while (i < intervalList.size() && intervalList.get(i)[0] >= prev[1]) {
                findGroup = true;
                prev = intervalList.get(i);
                i++;
            }
            // create a new group
            if (findGroup) {
                pq.poll();
                groups.put(g, intervalList.get(i - 1));
                pq.offer(g);
            } else {
                groups.put(i, intervalList.get(i));
                pq.offer(i);
                i++;
            }
        }
        return pq.size();

//        var groups = new ArrayList<int[]>();
//        var i = 0;
//        while (i < intervalList.size()) {
//            var findGroup = false;
//            var j = 0;
//            var interval = intervalList.get(i);
//            while (j < groups.size()) {
//                if (groups.get(j)[1] <= interval[0]) {
//                    findGroup = true;
//                    break;
//                }
//                j++;
//            }
//            if (!findGroup) {
//                groups.add(interval);
//                j = groups.size() - 1;
//                i++;
//            }
//            while (i < intervalList.size()) {
//                if (intervalList.get(i)[0] < groups.get(j)[1]) {
//                    break;
//                }
//                groups.set(j, intervalList.get(i));
//                i++;
//            }
//        }
//
//        return groups.size();
    }

    public static void main(String[] args) {
        System.out.println(minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}}));
    }
}
