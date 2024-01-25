package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {
    public static List<String> restoreIpAddresses(String s) {
        var validAddresses = new ArrayList<String>();
//        backtrack(s, new ArrayList<>(), validAddresses);
        dfs(s, "", validAddresses);
        return validAddresses;
    }

    private static void backtrack(String s, List<String> segments, List<String> addresses) {
        if (s.isEmpty()) {
            if (segments.size() == 4) {
                addresses.add(String.join(".", segments));
            }
            return;
        }
        if (s.charAt(0) == '0') {
            segments.add("0");
            backtrack(s.substring(1), segments, addresses);
            segments.remove(segments.size() - 1);
        } else {
            var val = 0;
            for (var i = 0; i < s.length(); i++) {
                var ch = s.charAt(i);
                val = val * 10 + Integer.parseInt(ch + "");
                if (val > 0 && val < 256) {
                    // valid ip segment
                    var segment = String.valueOf(val);
                    segments.add(segment);
                    backtrack(s.substring(i + 1), segments, addresses);
                    segments.remove(segments.size() - 1);
                }
            }
        }
    }

    private static void dfs(String s, String addr, List<String> addresses) {
        if (addr.split("\\.").length == 4) {
            if (s.isEmpty()) {
                addresses.add(addr);
            }
            return;
        }
        if (s.isEmpty()) {
            return;
        }
        if (s.charAt(0) == '0') {
            // prevent leading zeros
            var newAddr = addr.isEmpty() ? "0" : addr + ".0";
            dfs(s.substring(1), newAddr, addresses);
        } else {
            var segment = "";
            for (var i = 0; i < 3 && i < s.length(); i++) {
                var d = s.charAt(i);
                segment += d;
                var newAddr = addr.isEmpty() ? segment : addr + "." + segment;
                if (segment.length() < 2) {
                    dfs(s.substring(segment.length()), newAddr, addresses);
                } else {
                    if (Integer.parseInt(segment) < 256) {
                        dfs(s.substring(segment.length()), newAddr, addresses);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        var addresses = restoreIpAddresses("25525511135");
//        var addresses = restoreIpAddresses("0000");
        var addresses = restoreIpAddresses("101023");
        addresses.forEach(System.out::println);
    }
}
