package algo.slidingWindow;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class SwapForLongestRepeatedCharacterSubstring_1156 {
  public static int maxRepOpt1_2(String text) {
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

  public static int maxRepOpt1(String text) {
    var position = new HashMap<Character, int[]>();  // first and last index of char
    for (var i = 0; i < text.length(); i++) {
      var idx = i;
      position.computeIfAbsent(text.charAt(i), key -> new int[]{idx, idx});
      position.get(text.charAt(i))[1] = i;
    }

    var indexMap = new HashMap<Character, Queue<Integer>>();  // indices of char
    var maxLen = 0;
    for (var i = 0; i < text.length(); i++) {
      var c = text.charAt(i);
      indexMap.computeIfAbsent(c, key -> new ArrayDeque<>());
      var q = indexMap.get(c);
      q.add(i);

      // make sure there is less than one other char between q.peek() and i for current char
      while (!q.isEmpty() && i - q.peek() > q.size()) {
        q.poll();
      }

      var len = q.size();

      // check if there is char outside of q.peek and i. if so, we can swap
      var pos = position.get(c);
      if (pos[0] < q.peek() || pos[1] > i) {
        len++;
      }
      maxLen = Math.max(maxLen, len);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(maxRepOpt1("ababa"));
    System.out.println(maxRepOpt1("cabc"));
    System.out.println(maxRepOpt1("aaabaaa"));
    System.out.println(maxRepOpt1("aaaaa"));
    System.out.println(maxRepOpt1("aabcc"));
    System.out.println(maxRepOpt1("abcdef"));
    System.out.println(maxRepOpt1("bbababaaaa"));
  }
}
