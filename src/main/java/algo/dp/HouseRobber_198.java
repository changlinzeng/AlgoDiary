package algo.dp;

public class HouseRobber_198 {
  public static int rob(int[] nums) {
    // nums: 2      7      9        3        1
    //   dp: (2,0)  (2,7)  (11, 7)  ()  (11,11)
    var len = nums.length;
    if (len == 1) {
      return nums[0];
    }

    var dp = new int[len];
    dp[0] = nums[0];
    dp[1] = Math.max(dp[0], nums[1]);
    for (var i = 2; i < len; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[]{2,7,9,3,1}));
  }
}
