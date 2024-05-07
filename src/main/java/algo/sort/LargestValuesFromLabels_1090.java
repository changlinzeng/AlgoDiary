package algo.sort;

import java.util.Arrays;
import java.util.HashMap;

public class LargestValuesFromLabels_1090 {
  public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
    var len = values.length;
    var labeledValues = new int[len][2];
    var used = new HashMap<Integer, Integer>();
    for (var i = 0; i < len; i++) {
      labeledValues[i] = new int[]{values[i], labels[i]};
      used.putIfAbsent(labels[i], 0);
    }
    Arrays.sort(labeledValues, (a, b) -> b[0] - a[0]);

    var score = 0;
    for (var val: labeledValues) {
      var label = val[1];
      if (used.get(label) < useLimit) {
        score += val[0];
        numWanted--;
        used.put(label, used.get(label) + 1);
        if (numWanted == 0) {
          break;
        }
      }
    }
    return score;
  }

  public static void main(String[] args) {
    System.out.println(largestValsFromLabels(new int[]{5,4,3,2,1}, new int[]{1,1,2,2,3}, 3, 1));
    System.out.println(largestValsFromLabels(new int[]{5,4,3,2,1}, new int[]{1,3,3,3,2}, 3, 2));
  }
}
