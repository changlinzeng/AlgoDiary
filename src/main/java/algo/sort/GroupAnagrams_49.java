package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        var bucket = new HashMap<String, List<String>>();
        for (var str : strs) {
            var arr = str.toCharArray();
            Arrays.sort(arr);
            var key = new String(arr);
            if (!bucket.containsKey(key)) {
                var list = new ArrayList<String>();
                list.add(str);
                bucket.put(key, list);
            } else {
                bucket.get(key).add(str);
            }
        }

        return new ArrayList<>(bucket.values());
    }

    public static void main(String[] args) {
//        var anagrams = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        var anagrams = groupAnagrams(new String[]{});
//        var anagrams = groupAnagrams(new String[]{"a"});
        anagrams.forEach(System.out::println);
    }
}
