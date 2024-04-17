package algo.sequence;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfMatchingSequences_792 {
    public static int numMatchingSubseq(String s, String[] words) {
        var wordCount = new HashMap<String, Integer>();
        Arrays.stream(words).forEach(w -> wordCount.put(w, wordCount.getOrDefault(w, 0) + 1));

        var num = 0;
        for (var w : wordCount.keySet()) {
            // check sequence
            if (w.length() <= s.length()) {
                int i = 0, j = 0;
                while (i < w.length() && j < s.length()) {
                    if (w.charAt(i) == s.charAt(j)) {
                        i++;
                    }
                    j++;
                }
                if (i == w.length()) {
                    num += wordCount.get(w);
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
        System.out.println(numMatchingSubseq("qlhxagxdqh", new String[]{"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"}));
    }
}
