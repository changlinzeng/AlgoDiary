package algo.xxx;

import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork_826 {
  public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    var works = new Work[difficulty.length];
    for (int i = 0; i < difficulty.length; i++) {
      works[i] = new Work(difficulty[i], profit[i]);
    }

    Arrays.sort(works, Comparator.comparingInt(w -> w.difficulty));

    // calculate the most profit for difficulties
    var profitWorks = new ProfitWork[works.length];
    for (int i = 0; i < works.length; i++) {
      var prevMostProfit = i == 0 ? 0 : profitWorks[i - 1].profit;
      profitWorks[i] = new ProfitWork(works[i].difficulty, Math.max(works[i].profit, prevMostProfit));
    }

    var result = 0;
    for (var w : worker) {
      // find the most difficulty work for the worker
      var i = 0;
      for (; i < profitWorks.length && profitWorks[i].difficulty <= w; i++) {
      }
      if (i > 0) {
        result += profitWorks[i - 1].profit;
      }
    }

    return result;
  }

  private record Work(int difficulty, int profit) {}

  private record ProfitWork(int difficulty, int profit) {}

  public static void main(String[] args) {
    System.out.println(maxProfitAssignment(new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
    System.out.println(maxProfitAssignment(new int[]{85,47,57}, new int[]{24,66,99}, new int[]{40,25,25}));
  }

}
