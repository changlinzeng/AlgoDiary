package algo.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumLinesToRepresentALineChart_2280 {
    public static int minimumLines(int[][] stockPrices) {
        var len = stockPrices.length;
        var lines = 0;

        if (len < 2) {
            return lines;
        }

        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        var slope = new int[]{1, 0};
        for (var i = 1; i < len; i++) {
            var s = new int[]{stockPrices[i][1] - stockPrices[i - 1][1], stockPrices[i][0] - stockPrices[i - 1][0]};
            if (!compareSlope(slope, s)) {
                lines++;
                slope = s;
            }
        }

        return lines;
    }

    private static boolean compareSlope(int[] s1, int[] s2) {
        return s1[0] * s2[1] == s1[1] * s2[0];
    }

    public static void main(String[] args) {
        System.out.println(minimumLines(new int[][]{{1,7},{2,6},{3,5},{4,4},{5,4},{6,3}}));
        System.out.println(minimumLines(new int[][]{{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}}));
        System.out.println(minimumLines(new int[][]{{3,4},{1,2},{7,8},{2,3}}));
        System.out.println(minimumLines(new int[][]{{7,59},{10,62},{22,62},{26,59},{79,92},{94,81},{57,94},{41,81},{68,44},{100,46},{71,85},{39,75},{85,28},{37,43},{75,10},{40,13},{50,82},{45,3},{52,69},{8,91},{91,45},{88,86},{95,93},{14,19},{1,92},{12,35},{16,35},{53,19},{49,14},{6,68}}));
    }
}
