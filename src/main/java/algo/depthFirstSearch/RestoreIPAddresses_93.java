package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {
    public static List<String> restoreIpAddresses(String s) {
        var validAddresses = new ArrayList<String>();
        backtrack(s, 0, new ArrayList<>(), validAddresses);
        return validAddresses;
    }

    private static void backtrack(String s, int start, List<String> segments, List<String> addresses) {
        if (segments.size() > 4) {
            return;
        }
        if (start == s.length()) {
            if (segments.size() == 4) {
                addresses.add(String.join(".", segments));
            }
            return;
        }
        var part = "";
        for (var i = start; i < s.length(); i++) {
            part += s.charAt(i);
            if (part.equals("0")) {
                segments.add(part);
                backtrack(s, i + 1, segments, addresses);
                segments.removeLast();
                break;
            }
            if (Integer.parseInt(part) > 255) {
                break;
            }
            segments.add(part);
            backtrack(s, i + 1, segments, addresses);
            segments.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));
    }
}
