package algo.binarySearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays_1011 {
  /**
   * Binary search for capacity between 0 and MAX
   */
  public static int shipWithinDays(int[] weights, int days) {
    int start = 0, end = Arrays.stream(weights).sum();  // min and max capacity
    while (start < end) {
      var mid = start + (end - start) / 2;
      if (canShip(mid, weights, days)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  private static boolean canShip(int capacity, int[] weights, int days) {
    int numDays = 0, availableCapacity = capacity;
    for (var w : weights) {
      if (capacity < w) {
        return false;
      }
      if (availableCapacity - w >= 0) {
        availableCapacity -= w;
      } else {
        numDays++;
        if (numDays >= days) {
          return false;
        }
        availableCapacity = capacity - w;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
    System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    System.out.println(shipWithinDays(new int[]{147,73,265,305,191,152,192,293,309,292,182,157,381,287,73,162,313,366,346,47}, 10));
  }
}
