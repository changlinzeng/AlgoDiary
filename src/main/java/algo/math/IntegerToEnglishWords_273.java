package algo.math;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords_273 {
  private static Map<Integer, String> digits = new HashMap<>() {
    {
      put(0, "Zero");
      put(1, "One");
      put(2, "Two");
      put(3, "Three");
      put(4, "Four");
      put(5, "Five");
      put(6, "Six");
      put(7, "Seven");
      put(8, "Eight");
      put(9, "Nine");
      put(10, "Ten");
      put(11, "Eleven");
      put(12, "Twelve");
      put(13, "Thirteen");
      put(14, "Fourteen");
      put(15, "Fifteen");
      put(16, "Sixteen");
      put(17, "Seventeen");
      put(18, "Eighteen");
      put(19, "Nineteen");
      put(20, "Twenty");
      put(30, "Thirty");
      put(40, "Forty");
      put(50, "Fifty");
      put(60, "Sixty");
      put(70, "Seventy");
      put(80, "Eighty");
      put(90, "Ninety");
    }
  };

  public static String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    var segments = new int[4];
    var pos = 3;
    while (num >= 1000) {
      segments[pos] = num % 1000;
      num = num / 1000;
      pos--;
    }
    segments[pos] = num;

    var word = "";
    for (var i = 0; i < segments.length; i++) {
      if (segments[i] > 0) {
        word += " " + translate(segments[i], i);
      }
    }

    return word.trim();
  }

  private static String translate(int num, int segment) {
    var result = "";
    var appendix = switch (segment) {
      case 0 -> "Billion";
      case 1 -> "Million";
      case 2 -> "Thousand";
      default -> "";
    };
    if (num >= 100) {
      result += digits.get(num / 100) + " Hundred";
      num = num % 100;
    }
    if (num >= 10 && num < 20) {
      result += " " + digits.get(num);
    }
    if (num >= 20) {
      result += " " + digits.get((num / 10) * 10);
      num = num % 10;
    }
    if (num > 0 && num < 10) {
      result += " " + digits.get(num);
    }
    result += " " + appendix;
    return result.trim();
  }

  public static void main(String[] args) {
    System.out.println(numberToWords(123));
    System.out.println(numberToWords(1123));
    System.out.println(numberToWords(912123));
    System.out.println(numberToWords(8912123));
    System.out.println(numberToWords(708912123));
    System.out.println(numberToWords(1708912123));
  }
}
