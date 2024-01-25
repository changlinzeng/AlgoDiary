package algo.sort;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements_II_462 {
  public static int minMoves2(int[] nums) {
    var len = nums.length;
    Arrays.sort(nums);

    int target = nums[len / 2];

    int moves = 0;
    for (var n : nums) {
      moves += Math.abs(n - target);
    }

    return moves;
  }

  public static void main(String[] args) {
    System.out.println(minMoves2(new int[]{1,2,3}));
    System.out.println(minMoves2(new int[]{1,10,2,9}));
  }
}
