package algo.twoPointers;

import java.util.Arrays;

public class ReverseWordsInAString_II_186 {
  public static void reverseEachWords(char[] str) {
    var len = str.length;
    reverse(str, 0, len - 1);

    int start = 0, end = 0;
    while (end < len) {
      if (str[end] == ' ') {
        reverse(str, start, end - 1);
        end++;
        start = end;
      }
      end++;
    }
    reverse(str, start, end - 1);
  }

  private static void reverse(char[] str, int start, int end) {
    while (start < end) {
      var tmp = str[start];
      str[start] = str[end];
      str[end] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    var str = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
    reverseEachWords(str);
    System.out.println(Arrays.toString(str));
  }
}
