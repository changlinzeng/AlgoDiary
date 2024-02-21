package algo.prefixSum;

public class BinarySubarraysWithSum_930 {
  public static int numSubarraysWithSum(int[] nums, int goal) {
    var len = nums.length;
    var sum = new int[len + 1];
    for (var i = 0; i < len; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }

    var count = 0;
    for (var i = 0; i <= len; i++) {
      for (var j = i + 1; j <= len; j++) {
        if (sum[j] - sum[i] == goal) {
          count++;
        } else if (sum[j] - sum[i] > goal) {
          break;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
  }
}
