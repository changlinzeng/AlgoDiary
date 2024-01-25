package algo.sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SplitArrayIntoConsecutiveSubsequences_659 {
  public static boolean isPossible(int[] nums) {
    var len = nums.length;
    var color = 1;
    var seq = new HashMap<Integer, Integer>();  // {color: len of subseq}
    var dp = new int[len];
    dp[0] = 1;
    seq.put(1, 1);
    for (var i = 1; i < len; i++) {
      if (nums[i] == nums[i - 1] + 1) {
        // find the sub seq with len < 3
        int k;
        var found = false;
        for (k = i - 1; k >= 0; k--) {
          if (nums[k] == nums[i] - 1 && seq.get(dp[k]) < 3) {
            found = true;
            dp[i] = dp[k];
            seq.put(dp[i], seq.get(dp[i]) + 1);
            break;
          }
        }
        // if all sub seq are longer than 3, then append to prev one
        if (!found) {
          dp[i] = dp[i - 1];
          seq.put(dp[i], seq.get(dp[i]) + 1);
        }
      } else if (nums[i] == nums[i - 1]) {
        var excludedColors = new HashSet<Integer>();
        int k;
        var found = false;
        for (k = i - 1; k >= 0; k--) {
          if (nums[k] == nums[i]) {
            excludedColors.add(dp[k]);
          } else if (nums[k] == nums[i] - 1 && !excludedColors.contains(dp[k])) {
            if (seq.get(dp[k]) < 3) {
              found = true;
              dp[i] = dp[k];
              seq.put(dp[i], seq.get(dp[i]) + 1);
              break;
            }
          }
        }
        if (!found) {
          // no seq found with len < 3 then append to last one
          for (k = i - 1; k >= 0; k--) {
            if (nums[k] == nums[i] - 1 && !excludedColors.contains(dp[k])) {
              found = true;
              dp[i] = dp[k];
              seq.put(dp[i], seq.get(dp[i]) + 1);
              break;
            }
          }
        }
        if (!found) {
          // no seq found, create a new sub seq
          color++;
          dp[i] = color;
          seq.put(color, 1);
        }
      } else {
        color++;
        dp[i] = color;
        seq.put(color, 1);
      }
    }

    for (var v : seq.values()) {
      if (v < 3) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPossible2(int[] nums) {
    int len = nums.length, minLen = 3;
    var seq = new HashMap<Integer, Integer>();   // end of each sub seq and count
    var freq = new HashMap<Integer, Integer>();
    for (var n : nums) {
      freq.put(n, freq.getOrDefault(n, 0) + 1);
    }

    Arrays.sort(nums);
    for (var n : nums) {
      if (freq.get(n) > 0) {
        int end = n, i;
        for (i = 0; i < minLen; i++) {
          end = n + i;
          if (!freq.containsKey(end) || freq.get(end) == 0) {
            break;
          }
          freq.put(end, freq.get(end) - 1);
        }
        if (i == minLen) {
          seq.put(end, seq.getOrDefault(end, 0) + 1);
        } else {
          // seq len < 3, append it to prev seq
          if (!seq.containsKey(n - 1)) {
            return false;
          }
          seq.put(end, 1);
          seq.put(n - 1, seq.get(n - 1) - 1);
          if (seq.get(n - 1) == 0) {
            seq.remove(n - 1);
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
//    System.out.println(isPossible(new int[]{1,2,3,3,4,4,5,5}));
//    System.out.println(isPossible(new int[]{1,2,3,4,4,5}));
//    System.out.println(isPossible(new int[]{1,2,3,5,5,6,7}));
//    System.out.println(isPossible(new int[]{4,5,6,7,7,8,8,9,10,11}));
//    System.out.println(isPossible(new int[]{10,11,11,12,12,12,13,13,13,13,14}));
    System.out.println(isPossible(new int[]{1,2,3,4,5,5,6,7}));
  }
}
