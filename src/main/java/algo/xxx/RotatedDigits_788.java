package algo.xxx;

import java.util.HashSet;
import java.util.Set;

public class RotatedDigits_788 {
  public int rotatedDigits(int n) {
    var count = 0;
    for (var i = 1; i <= n; i++) {
      count += isGood(i);
    }
    return count;
  }

  private int isGood(int num) {
    var set1 = Set.of('0', '1', '8');
    var set2 = Set.of('0', '1', '8', '2', '5', '6', '9');
    var set = new HashSet<Character>();
    for (var c : String.valueOf(num).toCharArray()) {
      set.add(c);
    }
    return set2.containsAll(set) && !set1.containsAll(set) ? 1 : 0;
  }
}
