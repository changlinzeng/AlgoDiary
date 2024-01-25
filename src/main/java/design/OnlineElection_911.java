package design;

import java.util.HashMap;

public class OnlineElection_911 {
    static class TopVotedCandidate {

        private final HashMap<Integer, Integer> top;

        private final int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            this.top = new HashMap<>();
            count(persons, times);
        }

        public int q(int t) {
//            var pos = 0;
//            while (pos < times.length && times[pos] <= t) {
//                pos++;
//            }
//            return top.get(pos - 1);

            int start = 0, end = times.length - 1;
            int pos = -1;
            if (t >= times[times.length -1]) {
                return top.get(times[times.length - 1]);
            }
            while (start < end) {
                var mid = start + (end - start) / 2;
                if (mid == start) {
                    if (times[end] == t) {
                        pos = end;
                        break;
                    }
                    pos = mid;
                    break;
                }
                if (times[mid] > t) {
                    end = mid;
                } else if (times[mid] < t) {
                    start = mid;
                } else {
                    pos = mid;
                    break;
                }
            }
            return top.get(times[pos]);

        }

        private void count(int[] persons, int[] times) {
            var votes = new HashMap<Integer, Integer>();
            for (var i = 0; i < persons.length; i++) {
                var currentPerson = persons[i];
                var now = times[i];
                votes.put(currentPerson, votes.getOrDefault(currentPerson, 0) + 1);

                // count top vote at each time
                var topVotes = 0;
                for (var entry : votes.entrySet()) {
                    if (entry.getValue() > topVotes) {
                        topVotes = entry.getValue();
                    }
                }
                if (votes.get(currentPerson) == topVotes) {
                    // current vote is the top or it makes a tie
                    top.put(now, currentPerson);
                } else if (votes.get(currentPerson) < topVotes) {
                    top.put(now, top.get(times[i - 1]));
                }
            }
            top.entrySet().forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
//        var vote = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        var vote = new TopVotedCandidate(new int[]{0,0,1,1,2}, new int[]{0,67,69,74,87});
    }
}
