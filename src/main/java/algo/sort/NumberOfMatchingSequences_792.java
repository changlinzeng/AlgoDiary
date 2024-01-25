package algo.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfMatchingSequences_792 {
    public static int numMatchingSubseq(String s, String[] words) {
        var bucket = new HashMap<Character, List<String>>();
        // put words in a bucket
        for (var word : words) {
            if (bucket.containsKey(word.charAt(0))) {
                bucket.get(word.charAt(0)).add(word);
            } else {
                var list = new ArrayList<String>();
                list.add(word);
                bucket.put(word.charAt(0), list);
            }
        }

        var result = 0;
        for (var i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (bucket.containsKey(ch)) {
                var ws = bucket.get(ch);
                 for (var w : ws) {
                     if (w.length() == 1) {
                         result++;
                     } else {
                         var newKey = w.charAt(1);
                         if (bucket.containsKey(newKey)) {
                             bucket.get(newKey).add(w.substring(1));
                         } else {
                             var list = new ArrayList<String>();
                             list.add(w.substring(1));
                             bucket.put(newKey, list);
                         }
                     }
                 }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }
}
