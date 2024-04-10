package algo.binarySearch;

import java.util.Arrays;

public class Heaters_475 {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        var radius = 0;
        for (int house : houses) {
          radius = Math.max(radius, search(house, heaters));
        }
        return radius;
    }

    public static int search(int house, int[] heaters) {
        if (house <= heaters[0]) {
            return heaters[0] - house;
        }
        if (house >= heaters[heaters.length - 1]) {
            return house - heaters[heaters.length - 1];
        }
        int start = 0, end = heaters.length - 1;
        while (start < end) {
            var mid = start + (end - start) / 2;
            if (mid == start) {
                return Math.min(house - heaters[start], heaters[end] - house);
            }
            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 5}, new int[]{10}));
        System.out.println(findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        System.out.println(findRadius(new int[]{25921153,510616708}, new int[]{771515668,357571490,44788124,927702196,952509530}));
    }
}
