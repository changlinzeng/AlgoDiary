package algo.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString_438 {

    public static List<Integer> findAnagrams(String s, String p) {
        var result = new ArrayList<Integer>();
        var window = p.length();

        if (s.length() < window) {
            return result;
        }

        var freq = new int[26];
        for (var c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        var count = new int[26];
        for (var i = 0; i < window; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (var i = 0; i <= s.length() - window; i++) {
            if (i > 0) {
                count[s.charAt(i - 1) - 'a']--;
                count[s.charAt(i + window - 1) - 'a']++;
            }
            if (match(count, freq)) {
                result.add(i);
                continue;
            }
        }

        return result;
    }

    private static boolean match(int[] count, int[] freq) {
        for (var i = 0; i < count.length; i++) {
            if (count[i] != freq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
