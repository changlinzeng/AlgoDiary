package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations_67 {
  public static List<List<Integer>> permute(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> perm, boolean[] visited) {
    if (perm.size() == nums.length) {
      result.add(new ArrayList<>(perm));
    }
    for (var i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        perm.add(nums[i]);
        backtrack(nums, result, perm, visited);
        visited[i] = false;
        perm.remove(perm.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
//    permute(new int[]{1,2,3}).forEach(System.out::println);
    permute(new int[]{1,2,3,4,5,6,7,8,9}).forEach(System.out::println);
  }
}
