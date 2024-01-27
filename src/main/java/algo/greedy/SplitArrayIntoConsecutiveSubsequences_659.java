package algo.greedy;

import java.util.ArrayList;

public class SplitArrayIntoConsecutiveSubsequences_659 {
  public static boolean isPossible(int[] nums) {
    var len = nums.length;
    var color = 1;
    var shortSeq = new ArrayList<SeqInfo>();   // sequences whose len < 3
    var sequences = new ArrayList<SeqInfo>();  // sequences whose len >= 3
    shortSeq.add(new SeqInfo(1, 1, 0));
    for (var i = 1; i < len; i++) {
      if (nums[i] >= nums[i - 1] + 2) {
        color++;
        shortSeq.add(new SeqInfo(color, 1, i));
      } else {
        var found = false;

        // add to seq whose len < 3
        if (!shortSeq.isEmpty()) {
          for (var j = 0; j < shortSeq.size(); j++) {
            var candidate = shortSeq.get(j);
            if (nums[candidate.end] == nums[i] - 1) {
              found = true;
              candidate.len++;
              candidate.end = i;
              if (candidate.len == 3) {
                shortSeq.remove(j);
                sequences.add(candidate);
              }
              break;
            }
          }
        }

        // add to sequences whose len >= 3
        if (!found && !sequences.isEmpty()) {
          for (var candidate : sequences) {
            if (nums[candidate.end] == nums[i] - 1) {
              found = true;
              candidate.len++;
              candidate.end = i;
              break;
            }
          }
        }

        // create a new sequence
        if (!found) {
          color++;
          shortSeq.add(new SeqInfo(color, 1, i));
        }
      }
    }
    return shortSeq.isEmpty();
  }

  static class SeqInfo {
    public int color;
    public int len;
    public int end;
    public SeqInfo(int color, int len, int end) {
      this.color = color;
      this.len = len;
      this.end = end;
    }
  }

  public static void main(String[] args) {
    System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
    System.out.println(isPossible(new int[]{1,2,3,3,4,4,5,5}));
    System.out.println(isPossible(new int[]{1,2,3,4,4,5}));
    System.out.println(isPossible(new int[]{1,2,3,5,5,6,7}));
    System.out.println(isPossible(new int[]{4,5,6,7,7,8,8,9,10,11}));
    System.out.println(isPossible(new int[]{10,11,11,12,12,12,13,13,13,13,14}));
    System.out.println(isPossible(new int[]{1,2,3,4,5,5,6,7}));
  }
}
