package design;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar_I_729 {
  static class MyCalendar {
    private final List<Event> events;
    public MyCalendar() {
      events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
      var event = new Event(start, end);
      if (events.isEmpty()) {
        events.add(event);
        return true;
      }
      if (start < events.getFirst().start) {
        if (end <= events.getFirst().start) {
          events.add(0, event);
          return true;
        } else {
          return false;
        }
      }
      if (start > events.getLast().start) {
        if (start >= events.getLast().end) {
          events.add(event);
          return true;
        } else {
          return false;
        }
      }

      int i = 0, j = events.size() - 1;
      int mid = 0;
      while (i < j) {
        mid = i + (j - i) / 2;
        if (mid == i) {
          break;
        }
        if (start == events.get(mid).start) {
          return false;
        } else if (events.get(mid).start < start) {
          i = mid;
        } else {
          j = mid;
        }
      }
      if (events.get(mid).end <= start && events.get(mid + 1).start >= end) {
        // insert new event after mid
        events.add(mid + 1, event);
        return true;
      }
      return false;
    }
  }

  static class Event {
    public int start;
    public int end;
    public Event child;
    public Event(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) {
    var cal = new MyCalendar();
    System.out.println(cal.book(20, 29));
    System.out.println(cal.book(13, 22));
    System.out.println(cal.book(44, 50));
    System.out.println(cal.book(1, 7));
    System.out.println(cal.book(2, 10));
    System.out.println(cal.book(14, 20));
    System.out.println(cal.book(19, 25));
  }
}
