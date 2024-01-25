package algo.twoPointers;

import java.util.HashMap;

public class SwapForLongestRepeatedCharacterSubstring_1156 {
  public static int maxRepOpt1(String text) {
    // find the longest substring with exact two chars and one of them only counts 1
    int i = 0, j = 0, len = text.length();
    var maxlen = 0;
    var count = new HashMap<Character, Integer>();
    while (j < len) {
      var ch = text.charAt(j);
      count.put(ch, count.getOrDefault(ch, 0) + 1);
      if (count.keySet().size() == 1) {
        maxlen = Math.max(maxlen, count.values().stream().toList().get(0));
      } else if (count.keySet().size() == 2 && count.containsValue(1)) {
        // check if there is another char to swap
        var found = 0;
        var allOne = false;
        var vals = count.values().stream().sorted().toList();
        if (vals.get(0) == 1 && vals.get(1) == 1) {
          allOne = true;
        }
        for (var key : count.keySet()) {
          if (count.get(key) != 1 || allOne) {
            for (var k = 0; k < len; k++) {
              if ((k < i || k > j) && text.charAt(k) == key) {
                found = 1;
                break;
              }
            }
          }
        }
        maxlen = Math.max(maxlen, count.values().stream().sorted().toList().get(1) + found);
      } else {
        for (;;) {
          var cha = text.charAt(i);
          count.put(cha, count.get(cha) - 1);
          i++;
          if (count.get(cha) == 0) {
            count.remove(cha);
          }
          if (count.keySet().size() == 1 || count.keySet().size() == 2 && count.containsValue(1)) {
            maxlen = Math.max(maxlen, count.values().stream().sorted().toList().get(1));
            break;
          }
        }
      }
      j++;
    }

    return maxlen;
  }

  public static void main(String[] args) {
    System.out.println(maxRepOpt1("ababa"));
    System.out.println(maxRepOpt1("cabc"));
//    System.out.println(maxRepOpt1("aaabaaa"));
//    System.out.println(maxRepOpt1("aaaaa"));
//    System.out.println(maxRepOpt1("aabcc"));
//    System.out.println(maxRepOpt1("abcdef"));
//    System.out.println(maxRepOpt1("bbababaaaa"));
  }
}
