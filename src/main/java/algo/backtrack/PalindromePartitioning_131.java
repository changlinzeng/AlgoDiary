package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public static List<List<String>> partition(String s) {
        var partitions = new ArrayList<List<String>>();
        backtrack(s, new ArrayList<>(), partitions);
        return partitions;
    }

    private static void backtrack(String s, List<String> partition, List<List<String>> all) {
        if (s.isEmpty()) {
            all.add(new ArrayList<>(partition));
            return;
        }
        for (var i = 1; i <= s.length(); i++) {
            var sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                partition.add(sub);
                backtrack(s.substring(i), partition, all);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        partition("a").forEach(System.out::println);
        partition("aab").forEach(System.out::println);
    }
}
