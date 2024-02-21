package algo.xxx;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence_128 {
  /**
   * For each number n in nums, if there is no n - 1, then it might be the start of the sequence.
   * We can find number from n + 1 till end in the set and see how many we can find
   */
  public static int longestConsecutive(int[] nums) {
    var longest = 0;
    var set = new HashSet<Integer>();
    Arrays.stream(nums).forEach(set::add);
    for (var n : nums) {
      if (!set.contains(n - 1)) {
        // n is the start
        var len = 1;
        for (var i = n + 1; set.contains(i); i++) {
          len++;
        }
        longest = Math.max(longest, len);
      }
    }
    return longest;
  }

  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
  }
}
