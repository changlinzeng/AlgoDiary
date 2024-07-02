package design;

import java.util.Random;

public class RandomPickWithWeight_528 {
  static class Solution {

    private final int[] weight;

    public Solution(int[] w) {
      weight = new int[w.length + 1];
      weight[0] = 0;
      // calculate the prefix sum and the diff between two sums are the probability
      for (var i = 0; i < w.length; i++) {
        weight[i + 1] = w[i] + weight[i];
      }
    }

    public int pickIndex() {
      var rand = new Random().nextInt(weight[weight.length - 1]);
      for (var i = 0; i < weight.length - 1; i++) {
        if (rand >= weight[i] && rand < weight[i + 1]) {
          return i;
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
