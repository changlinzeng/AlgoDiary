package algo.sequence;

public class MinimumDominoRotationsForEqualRow_1007 {
  public static int minDominoRotations(int[] tops, int[] bottoms) {
    var r1 = rotate(tops, bottoms, tops[0]);
    var r2 = rotate(tops, bottoms, bottoms[0]);
    var r3 = rotate(bottoms, tops, tops[0]);
    var r4 = rotate(bottoms, tops, bottoms[0]);

    var count1 = 0;
    if (r1 != -1 && r2 != -1) {
      count1 = Math.min(r1, r2);
    } else if (r1 != -1) {
      count1 = r1;
    } else {
      count1 = r2;
    }

    var count2 = 0;
    if (r3 != -1 && r4 != -1) {
      count2 = Math.min(r3, r4);
    } else if (r1 != -1) {
      count2 = r3;
    } else {
      count2 = r4;
    }

    if (count1 != -1 && count2 != -1) {
      return Math.min(count1, count2);
    } else if (count1 != -1) {
      return count1;
    } else {
      return count2;
    }
  }

  private static int rotate(int[] tops, int[] bottoms, int target) {
    int count = 0;
    for (var i = 0; i < tops.length; i++) {
      // make top the same value
      if (tops[i] != target) {
        if (bottoms[i] == target) {
          count++;
        } else {
          return -1;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
  }
}
