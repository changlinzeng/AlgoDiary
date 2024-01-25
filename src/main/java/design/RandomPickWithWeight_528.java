package design;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight_528 {
  static class Solution {

    private final Map<Integer, int[]> bucket;
    private int total = 0;

    public Solution(int[] w) {
      bucket = new TreeMap<>();
      var m = 0;
      for (var i = 0; i < w.length; i++) {
        total += w[i];
        bucket.put(i, new int[]{m, m + w[i]});
        m = m + w[i];
      }
    }

    public int pickIndex() {
      var rand = new Random();
      var r = rand.nextInt(total);
      for (var entry : bucket.entrySet()) {
        if (r >= entry.getValue()[0] && r < entry.getValue()[1]) {
          return entry.getKey();
        }
      }
      return -1;
    }
  }

  public static void main(String[] args) {
    var rand = new RandomPickWithWeight_528.Solution(new int[]{1,3});
    rand.pickIndex();
  }
}
