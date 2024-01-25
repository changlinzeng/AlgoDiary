package algo.sort;

public class SortColors_75 {
  public static void sortColors(int[] nums) {
    int len = nums.length;
    int zeroIndex = 0, oneIndex = 0;
    int val;

    for (int i = 0; i < len; i++) {
      val = nums[i];
      nums[i] = 2;
      if (val <= 1) {
        nums[oneIndex] = 1;
        oneIndex++;
      }
      if (val == 0) {
        nums[zeroIndex] = 0;
        zeroIndex++;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 2, 0, 1, 2};
    sortColors(nums);

    for (int i : nums) {
      System.out.println(i);
    }
  }
}
