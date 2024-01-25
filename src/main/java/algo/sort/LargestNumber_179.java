package algo.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber_179 {
  public static String largestNumber(int[] nums) {
    var arr = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      arr[i] = Integer.valueOf(nums[i]);
    }
    Arrays.sort(arr, (n1, n2) -> compare(n1, n2));

    var largest = "";
    for (int i = arr.length - 1; i >= 0; i--) {
      largest += arr[i];
    }

    // remove leading zero
    int zero = 0;
    for (; zero < largest.length() && largest.charAt(zero) == '0'; zero++) {
    }
    if (zero == largest.length()) {
      return "0";
    }
    return largest.substring(zero);
  }

  private static int compare(int n1, int n2) {
    var s1 = String.valueOf(n1);
    var s2 = String.valueOf(n2);
    var num1 = s1 + s2;
    var num2 = s2 + s1;
    var result = Long.parseLong(num1) - Long.parseLong(num2);
    if (result == 0) {
      return 0;
    } else if (result > 0) {
      return 1;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new int[]{10,2}));
    System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    System.out.println(largestNumber(new int[]{111311, 1113}));
    System.out.println(largestNumber(new int[]{0, 0}));
  }
}
