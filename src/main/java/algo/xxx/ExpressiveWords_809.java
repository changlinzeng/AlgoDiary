package algo.xxx;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords_809 {
  public static int expressiveWords(String s, String[] words) {
    var count = 0;
    var seq = compress(s);
    for (var w : words) {
      if (s.length() < w.length()) {
        continue;
      }
      var ws = compress(w);
      if (compare(seq, ws)) {
        count++;
      }
    }

    return count;
  }

  private static List<int[]> compress(String s) {
    var result = new ArrayList<int[]>();
    for (var i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      if (result.isEmpty() || result.getLast()[0] != ch) {
        result.add(new int[]{ch, 1});
      } else if (result.getLast()[0] == ch) {
        result.getLast()[1]++;
      }
    }
    return result;
  }

  private static boolean compare(List<int[]> seq1, List<int[]> seq2) {
    int len1 = seq1.size(), len2 = seq2.size();
    if (len1 != len2) {
      return false;
    }
    for (var i = 0; i < len1; i++) {
      int[] c1 = seq1.get(i), c2 = seq2.get(i);
      if (c1[0] != c2[0]) {
        return false;
      }
      if (c1[1] == 2 && c2[1] != 2) {
        return false;
      }
      if (c1[1] < c2[1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    System.out.println(expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
  }
}
