package algo.twoPointers;

public class RemoveDuplicatesFromSortedArray_II_80 {
  public static int removeDuplicates(int[] nums) {
    var len = nums.length;
    var newLen = len;
    int i = 0, j = 1;

    while (i < newLen) {
      // find duplicates from i to j (exclusive)
      while (j < newLen && nums[j] == nums[i]) {
        j++;
      }

      var dup = j - i;
      if (dup > 2) {
        var removal = dup - 2;
        // shift right by removal
        for (var m = i + 2; m + removal < len; m++) {
          nums[m] = nums[m + removal];
        }
        newLen -= removal;
        i += 2;
        j = i + 1;
      } else {
        i = j;
      }
    }

    return newLen;
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
