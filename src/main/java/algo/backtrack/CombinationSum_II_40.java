package algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var combinations = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> combination,
                                  List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (var i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            // remove duplicates in [start+1, end]
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            var candidate = candidates[i];
            combination.add(candidate);
            target -= candidate;
            backtrack(candidates, target, i + 1, combination, combinations);
            combination.remove(combination.size() - 1);
            target += candidate;
        }
    }

    public static void main(String[] args) {
        var combinations = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        combinations.forEach(System.out::println);
    }
}
