package algo.sort;

import java.util.Arrays;

public class CheckIfAStringCanBreakAnotherString_1433 {
  public static boolean checkIfCanBreak(String s1, String s2) {
    var arr1 = s1.toCharArray();
    var arr2 = s2.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    // check if s1 breaks s2
    var breakit = true;
    for (var i = 0; i < arr1.length; i++) {
      if (arr1[i] < arr2[i]) {
        breakit = false;
        break;
      }
    }
    if (breakit) {
      return true;
    }

    // check if s2 breaks s1
    breakit = true;
    for (var i = 0; i < arr1.length; i++) {
      if (arr2[i] < arr1[i]) {
        breakit = false;
        break;
      }
    }
    return breakit;
  }

  public static void main(String[] args) {
    System.out.println(checkIfCanBreak("abc", "xya"));
    System.out.println(checkIfCanBreak("abe", "acd"));
    System.out.println(checkIfCanBreak("leetcode", "interview"));
  }
}
