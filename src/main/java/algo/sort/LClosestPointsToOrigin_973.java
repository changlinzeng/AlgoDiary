package algo.sort;

import java.util.Arrays;

public class LClosestPointsToOrigin_973 {
    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (int)(Math.pow(a[0], 2) + Math.pow(a[1], 2) - Math.pow(b[0], 2) - Math.pow(b[1], 2)));

        return Arrays.copyOfRange(points, 0, k);
    }
}
