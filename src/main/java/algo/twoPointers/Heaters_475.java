package algo.twoPointers;

import java.util.Arrays;

public class Heaters_475 {
    public static int findRadius(int[] houses, int[] heaters) {
        var hlen = houses.length;
        var dist = new int[hlen];

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int low = Integer.MIN_VALUE, upper = heaters[0], radius = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (i < hlen && j < heaters.length) {
            var hs = houses[i];
            // find the next heater
            if (hs > upper) {
                while (j < heaters.length && heaters[j] < hs) {
                    j++;
                }
                upper = heaters[j];
                low = heaters[j - 1];
            }
            if (low == Integer.MIN_VALUE) {

                dist[i] = upper - hs;
                radius = Math.max(radius, dist[i]);
            } else if (hs >= low && hs <= upper) {
                dist[i] = Math.min(hs - low, upper - hs);
                radius = Math.max(radius, dist[i]);
            }
            i++;
        }
        if (j >= heaters.length) {
            while (i < hlen) {
                dist[i] = houses[i] - upper;
                radius = Math.max(radius, dist[i]);
                i++;
            }
        }

        return radius;
    }

    public static void main(String[] args) {
//        System.out.println(findRadius(new int[]{1, 5}, new int[]{10}));
//        System.out.println(findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        System.out.println(findRadius(new int[]{25921153,510616708}, new int[]{771515668,357571490,44788124,927702196,952509530}));
    }
}
