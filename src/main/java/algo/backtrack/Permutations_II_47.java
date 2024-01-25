package algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        var permutations = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
//        backtrack(nums, new ArrayList<>(), permutations);
        backtrack2(nums, new ArrayList<>(), permutations, new boolean[nums.length]);
        return permutations;
    }

    public static void backtrack(int[] nums, List<Integer> perm, List<List<Integer>> permutations) {
        if (nums.length == 0) {
            permutations.add(new ArrayList<>(perm));
        }
        for (var i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            perm.add(nums[i]);
            var subnums = new int[nums.length - 1];
            for (var j = 0; j < nums.length; j++) {
                if (j < i) {
                    subnums[j] = nums[j];
                } else if (j > i) {
                    subnums[j - 1] = nums[j];
                }
            }
            backtrack(subnums, perm, permutations);
            perm.remove(perm.size() - 1);
        }
    }

    public static void backtrack2(int[] nums, List<Integer> perm, List<List<Integer>> permutations, boolean[] visited) {
        if (perm.size() == nums.length) {
            permutations.add(new ArrayList<>(perm));
            return;
        }
        for (var i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // skip current duplicate if previous is not picked up as we backtrack one by one
            // only the previous is picked up, we can backtrack current one
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            perm.add(nums[i]);
            backtrack2(nums, perm, permutations, visited);
            visited[i] = false;
            perm.removeLast();
        }
    }

    public static void main(String[] args) {
//        var result = permuteUnique(new int[]{1,1,2});
        var result = permuteUnique(new int[]{1,1,1,2});
//        var result = permuteUnique(new int[]{1,2,3});
        result.forEach(System.out::println);
    }
}
