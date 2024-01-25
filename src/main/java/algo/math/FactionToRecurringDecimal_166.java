package algo.math;

import java.util.HashMap;

public class FactionToRecurringDecimal_166 {
  public static String fractionToDecimal(int numerator, int denominator) {
    // check if we will get the same mod
    var mmap = new HashMap<Long, Integer>();
    var qmap = new HashMap<Integer, Long>();
    var result = "";
    long _numerator = numerator;
    long _denominator = denominator;
    if (_numerator < 0 && _denominator > 0 || _numerator > 0 && _denominator < 0) {
      result = "-";
      _numerator = Math.abs(_numerator);
      _denominator = Math.abs(_denominator);
    }
    long q = _numerator / _denominator;
    long mod = _numerator % _denominator;
    result += q;
    if (mod != 0) {
      result += ".";
    } else {
      return result;
    }
    long nt;
    for (;;) {
      nt = mod * 10;
      mod = nt % _denominator;
      q = nt / _denominator;
      result += q;
      if (mod == 0) {
        return result;
      } else {
        if (mmap.containsKey(mod) && qmap.get(mmap.get(mod)) == q) {
          // find loop
          var start = mmap.get(mod);
          return result.substring(0, start) + "(" + result.substring(start, result.length() - 1) + ")";
        } else {
          var pos = result.length() - 1;
          mmap.put(mod, pos); // record mod and the position of corresponding q
          qmap.put(pos, q);
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(fractionToDecimal(1, 2));
    System.out.println(fractionToDecimal(2, 1));
    System.out.println(fractionToDecimal(4, 333));
    System.out.println(fractionToDecimal(1, 6));
    System.out.println(fractionToDecimal(-1, 6));
    System.out.println(fractionToDecimal(-1, -2147483648));
    System.out.println(fractionToDecimal(-2147483648, 1));
  }
}
