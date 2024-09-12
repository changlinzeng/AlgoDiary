package algo.breadthFirstSearch;

import java.util.*;

public class OpenTheLock_752 {
  public static int openLock(String[] deadends, String target) {
    var start = "0000";
    var rounds = 0;
    var dead = new HashSet<>(Arrays.asList(deadends));
    var visited = new HashSet<String>();

    if (dead.contains(start)) {
      return -1;
    }

    var q = new ArrayDeque<String>();
    q.offer(start);
    while (!q.isEmpty()) {
      var size = q.size();
      var list = new ArrayList<String>();
      for (var i = 0; i < size; i++) {
        var next = q.poll();
        if (target.equals(next)) {
          return rounds;
        }
        if (!visited.add(next)) {
          continue;
        }
        list.addAll(getNext(next, dead));
      }
      list.forEach(q::offer);
      rounds++;
    }
    return -1;
  }

  private static List<String> getNext(String s, Set<String> dead) {
    var result = new ArrayList<String>();
    for (var i = 0; i < s.length(); i++) {
      String res1 = "", res2 = "";
      for (var j = 0; j < s.length(); j++) {
        if (j == i) {
          var c1 = s.charAt(i) == '9' ? '0' : (char)(s.charAt(i) + 1);
          var c2 = s.charAt(i) == '0' ? '9' : (char)(s.charAt(i) - 1);
          res1 += c1;
          res2 += c2;
        } else {
          res1 += s.charAt(j);
          res2 += s.charAt(j);
        }
      }
      for (var res : new String[]{res1, res2}) {
        if (!dead.contains(res)) {
          result.add(res);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    System.out.println(openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
  }
}
