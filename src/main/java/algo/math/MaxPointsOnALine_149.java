package algo.math;

public class MaxPointsOnALine_149 {
  public static int maxPoints(int[][] points) {
    int len = points.length, max = 0;
    if (len < 2) {
      return len;
    }
    for (var i = 0; i < len; i++) {
      for (var j = i + 1; j < len; j++) {
        var tmp = 2;
        int x1 = points[i][0], x2 = points[j][0], y1 = points[i][1], y2 = points[j][1];
        for (var k = 0; k < len; k++) {
          if (k != i && k != j) {
            int x3 = points[k][0], y3 = points[k][1];
            // (y2 - y1) / (x2 - x1) == (y3 - y2) / (x3 - x2) =>
            // (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)
            if ((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)) {
              tmp++;
            }
          }
        }
        max = Math.max(tmp, max);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
  }
}
