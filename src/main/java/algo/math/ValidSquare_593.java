package algo.math;

import java.util.ArrayList;
import java.util.List;

public class ValidSquare_593 {
  public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    var points = new ArrayList<>(List.of(p1, p2, p3, p4));
    points.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    var pt1 = points.get(0);
    var pt2 = points.get(1);
    var pt3 = points.get(2);
    var pt4 = points.get(3);

    // make sure there are no two points are the same
    if (pt2[0] - pt1[0] == 0 && pt2[1] - pt1[1] == 0
            || pt3[0] - pt1[0] == 0 && pt3[1] - pt1[1] == 0
            || pt4[0] - pt2[0] == 0 && pt4[1] - pt2[1] == 0
            || pt4[0] - pt3[0] == 0 && pt4[1] - pt3[1] == 0) {
      return false;
    }

    // edge [pt1, pt2] and [pt1, pt3] should ave the same length
    if ((pt2[0] - pt1[0]) * (pt2[0] - pt1[0]) + (pt2[1] - pt1[1]) * (pt2[1] - pt1[1])
            != (pt3[0] - pt1[0]) * (pt3[0] - pt1[0]) + (pt3[1] - pt1[1]) * (pt3[1] - pt1[1])) {
      return false;
    }
    if (2 * ((pt2[0] - pt1[0]) * (pt2[0] - pt1[0]) + (pt2[1] - pt1[1]) * (pt2[1] - pt1[1]))
            != (pt3[0] - pt2[0]) * (pt3[0] - pt2[0]) + (pt3[1] - pt2[1]) * (pt3[1] - pt2[1])) {
      return false;
    }

    // edge [pt4, pt2] and [pt4, pt3] should ave the same length
    if ((pt4[0] - pt2[0]) * (pt4[0] - pt2[0]) + (pt4[1] - pt2[1]) * (pt4[1] - pt2[1])
            != (pt4[0] - pt3[0]) * (pt4[0] - pt3[0]) + (pt4[1] - pt3[1]) * (pt4[1] - pt3[1])) {
      return false;
    }
    if (2 * ((pt4[0] - pt2[0]) * (pt4[0] - pt2[0]) + (pt4[1] - pt2[1]) * (pt4[1] - pt2[1]))
            != (pt2[0] - pt3[0]) * (pt2[0] - pt3[0]) + (pt2[1] - pt3[1]) * (pt2[1] - pt3[1])) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
    System.out.println(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,12}));
    System.out.println(validSquare(new int[]{1,1}, new int[]{5,3}, new int[]{3,5}, new int[]{7,7}));
  }
}
