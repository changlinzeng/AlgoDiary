package algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        var subsets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] nums, int start, List<Integer> set, List<List<Integer>> subsets) {
        if (!subsets.contains(set)) {
            subsets.add(new ArrayList<>(set));
        }
        for (var i = start; i < nums.length; i++) {
            set.add(nums[i]);
            backtrack(nums, i + 1, set, subsets);
            set.remove(set.size() - 1);
        }
    }

    public static void main(String[] args) {
//        var subsets = subsetsWithDup(new int[]{1,2,3});
        var subsets = subsetsWithDup(new int[]{1,2,2});
        subsets.forEach(System.out::println);
    }
}
