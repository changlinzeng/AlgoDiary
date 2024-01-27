package algo.dp;

public class WiggleSubsequence_376 {
  //           1  7  4  9  2  5
  //dp[i][0]   1  2  3  3  5  5
  //dp[i][1]   1  2  2  4  4  6
  public static int wiggleMaxLength(int[] nums) {
    var len = nums.length;
    if (len == 1) {
      return 1;
    }
    if (len == 2) {
      return nums[0] == nums[1] ? 1 : 2;
    }
    // max length at i.
    // dp[i][0] is the length of sequence with nums[i - 1] > nums[i - 2] and nums[i - 1] > nums[i]
    // dp[i][1] is the length of sequence with nums[i - 1] < nums[i - 2] and nums[i - 1] < nums[i]
    var dp = new int[len][2];
    dp[0] = new int[]{1, 1};
    if (nums[0] != nums[1]) {
      dp[1] = new int[]{2, 2};
    } else {
      dp[1] = new int[]{1, 1};
    }
    for (var i = 2; i < len; i++) {
      dp[i][0] = dp[i - 1][0];
      dp[i][1] = dp[i - 1][1];
      if (nums[i] < nums[i - 1] && nums[i - 2] <= nums[i - 1]) {
        dp[i][0] = dp[i - 1][1] + 1;
        dp[i][1] = dp[i - 1][1];
      }
      if (nums[i] > nums[i - 1] && nums[i - 2] >= nums[i - 1]) {
        dp[i][1] = dp[i - 1][0] + 1;
        dp[i][0] = dp[i - 1][0];
      }
    }

    return Math.max(dp[len - 1][0], dp[len - 1][1]);
  }

  public static void main(String[] args) {
    System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    System.out.println(wiggleMaxLength(new int[]{0,0,0}));
    System.out.println(wiggleMaxLength(new int[]{3,3,3,2,5}));
    System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
  }
}
