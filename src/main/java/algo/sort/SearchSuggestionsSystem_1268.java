package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, (a, b) -> compareString(a, b));

        var suggestion = new ArrayList<List<String>>();
        var filtered = List.of(products);
        for (var i = 0; i < searchWord.length(); i++) {
            filtered = filter(filtered, searchWord.charAt(i), i);
            suggestion.add(filtered);
        }
        for (var i = 0; i < suggestion.size(); i++) {
            if (suggestion.get(i).size() > 3) {
                suggestion.set(i, suggestion.get(i).subList(0, 3));
            }
        }
        return suggestion;
    }

    private static List<String> filter(List<String> products, char c, int pos) {
        var result = new ArrayList<String>();
        for (var p : products) {
            if (pos < p.length() && p.charAt(pos) == c) {
                result.add(p);
            }
        }
        return result;
    }

    private static int compareString(String s1, String s2) {
        var len1 = s1.length();
        var len2 = s2.length();
        for (var i = 0; i < Math.min(len1, len2); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return len1 - len2;
    }

    public static void main(String[] args) {
//        suggestedProducts(new String[]{"havana"}, "havana").forEach(System.out::println);
        suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse").forEach(System.out::println);
    }
}
