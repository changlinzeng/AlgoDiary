package algo.backtrack;

import java.util.*;

public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        var combination = new ArrayList<Integer>();
        var comSum = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, comSum, combination);
        return comSum;
    }

    private static void backtrack(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> combination) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (var i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                combination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, result, combination);
                combination.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum(new int[]{2}, 1));
        System.out.println(combinationSum(new int[]{7,3,2}, 18));
    }
}
