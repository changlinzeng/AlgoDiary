package algo.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        var combination = new ArrayList<Integer>();
        var comSum = new ArrayList<List<Integer>>();
        backtrack(candidates, target, comSum, combination);
        return comSum;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination) {
        for (var num : candidates) {
            var remain = target - num;
            if (remain >= 0) {
                combination.add(num);
                if (remain == 0) {
                    var contains = false;
                    for (var list : result) {
                        if (listEqual(list, combination)) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        result.add(new ArrayList<>(combination));
                    }
                } else {
                    backtrack(candidates, remain, result, combination);
                }
                combination.remove(combination.size() - 1);
            }
        }
    }

    private static boolean listEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        var count1 = new HashMap<Integer, Integer>();
        var count2 = new HashMap<Integer, Integer>();
        for (var num : list1) {
            count1.put(num, count1.getOrDefault(num, 0) + 1);
        }
        for (var num : list2) {
            count2.put(num, count2.getOrDefault(num, 0) + 1);
        }
        for (var key : count1.keySet()) {
            if (!count2.containsKey(key) || !Objects.equals(count2.get(key), count1.get(key))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
//        System.out.println(combinationSum(new int[]{2,3,5}, 8));
//        System.out.println(combinationSum(new int[]{2}, 1));
        System.out.println(combinationSum(new int[]{7,3,2}, 18));
    }
}
