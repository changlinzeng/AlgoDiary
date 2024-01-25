package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_III_216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        var combinations = new ArrayList<List<Integer>>();
        var usage = new boolean[9];
        backtrack(k, n, 1, usage, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void backtrack(int k, int n, int start, boolean[] usage, List<Integer> combination,
                                  List<List<Integer>> all) {
        if (k == 0 && n == 0) {
            all.add(new ArrayList<>(combination));
            return;
        }
        for (var i = start; i <= 9; i++) {
            if (!usage[i - 1] && i <= n) {
                combination.add(i);
                usage[i - 1] = true;
                backtrack(k - 1, n - i, i + 1, usage, combination, all);
                combination.remove(combination.size() - 1);
                usage[i - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 7).forEach(System.out::println);
    }
}
