package algo.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching_1023 {
  public List<Boolean> camelMatch(String[] queries, String pattern) {
    var result = new ArrayList<Boolean>();
    for (var q : queries) {
      result.add(match(q, pattern));
    }
    return result;
  }

  private boolean match(String q, String p) {
    int i = 0, j = 0;
    int qlen = q.length(), plen = p.length();
    while (i < qlen && j < plen) {
      if (p.charAt(j) >= 'A' && p.charAt(j) <= 'Z') {
        // find next upper case
        while (i < qlen && q.charAt(i) >= 'a' && q.charAt(i) <= 'z') {
          i++;
        }
        if (i == qlen) {
          break;
        }
        if (q.charAt(i) != p.charAt(j)) {
          return false;
        }
        i++;
        j++;
      } else {
        if (q.charAt(i) >= 'A' && q.charAt(i) <= 'Z') {
          return false;
        }
        // match lower case
        if (q.charAt(i) == p.charAt(j)) {
          j++;
        }
        i++;
      }
    }
    while (i < qlen && q.charAt(i) >= 'a' && q.charAt(i) <= 'z') {
      i++;
    }
    return i == qlen && j == plen;
  }
}
