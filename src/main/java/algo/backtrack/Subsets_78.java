package algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {
  public static List<List<Integer>> subsets(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    backtrack(nums, 0, result, new ArrayList<>());
    return result;
  }

  private static void backtrack(int[] nums, int start, List<List<Integer>> lists, List<Integer> list) {
    lists.add(new ArrayList<>(list));
    for (var i = start; i < nums.length; i++) {
      list.add(nums[i]);
      backtrack(nums, i + 1, lists, list);
      list.removeLast();
    }
    Arrays.sort(nums);
  }

  public static void main(String[] args) {
    subsets(new int[]{1,2}).forEach(System.out::println);
  }
}
