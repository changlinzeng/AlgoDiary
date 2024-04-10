package algo.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CustomSortString_791 {
    public static String customSortString2(String order, String s) {
        var freq = new HashMap<String, Integer>();
        var remain = "";
        for (int i = 0; i < s.length(); i++) {
            var ch = String.valueOf(s.charAt(i));
            if (order.contains(ch)) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            } else {
                remain += ch;
            }
        }

        var sorted = "";
        for (int i = 0; i < order.length(); i++) {
            var ch = String.valueOf(order.charAt(i));
            if (s.contains(ch)) {
                sorted += ch.repeat(freq.get(ch));
            }
        }

        return sorted + remain;
    }

    public static String customSortString(String order, String s) {
        var priority = new HashMap<Character, Integer>();
        for (var i = 0; i < order.length(); i++) {
            priority.put(order.charAt(i), i);
        }

        var pq = new PriorityQueue<Character>(Comparator.comparingInt(a -> priority.getOrDefault(a, 100)));
        for (var i = 0; i < s.length(); i++) {
            pq.offer(s.charAt(i));
        }

        var result = "";
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("cbafg", "abcd"));
    }
}
