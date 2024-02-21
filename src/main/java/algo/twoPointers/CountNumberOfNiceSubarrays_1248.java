package algo.twoPointers;

import java.util.ArrayList;

public class CountNumberOfNiceSubarrays_1248 {
  public static int numberOfSubarrays(int[] nums, int k) {
    var len = nums.length;
    var oddIndex = new ArrayList<Integer>();
    for (var i = 0; i < len; i++) {
      if (nums[i] % 2 == 1) {
        oddIndex.add(i);
      }
    }
    if (oddIndex.size() < k) {
      return 0;
    }

    var num = 0;
    for (var i = 0; i < oddIndex.size(); i++) {
      if (i + k - 1 >= oddIndex.size()) {
        break;
      }
      int from = oddIndex.get(i), to = oddIndex.get(i + k - 1);  // first odd and last odd
      int left = 0, right = 0;  // distance to prev and next odd
      while (from > 0) {
        from--;
        if (nums[from] % 2 == 1) {
          break;
        }
        left++;
      }
      while (to < len - 1) {
        to++;
        if (nums[to] % 2 == 1) {
          break;
        }
        right++;
      }
      num += (left + 1) * (right + 1);
    }

    return num;
  }

  public static void main(String[] args) {
    System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    System.out.println(numberOfSubarrays(new int[]{2,4,6}, 1));
    System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
  }
}
