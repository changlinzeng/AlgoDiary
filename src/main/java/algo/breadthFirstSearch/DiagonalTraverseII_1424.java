package algo.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverseII_1424 {
  public static int[] findDiagonalOrder(List<List<Integer>> nums) {
    var rows = nums.size();
    var result = new ArrayList<Integer>();
    var visited = new ArrayList<boolean[]>();
    for (List<Integer> num : nums) {
      visited.add(new boolean[num.size()]);
    }

    var q = new ArrayDeque<int[]>();
    q.offer(new int[]{0, 0});
    while (!q.isEmpty()) {
      var cell = q.poll();
      int row = cell[0], col = cell[1];
      if (visited.get(row)[col]) {
        continue;
      }
      visited.get(row)[col] = true;
      result.add(nums.get(row).get(col));
      if (row + 1 < rows && col < nums.get(row + 1).size()) {
        q.offer(new int[]{row + 1, col});
      }
      if (col + 1 < nums.get(row).size()) {
        q.offer(new int[]{row, col + 1});
      }
    }

    var arr = new int[result.size()];
    for (var i = 0; i < result.size(); i++) {
      arr[i] = result.get(i);
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(findDiagonalOrder(List.of(List.of(1, 2, 3, 4, 5), List.of(6, 7), List.of(8)))));
  }
}
