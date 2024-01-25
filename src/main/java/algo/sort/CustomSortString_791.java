package algo.sort;

import java.util.HashMap;

public class CustomSortString_791 {
    public static String customSortString(String order, String s) {
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

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("cbafg", "abcd"));
    }
}
