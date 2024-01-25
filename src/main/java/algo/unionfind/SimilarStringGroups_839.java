package algo.unionfind;

import java.util.HashSet;

public class SimilarStringGroups_839 {
  public static int numSimilarGroups(String[] strs) {
    var group = new int[strs.length];
    for (var i = 0; i < group.length; i++) {
      group[i] = i;
    }
    for (var i = 0; i < strs.length; i++) {
      for (var j = i + 1; j < strs.length; j++) {
        if (group[i] != group[j]) {
          if (isSimilar(strs[i], strs[j])) {
            var gid = group[j];
            for (var k = 0; k < strs.length; k++) {
              if (group[k] == gid) {
                group[k] = group[i];
              }
            }
          }
        }
      }
    }

    var set = new HashSet<Integer>();
    for (var g : group) {
      set.add(g);
    }
    return set.size();
  }

  private static boolean isSimilar(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int d1 = -1, d2 = -1;
    for (var i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (d1 == -1) {
          d1 = i;
        } else if (d2 == -1) {
          d2 = i;
        } else {
          return false;
        }
      }
    }
    return d1 == -1 || s1.charAt(d1) == s2.charAt(d2) && s1.charAt(d2) == s2.charAt(d1);
  }

  public static void main(String[] args) {
    System.out.println(numSimilarGroups(new String[]{"tars","rats","arts","star"}));
    System.out.println(numSimilarGroups(new String[]{"abc", "abc"}));
  }
}
