package design;

import java.util.ArrayList;
import java.util.List;

public class FindMedianFromDataStream_295 {
  static class MedianFinder {
    private final List<Integer> data;

    public MedianFinder() {
      this.data = new ArrayList<>();
    }

    public void addNum(int num) {
      // binary search to find position to insert
      int start = 0, end = data.size() - 1, mid = 0;
      if (!data.isEmpty() && num <= data.get(0)) {
        data.add(0, num);
      } else if (!data.isEmpty() && num >= data.getLast()) {
        data.add(num);
      } else {
        while (start < end) {
          mid = start + (end - start) / 2;
          if (start == mid || data.get(mid) == num) {
            mid++;
            break;
          }
          if (num < data.get(mid)) {
            if (data.get(mid - 1) < num) {
              break;
            }
            end = mid - 1;
          } else if (num > data.get(mid)) {
            if (data.get(mid + 1) > num) {
              mid++;
              break;
            }
            start = mid;
          }
        }

        data.add(mid, num);
      }
    }

    public double findMedian() {
      int size = data.size(), mid = size / 2;
      if (size % 2 == 0) {
        return (data.get(mid) + data.get(mid - 1)) / 2.0;
      } else {
        return data.get(mid);
      }
    }
  }

  public static void main(String[] args) {
    var finder = new MedianFinder();
//    finder.addNum(1);
//    finder.addNum(2);
//    System.out.println(finder.findMedian());
//    finder.addNum(3);
//    System.out.println(finder.findMedian());
//    finder.addNum(-1);
//    finder.addNum(-2);
//    finder.addNum(-3);
//    finder.addNum(-4);
//    System.out.println(finder.findMedian());
//    finder.addNum(6);
//    finder.addNum(10);
//    finder.addNum(2);
//    finder.addNum(6);
//    finder.addNum(5);
//    finder.addNum(0);
//    finder.addNum(6);
//    finder.addNum(3);
//    finder.addNum(1);
//    finder.addNum(0);
//    System.out.println(finder.findMedian());
    finder.addNum(40);
    finder.addNum(12);
    finder.addNum(16);
    System.out.println(finder.findMedian());
  }
}
