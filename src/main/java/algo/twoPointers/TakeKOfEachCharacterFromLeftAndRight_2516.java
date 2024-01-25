package algo.twoPointers;

import java.util.HashMap;

public class TakeKOfEachCharacterFromLeftAndRight_2516 {
    public static int takeCharacters(String s, int k) {
        // it actually is the problem of the longest window which contains at most k occurences of each character
        var freq = new int[3];
        var total = 0;
        for (var i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        for (var i = 0; i < 3; i++) {
            freq[i] -= k;
            if (freq[i] < 0) {
                return -1;
            }
            total += freq[i];
        }

        if (total == 0) {
            return s.length();
        }

        var count = 0;
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            var ch = s.charAt(j);
            if (count < total && freq[ch - 'a'] > 0) {
                freq[ch - 'a']--;
                count++;
                j++;
                max = Math.max(max, j - i);
            } else {
                for(; s.charAt(i) != ch; i++) {
                    count--;
                    freq[s.charAt(i) - 'a']++;
                }
                if (i == j) {
                    i++;
                    j++;
                } else {
                    count--;
                    freq[s.charAt(i) - 'a']++;
                    i++;
                }
            }
        }

        return s.length() - max;
    }

    public static void main(String[] args) {
//        System.out.println(takeCharacters("aabaaaacaabc", 2));
//        System.out.println(takeCharacters("a", 1));
        System.out.println(takeCharacters("abc", 1));
    }
}
