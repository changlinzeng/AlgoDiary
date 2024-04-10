package algo.sort;

import java.util.HashMap;
import java.util.PriorityQueue;

public class RankTeamsByVotes_1366 {
    public static String rankTeams(String[] votes) {
        var numTeams = votes[0].length();
        var count = new HashMap<String, int[]>();
        var pq = new PriorityQueue<Character>((a, b) -> {
            var va = count.get(a + "");
            var vb = count.get(b + "");
            for (var i = 0; i < numTeams; i++) {
                if (va[i] > vb[i]) {
                    return -1;
                } else if (va[i] < vb[i]) {
                    return 1;
                }
            }
            return a - b;
        });
        for (var v : votes) {
            for (var i = 0; i < numTeams; i++) {
                var team = v.charAt(i) + "";
                if (count.containsKey(team)) {
                    count.get(team)[i]++;
                } else {
                    var numVote = new int[numTeams];
                    numVote[i]++;
                    count.put(team, numVote);
                }
            }
        }
        for (var key : count.keySet()) {
            pq.offer(key.charAt(0));
        }

        var result = "";
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(rankTeams(new String[]{"WXYZ", "XYZW"}));
        System.out.println(rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"}));
    }
}
