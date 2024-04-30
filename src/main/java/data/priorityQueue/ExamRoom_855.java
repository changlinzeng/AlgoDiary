package data.priorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ExamRoom_855 {
  static class ExamRoom {

    private final int n;
    private final PriorityQueue<int[]> q;

    public ExamRoom(int n) {
      this.n = n;
      this.q = new PriorityQueue<>((a, b) -> {
        var len1 = (a[1] - a[0]) / 2;
        var len2 = (b[1] - b[0]) / 2;
        if (a[0] == -1 || a[1] == this.n) {
          len1 = a[1] - a[0] - 1;
        }
        if (b[0] == -1 || b[1] == this.n) {
          len2 = b[1] - b[0] - 1;
        }
        if (len1 == len2) {
          return a[0] - b[0];
        }
        return len1 > len2 ? -1 : 1;
      });
      q.offer(new int[]{-1, n});  // range of available seats with left inclusive and right inclusive
    }

    public int seat() {
      int[] range;
      if (!q.isEmpty()) {
        range = q.poll();
        if (range[0] == -1) {
          // seat 0 is free so we take seat 1
          q.offer(new int[]{0, range[1]});
          return 0;
        } else if (range[1] == this.n) {
          // seat n - 1 is free so we take n - 1
          q.offer(new int[]{range[0], n - 1});
          return n - 1;
        } else {
          var mid = range[0] + (range[1] - range[0]) / 2;
          q.offer(new int[]{range[0], mid});
          q.offer(new int[]{mid, range[1]});
          return mid;
        }
      }
      return -1;
    }

    public void leave(int p) {
      if (p == 0) {
        var list = new ArrayList<int[]>();
        while (!q.isEmpty()) {
          var range = q.poll();
          if (range[0] == 0) {
            q.offer(new int[]{-1, range[1]});
            break;
          } else {
            list.add(range);
          }
        }
        list.forEach(q::offer);
      } else if (p == this.n - 1) {
        var list = new ArrayList<int[]>();
        while (!q.isEmpty()) {
          var range = q.poll();
          if (range[1] == this.n - 1) {
            q.offer(new int[]{range[0], n});
            break;
          } else {
            list.add(range);
          }
        }
        list.forEach(q::offer);
      } else {
        var list = new ArrayList<int[]>();
        int[] first= null, second = null;
        while (!q.isEmpty()) {
          var range = q.poll();
          if (range[1] == p) {
            first = range;
          } else if (range[0] == p) {
            second = range;
          } else {
            list.add(range);
          }
          if (first != null && second != null) {
            q.offer(new int[]{first[0], second[1]});
            break;
          }
        }
        list.forEach(q::offer);
      }
    }
  }

  public static void main(String[] args) {
    var exam = new ExamRoom(8);
    exam.seat();
    exam.seat();
    exam.seat();
    exam.leave(0);
    exam.leave(7);
    System.out.println(exam.seat());
    System.out.println(exam.seat());
    System.out.println(exam.seat());
    System.out.println(exam.seat());
    System.out.println(exam.seat());
    System.out.println(exam.seat());
    System.out.println(exam.seat());
  }
}
