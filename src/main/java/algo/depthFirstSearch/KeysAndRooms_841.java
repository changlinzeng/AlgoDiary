package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms_841 {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var len = rooms.size();
        var visited = new boolean[len];

        visitRooms(rooms, 0, visited);

        for (var v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private static void visitRooms(List<List<Integer>> rooms, int id, boolean[] visited) {
        if (visited[id]) {
            return;
        }
        visited[id] = true;
        for (var key : rooms.get(id)) {
            visitRooms(rooms, key, visited);
        }
    }

    public static void main(String[] args) {
        var rooms = new ArrayList<List<Integer>>();
        var room1 = new ArrayList<Integer>();
        room1.add(1);
        var room2 = new ArrayList<Integer>();
        room2.add(2);
        var room3 = new ArrayList<Integer>();
        room3.add(3);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));
    }
}
