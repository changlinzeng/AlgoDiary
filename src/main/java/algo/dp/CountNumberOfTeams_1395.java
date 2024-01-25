package algo.dp;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfTeams_1395 {
    public static int numTeams(int[] rating) {
        var teams = new ArrayList<List<Integer>>();
        backtrack(rating, 0, new ArrayList<>(), teams);
        return teams.size();
    }

    private static void backtrack(int[] rating, int start, List<Integer> team, List<List<Integer>> teams) {
        if (team.size() == 3) {
            teams.add(new ArrayList<>(team));
            return;
        }
        for (var i = start; i < rating.length; i++) {
            var added = false;
            if (team.isEmpty()) {
                team.add(rating[i]);
                added = true;
            } else if (team.size() == 1 && rating[i] != team.get(0)) {
                team.add(rating[i]);
                added = true;
            } else if (team.size() == 2) {
                if (rating[i] > team.get(1) && team.get(1) > team.get(0)) {
                    team.add(rating[i]);
                    added = true;
                }
                if (rating[i] < team.get(1) && team.get(1) < team.get(0)) {
                    team.add(rating[i]);
                    added = true;
                }
            }
            if (added) {
                backtrack(rating, i + 1, team, teams);
                team.remove(team.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{2,5,3,4,1}));
        System.out.println(numTeams(new int[]{2,1,3}));
        System.out.println(numTeams(new int[]{1,2,3,4}));
    }
}
