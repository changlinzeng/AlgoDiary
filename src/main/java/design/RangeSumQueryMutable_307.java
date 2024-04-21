package design;

public class RangeSumQueryMutable_307 {
  static class NumArray {

    private final int[] nums;
    private final int[] prefixSum;

    public NumArray(int[] nums) {
      this.nums = nums;
      prefixSum = new int[nums.length];
      for (var i = 0; i < nums.length; i++) {
        if (i == 0) {
          prefixSum[i] = nums[i];
        } else {
          prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
      }
    }

    public void update(int index, int val) {
      var oldVal = this.nums[index];
      this.nums[index] = val;
      // update prefix sum from index afterward
      for (var i = index; i < prefixSum.length; i++) {
        prefixSum[i] += val - oldVal;
      }
    }

    public int sumRange(int left, int right) {
      return prefixSum[right] - prefixSum[left] + this.nums[left];
    }
  }
}
