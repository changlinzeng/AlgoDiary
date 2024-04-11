package algo.recursion;

public class DecodedStringAtIndex_880 {
  public static String decodeStringAtIndex(String s, int k) {
    // find the length till length * number > k
    var len = s.length();
    var count = 0;
    for (int i = 0; i < len; i++) {
      var c = s.charAt(i);
      var isDigit = c >= '0' && c <= '9';
      if (!isDigit) {
        count++;
        if (count == k) {
          return c + "";
        }
      } else {
        var num = c - '0';
        if (((long) count * num) >= k) {
          if (k % count == 0) {
            // find the last character from 0 to i - 1
            for (var j = i - 1; j >= 0; j--) {
              if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                return s.charAt(j) + "";
              }
            }
          } else {
            return decodeStringAtIndex(s.substring(0, i), k % count);
          }
        }
        count = count * num;
      }
    }

    return "";
  }

  public static void main(String[] args) {
    System.out.println(decodeStringAtIndex("leet2code3", 10));
    System.out.println(decodeStringAtIndex("ha22", 5));
    System.out.println(decodeStringAtIndex("a2345678999999999999999", 1));
    System.out.println(decodeStringAtIndex("n2f7x7bv4l", 110));
    System.out.println(decodeStringAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp", 976159153));
  }
}
