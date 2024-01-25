package algo.xxx;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_442 {
  public static List<Integer> findDuplicates(int[] nums) {
    // reverse the element in position nums[i] - 1 and if we find the element
    // in the position is already reversed, then nums[i] is duplicate
    var result = new ArrayList<Integer>();
    for (var i = 0; i < nums.length; i++) {
      var idx = Math.abs(nums[i]) - 1;
      if (nums[idx] < 0) {
        result.add(Math.abs(nums[i]));
      } else {
        nums[idx] = -1 * nums[idx];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    findDuplicates(new int[]{4,3,2,7,8,2,3,1}).forEach(System.out::println);
  }
}
