package design;

public class StringToInteger_atoi_8 {
  public static int myAtoi(String s) {
    var len = s.length();
    int num = 0, sign = 1;
    boolean hasNum = false;
    for (var i = 0; i < len; i++) {
      var ch = s.charAt(i);
      if (ch >= '0' && ch <= '9') {
        hasNum = true;
        long sum = num * 10L + Integer.parseInt(ch + "");
        if (sign * sum <= Integer.MIN_VALUE) {
          num = Integer.MIN_VALUE;
          break;
        }
        if (sum > Integer.MAX_VALUE) {
          num = Integer.MAX_VALUE;
          break;
        }
        num = (int)sum;
      } else if (ch == '-' || ch == '+') {
        if (hasNum) {
          // integer ends
          break;
        } else {
          // new integer starts
          hasNum = true;
          sign = ch == '-' ? -1 : 1;
        }
      } else {
        if (ch == ' ' && !hasNum) {
          continue;
        }
        break;
      }
    }
    if (!hasNum) {
      return 0;
    }
    if (num == Integer.MIN_VALUE) {
      return num;
    }
    return sign * num;

  }

  public static void main(String[] args) {
    System.out.println(myAtoi("00000-42a1234"));
    System.out.println(myAtoi("  0000000000012345678"));
    System.out.println(myAtoi("9223372036854775808"));
    System.out.println(myAtoi("+-12"));
    System.out.println(myAtoi("word and 987"));
    System.out.println(myAtoi("-91283472332"));
    System.out.println(myAtoi("-2-"));
    System.out.println(Integer.MIN_VALUE);
  }
}
