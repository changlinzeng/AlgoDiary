package algo.breadthFirstSearch;

import java.util.ArrayDeque;

public class IntegerReplacement_397 {
  public static int integerReplacement(int n) {
    int ops = 0;
    var q = new ArrayDeque<Long>();
    q.offer((long) n);
    while (!q.isEmpty()) {
      var size = q.size();
      for (var i = 0; i < size; i++) {
        var e = q.poll();
        if (e == 1) {
          return ops;
        }
        if (e % 2 == 0) {
          q.offer(e / 2);
        } else {
          q.offer(e + 1);
          if (e > 1) {
            q.offer(e - 1);
          }
        }
      }
      ops++;
    }

    return -1;
  }

  public static void main(String[] args) {
//    System.out.println(integerReplacement(8));
//    System.out.println(integerReplacement(7));
    System.out.println(integerReplacement(2147483647));
  }
}
