package algo.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences_491 {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        var sequences = new HashSet<List<Integer>>();
        backtrack(nums, 0, new ArrayList<>(), sequences);
        return sequences.stream().toList();
    }

    private static void backtrack(int[] nums, int start, List<Integer> sub, Set<List<Integer>> all) {
        if (sub.size() > 1) {
              all.add(new ArrayList<>(sub));
        }
        for (var i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (sub.isEmpty() || sub.getLast() <= nums[i]) {
                sub.add(nums[i]);
                backtrack(nums, i + 1, sub, all);
                sub.remove(sub.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        var seq = findSubsequences(new int[]{4,6,7,7});
//        var seq = findSubsequences(new int[]{4,4,3,2,1});
//        var seq = findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        var seq = findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});
        seq.forEach(System.out::println);
    }
}
