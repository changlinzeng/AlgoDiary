package algo.interval;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime_759 {
  public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {
    var all = new ArrayList<Interval>();
    for (var a : avails) {
      all.addAll(a);
    }
    all.sort((a, b) -> {
      if (a.start == b.start) {
        return a.end - b.end;
      }
      return a.start - b.start;
    });

    var free = new ArrayList<Interval>();
    for (var i = 0; i < all.size() - 1; i++) {
      Interval current = all.get(i), next = all.get(i + 1);
      if (current.end < next.start) {
        free.add(new Interval(current.end, next.start));
      }
    }
    return free;
  }

  public static class Interval {
    public int start;
    public int end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "[" + start + ":" + end + "]";
    }
  }

  public static void main(String[] args) {
    var e1 = List.of(new Interval(1,2), new Interval(5,6));
    var e2 = List.of(new Interval(1,3));
    var e3 = List.of(new Interval(4,10));
    var avail = List.of(e1, e2, e3);
    employeeFreeTime(avail).forEach(System.out::println);
  }
}
