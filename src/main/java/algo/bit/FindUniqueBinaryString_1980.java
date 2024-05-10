package algo.bit;

import java.util.HashSet;

public class FindUniqueBinaryString_1980 {
  public static String findDifferentBinaryString(String[] nums) {
    var uniq = new HashSet<Integer>();
    for (var num : nums) {
      uniq.add(strToBinary(num));
    }

    var missing = "";
    for (var i = 0; i < (1 << 17); i++) {
      if (!uniq.contains(i)) {
        missing = Integer.toBinaryString(i);
        break;
      }
    }

    var numLen = nums[0].length();
    if (numLen > missing.length()) {
      missing = "0".repeat(numLen - missing.length()) + missing;
    }
    return missing;
  }

  private static int strToBinary(String s) {
    var len = s.length();
    var num = 0;
    for (var i = len - 1; i >= 0; i--) {
      if (s.charAt(i) == '1') {
        num += (1 << (len - i - 1));
      }
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(findDifferentBinaryString(new String[]{"111","011","001"}));
  }

}
