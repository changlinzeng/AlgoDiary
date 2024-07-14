package algo.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseWordsInAString_151 {
  public static String reverseWords(String s) {
//    var result = "";
//    var word = "";
//    for (var i = 0; i < s.length(); i++) {
//      var ch = s.charAt(i);
//      if (ch == ' ') {
//        if (!word.isEmpty()) {
//          if (!result.isEmpty()) {
//            result = " " + result;
//          }
//          result = word + result;
//          word = "";
//        }
//      } else {
//        word = word + ch;
//      }
//    }
//    if (!word.isEmpty()) {
//      if (!result.isEmpty()) {
//        result = " " + result;
//      }
//      result = word + result;
//    }
//    return result;

    var list = new ArrayList<>(Arrays.asList(s.trim().split(" +")));
    return String.join(" ", list.reversed());
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("the sky is blue"));
    System.out.println(reverseWords("  hello world  "));
  }
}
