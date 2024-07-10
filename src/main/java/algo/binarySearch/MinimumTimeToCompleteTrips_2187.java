package algo.binarySearch;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips_2187 {
  public long minimumTime(int[] time, int totalTrips) {
    long min = 0;
    long max = (long)(Arrays.stream(time).max().getAsInt()) * (long) totalTrips;
    long minTime = max;
    while (min < max) {
      long mid = min + (max - min) / 2;
      long trips = 0;
      for (int t : time) {
        trips += mid / t;
      }
      if (trips >= totalTrips) {
        max = mid;
        minTime = Math.min(minTime, mid);
      } else {
        min = mid + 1;
      }
    }
    return minTime;
  }
}
