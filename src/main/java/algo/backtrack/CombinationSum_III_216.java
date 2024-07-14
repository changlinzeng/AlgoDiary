package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_III_216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        var combinations = new ArrayList<List<Integer>>();
        backtrack(k, n, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void backtrack(int k, int n, int start, List<Integer> combination, List<List<Integer>> all) {
        if (k == 0 && n == 0) {
            all.add(new ArrayList<>(combination));
            return;
        }
        for (var i = start; i <= 9; i++) {
            if (n < i) {
                break;
            }
            combination.add(i);
            backtrack(k - 1, n - i, i + 1, combination, all);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 7).forEach(System.out::println);
    }
}
