package design;

import java.util.*;

public class MyCalendar_II_731 {
  static class MyCalendarTwo {
    private final Map<Integer, Integer> events;  // time -> flag (1 for event start, -1 for event end)

    public MyCalendarTwo() {
      this.events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
      events.put(start, events.getOrDefault(start, 0) + 1);
      events.put(end, events.getOrDefault(end, 0) - 1);

      // if there are 3 more starts than ends, it means there are three events at the same time
      var booked = 0;
      for (var entry : events.entrySet()) {
        booked += entry.getValue();
        if (booked == 3) {
          // revert
          events.put(start, events.get(start) - 1);
          events.put(end, events.get(end) + 1);
          return false;
        }
      }
      return true;
    }
  }

  public static void main(String[] args) {
    var cal = new MyCalendarTwo();
    System.out.println(cal.book(10, 20));
    System.out.println(cal.book(50, 60));
    System.out.println(cal.book(10, 40));
    System.out.println(cal.book(5, 15));
    System.out.println(cal.book(5, 10));
    System.out.println(cal.book(25, 55));
  }
}
