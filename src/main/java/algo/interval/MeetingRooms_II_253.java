package algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms_II_253 {
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        var rooms = new ArrayList<List<int[]>>();
        var room = new ArrayList<int[]>();
        room.add(intervals[0]);
        rooms.add(room);

        int end = intervals[0][1];
        for (var i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                rooms.get(rooms.size() - 1).add(intervals[i]);
            } else {
                var findRoom = false;
                for (var r : rooms) {
                    if (intervals[i][0] >= r.get(r.size() - 1)[1]) {
                        r.add(intervals[i]);
                        findRoom = true;
                    }
                }
                if (!findRoom) {
                    var newRoom = new ArrayList<int[]>();
                    newRoom.add(intervals[i]);
                    rooms.add(newRoom);
                }
            }
            end = intervals[i][1];
        }

        return rooms.size();
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(minMeetingRooms(new int[][]{{2, 4}, {2, 4}}));
    }
}
