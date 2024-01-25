package algo.dp;

public class JumpGame_II_45 {
  public static int jump(int[] nums) {
    var len = nums.length;
    var dp = new int[len];
    for (var i = 0; i < len - 1; i++) {
      for (var j = i + 1; j < len && j <= i + nums[i]; j++) {
        if (dp[j] == 0) {
          dp[j] = dp[i] + 1;
        } else {
          dp[j] = Math.min(dp[i] + 1, dp[j]);
        }
      }
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
//    System.out.println(jump(new int[]{2,3,1,1,4}));
//    System.out.println(jump(new int[]{2,3,0,1,4}));
    System.out.println(jump(new int[]{2,1}));
  }
}
