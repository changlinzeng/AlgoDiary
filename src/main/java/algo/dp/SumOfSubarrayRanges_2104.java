package algo.dp;

public class SumOfSubarrayRanges_2104 {
  public static long subArrayRanges(int[] nums) {
    var len = nums.length;
    long sum = 0;
    var dp = new int[len][2];  // index of min and max before i
    dp[0] = new int[]{0, 0};
    for (var i = 1; i < len; i++) {
      int max = dp[i - 1][1], min = dp[i - 1][0];
      max = nums[i] >= nums[max] ? i : max;
      min = nums[i] <= nums[min] ? i : min;
      dp[i] = new int[]{min, max};

      // sum the range
      var minIndex = Math.min(max, min);
      // subarrays [0, i], [1, i] ... [minIndex, i] include min and max
      sum += (long) (minIndex + 1) * (nums[max] - nums[min]);

      // calculate range sum from minIndex + 1 to i
      int mini = i, maxi = i;
      for (var j = i - 1; j > minIndex; j--) {
        if (nums[j] < nums[mini]) {
          mini = j;
        }
        if (nums[j] > nums[maxi]) {
          maxi = j;
        }
        sum += nums[maxi] - nums[mini];
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(subArrayRanges(new int[]{1,2,3}));
    System.out.println(subArrayRanges(new int[]{1,3,3}));
    System.out.println(subArrayRanges(new int[]{4,-2,-3,4,1}));
  }
}
