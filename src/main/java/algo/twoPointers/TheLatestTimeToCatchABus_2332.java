package algo.twoPointers;

import java.util.Arrays;

public class TheLatestTimeToCatchABus_2332 {
  public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
    int busLen = buses.length, passengerLen = passengers.length;
    int i = 0, j = 0;
    var passengerOnBus = new int[busLen][2];  // start and end index of passengers on each bus
    // set all bus as empty bus
    for (var bus : passengerOnBus) {
      Arrays.fill(bus, -1);
    }
    Arrays.sort(buses);
    Arrays.sort(passengers);
    while (i < busLen && j < passengerLen) {
      // add passengers to bus
      var count = 0;
      var from = j;
      while (j < passengerLen && passengers[j] <= buses[i] && count < capacity) {
        count++;
        j++;
      }
      if (j > 0) {
        passengerOnBus[i] = new int[]{from, j - 1};
      } else {
        // empty bus
        passengerOnBus[i] = new int[]{-1, -1};
      }
      i++;
    }

    for (var ii = passengerOnBus.length - 1; ii >= 0; ii--) {
      var busPassenger = passengerOnBus[ii];
      // catch an empty bus
      if (busPassenger[0] == -1) {
        return buses[ii];
      }
      if (busPassenger[1] - busPassenger[0] + 1 == capacity) {
        // this bus has no extra capacity so we find a time slot backward from the last passenger
        for (var k = busPassenger[1]; k >= 0 && k >= busPassenger[0]; k--) {
          if (k == 0 || passengers[k] - passengers[k - 1] > 1) {
            return passengers[k] - 1;
          }
        }
      } else {
        // this bus has extra capacity so we find time slot from the bus arrival time
        if (passengers[busPassenger[1]] != buses[ii]) {
          return buses[ii];
        } else {
          for (var k = busPassenger[1]; k >= 0 && k >= busPassenger[0]; k--) {
            if (k == 0 || passengers[k] - passengers[k - 1] > 1) {
              return passengers[k] - 1;
            }
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(latestTimeCatchTheBus(new int[]{10,20}, new int[]{2,17,18,19}, 2));
    System.out.println(latestTimeCatchTheBus(new int[]{10,20,30}, new int[]{19,13,26,4,25,11,21}, 2));
    System.out.println(latestTimeCatchTheBus(new int[]{3}, new int[]{2,4}, 2));
    System.out.println(latestTimeCatchTheBus(new int[]{3}, new int[]{2,3}, 2));
    System.out.println(latestTimeCatchTheBus(new int[]{3}, new int[]{4}, 1));
    System.out.println(latestTimeCatchTheBus(new int[]{6,8,18,17}, new int[]{6,8,17}, 1));
  }
}
