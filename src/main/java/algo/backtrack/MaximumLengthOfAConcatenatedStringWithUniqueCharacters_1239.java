package algo.backtrack;

import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_1239 {
  private static int maxlen = 0;
  public static int maxLength(List<String> arr) {
    var used = new boolean[26];
    backtrack(arr, 0, used);
    return maxlen;
  }

  private static void backtrack(List<String> arr, int start, boolean[] used) {
    if (start == arr.size()) {
      var count = 0;
      for (var c : used) {
        if (c) {
          count++;
        }
      }
      maxlen = Math.max(maxlen, count);
      return;
    }
    var str = arr.get(start);
    var canAdd = canAdd(str, used);
    if (canAdd) {
      for (var ch : str.toCharArray()) {
        used[ch - 'a'] = true;
      }
      backtrack(arr, start + 1, used);
      for (var ch : str.toCharArray()) {
        used[ch - 'a'] = false;
      }
      backtrack(arr, start + 1, used);
    } else {
      backtrack(arr, start + 1, used);
    }
  }

  private static boolean canAdd(String str, boolean[] used) {
    var charCount = new int[26];
    for (var ch : str.toCharArray()) {
      if (charCount[ch - 'a'] > 0) {
        return false;
      }
      charCount[ch - 'a']++;
      if (used[ch - 'a']) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println(maxLength(List.of("un", "iq", "ue")));
//    System.out.println(maxLength(List.of("cha","r","act","ers")));
//    System.out.println(maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));
    System.out.println(maxLength(List.of("aa", "bb")));
  }
}
