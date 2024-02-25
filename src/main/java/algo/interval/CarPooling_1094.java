package algo.interval;

import java.util.TreeMap;

public class CarPooling_1094 {
  public static boolean carPooling(int[][] trips, int capacity) {
    var trip = new TreeMap<Integer, Integer>();  // time -> passengers (positive for taking passengers, negative for dropping)
    for (var t : trips) {
      trip.put(t[1], trip.getOrDefault(t[1], 0) + t[0]);  // take passenger
      trip.put(t[2], trip.getOrDefault(t[2], 0) - t[0]);  // drop passenger
    }

    var passengers = 0;
    for (var entry : trip.entrySet()) {
      passengers += entry.getValue();
      // at ant time, passengers should not exceed capacity
      if (passengers > capacity) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 4));
    System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));
  }
}
