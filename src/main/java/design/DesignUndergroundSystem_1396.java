package design;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem_1396 {

  private final Map<String, double[]> average;
  private final Map<Integer, CheckInInfo> checkIn;

  public DesignUndergroundSystem_1396() {
    average = new HashMap<>();
    checkIn = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    checkIn.put(id, new CheckInInfo(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    if (!checkIn.containsKey(id)) {
      return;
    }
    var checkInStation = checkIn.get(id).station;
    var checkInTime = checkIn.get(id).time;
    var key = checkInStation + "_" + stationName;
    average.putIfAbsent(key, new double[]{0, 0});
    var count = average.get(key)[0];
    var avg = average.get(key)[1];
    average.put(key, new double[]{count + 1, (avg * count + t - checkInTime) / (count + 1)});
    checkIn.remove(id);
  }

  public double getAverageTime(String startStation, String endStation) {
    return average.get(startStation + "_" + endStation)[1];
  }

  record CheckInInfo(String station, int time) {}
}
