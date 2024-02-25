package algo.sequence;

public class NonDecreasingArray_665 {
  public static boolean checkPossibility(int[] nums) {
    var len = nums.length;
    var count = 0;
    for (var i = 0; i < len - 1; i++) {
      if (count > 1) {
        return false;
      }
      if (nums[i] > nums[i + 1]) {
        count++;
        // either change i + 1 to i to change i to i + 1
        if (i > 0) {
          if (nums[i + 1] >= nums[i - 1]) {
            nums[i] = nums[i + 1];
          } else {
            nums[i + 1] = nums[i];
          }
        }
      }
    }

    return count <= 1;
  }

  public static void main(String[] args) {
    System.out.println(checkPossibility(new int[]{4,2,3}));
    System.out.println(checkPossibility(new int[]{4,2,1}));
  }
}
