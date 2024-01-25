package algo.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_17 {
    private static final Map<Character, String> letterMap = new HashMap<>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public static List<String> letterCombinations(String digits) {
        var combinations = new ArrayList<String>();
        if (digits.isEmpty()) {
            return combinations;
        }
        backtrack(digits, "", combinations);
        return combinations;
    }

    private static void backtrack(String sub, String path, List<String> combinations) {
        var digit = sub.charAt(0);
        var letters = letterMap.get(digit);
        for (var j = 0; j < letters.length(); j++) {
            path += letters.charAt(j);
            if (sub.length() == 1) {
                combinations.add(path);
            } else {
                backtrack(sub.substring(1), path, combinations);
            }
            path = path.substring(0, path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
    }
}
