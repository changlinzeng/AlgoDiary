package design;

import java.util.ArrayList;
import java.util.List;

public class RLEIterator_900 {
  static class RLEIterator {

    private List<int[]> encoding;
    private int index;
    private int offset = 0;  // record the count of numbers used for current number

    public RLEIterator(int[] encoding) {
      this.encoding = new ArrayList<>();
      this.index = 0;
      this.offset = 0;
      var i = 0;
      while (i < encoding.length) {
        // remove numbers with 0 count
        if (encoding[i] != 0) {
          this.encoding.add(new int[]{encoding[i], encoding[i + 1]});
        }
        i += 2;
      }
    }

    public int next(int n) {
      if (index == this.encoding.size()) {
        return -1;
      }
      if (n < this.encoding.get(index)[0] - offset) {
        offset += n;
        return this.encoding.get(index)[1];
      } else if (n == this.encoding.get(index)[0] - offset) {
        offset = 0;
        return this.encoding.get(index++)[1];
      } else {
        // no enough to consume for current number
        n -= (this.encoding.get(index)[0] - offset);
        index++;
        if (index == this.encoding.size()) {
          return -1;
        }
        while (index < this.encoding.size() && n > 0 && this.encoding.get(index)[0] < n) {
          n -= this.encoding.get(index)[0];
          index++;
        }
        if (index == this.encoding.size()) {
          return -1;
        }
        // consume current number
        offset = n;
        return this.encoding.get(index)[1];
      }
    }
  }

  public static void main(String[] args) {
//    var iter = new RLEIterator(new int[]{3,8,0,9,2,5});
//    System.out.println(iter.next(2));
//    System.out.println(iter.next(1));
//    System.out.println(iter.next(1));
//    System.out.println(iter.next(2));
    var iter = new RLEIterator(new int[]{811,903,310,730,899,684,472,100,434,611});
    System.out.println(iter.next(358));
    System.out.println(iter.next(345));
    System.out.println(iter.next(154));
    System.out.println(iter.next(265));

  }
}
