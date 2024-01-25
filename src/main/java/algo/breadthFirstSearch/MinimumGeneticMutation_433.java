package algo.breadthFirstSearch;

import java.util.*;

public class MinimumGeneticMutation_433 {
  public static int minMutation(String startGene, String endGene, String[] bank) {
    if (startGene.equals(endGene)) {
      return 0;
    }
    var q = new ArrayDeque<String>();
    var visited = new HashSet<String>();
    var count = 0;
    q.offer(startGene);
    while (!q.isEmpty()) {
      count++;
      var size = q.size();
      var list = new ArrayList<String>();
      for (var i = 0; i < size; i++) {
        var g = q.poll();
        if (visited.add(g)) {
          var next = mutate(g, bank, visited);
          for (var n : next) {
            if (n.equals(endGene)) {
              return count;
            }
            list.add(n);
          }
        }
      }
      list.forEach(q::offer);
    }

    return -1;
  }

  private static List<String> mutate(String gene, String[] bank, Set<String> visited) {
    var next = new ArrayList<String>();
    for (var valid : bank) {
      if (!visited.contains(valid)) {
        var diff = 0;
        for (var i = 0; i < gene.length(); i++) {
          if (diff > 1) {
            break;
          }
          if (gene.charAt(i) != valid.charAt(i)) {
            diff++;
          }
        }
        if (diff == 1) {
          next.add(valid);
        }
      }
    }
    return next;
  }

  public static void main(String[] args) {
    System.out.println(minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
  }
}
