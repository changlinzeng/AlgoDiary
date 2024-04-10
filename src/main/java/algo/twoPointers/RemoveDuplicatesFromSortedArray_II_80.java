package algo.twoPointers;

public class RemoveDuplicatesFromSortedArray_II_80 {
  public static int removeDuplicates(int[] nums) {
    var maxDuplicates = 2;
    var end = 0;
    var count = 1;
    for (var i = 1; i <= nums.length; i++) {
      if (i == nums.length) {
        var repeats = Math.min(maxDuplicates, count);
        for (var k = 0; k < repeats; k++) {
          nums[end++] = nums[i - 1];
        }
        break;
      }
      if (nums[i] == nums[i - 1]) {
        count++;
      } else {
        // write elements to the end
        var repeats = Math.min(maxDuplicates, count);
        for (var k = 0; k < repeats; k++) {
          nums[end++] = nums[i - 1];
        }
        count = 1;
      }
    }
    return end;
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{1,1,1,2,2,3};
//    int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
    int[] nums = new int[]{-3,-1,-1,0,0,0,0,0,2};
    System.out.println(removeDuplicates(nums));
    for (var i : nums) {
      System.out.println(i);
    }
  }
}
