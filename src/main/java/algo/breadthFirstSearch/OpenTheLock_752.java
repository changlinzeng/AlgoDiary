package algo.breadthFirstSearch;

import java.util.*;

public class OpenTheLock_752 {
  public static int openLock(String[] deadends, String target) {
    if ("0000".equals(target)) {
      return 0;
    }

    var rounds = 1;
    var dead = new HashSet<>(Arrays.asList(deadends));
    var visited = new HashSet<String>();
    var q = new ArrayDeque<String>();
    q.offer("0000");
    while (!q.isEmpty()) {
      var size = q.size();
      for (var i = 0; i < size; i++) {
        var next = q.poll();
        if (dead.contains(next)) {
          continue;
        }
        if (!visited.add(next)) {
          continue;
        }
        var result = new ArrayList<String>();
        if (getNext(next, dead, target, result)) {
          return rounds;
        } else {
          result.forEach(q::offer);
        }
      }
      rounds++;
    }
    return -1;
  }

  private static boolean getNext(String s, Set<String> dead, String target, List<String> result) {
    var found = false;
    for (var i = 0; i < 4; i++) {
      var ch = s.charAt(i);
      var n1 = replace(s, i, ch == '9' ? '0' : (char)(ch + 1));
      var n2 = replace(s, i,  ch == '0' ? '9' : (char)(ch - 1));
      if (!dead.contains(n1)) {
        if (target.equals(n1)) {
          found = true;
        }
        result.add(n1);
      }
      if (!dead.contains(n2)) {
        if (target.equals(n2)) {
          found = true;
        }
        result.add(n2);
      }
    }
    return found;
  }

  private static String replace(String s, int index, char c) {
    var r = "";
    for (var i = 0; i < s.length(); i++) {
      if (i != index) {
        r += s.charAt(i);
      } else {
        r += c;
      }
    }
    return r;
  }

  public static void main(String[] args) {
    System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    System.out.println(openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
  }
}
