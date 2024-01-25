package algo.depthFirstSearch;

public class DecodedStringAtIndex_880 {
  public static String decodeStringAtIndex(String s, int k) {
    // find the length till length * number > k
    var len = s.length();
    var segment = 0;
    for (int i = 0; i < len; i++) {
      var c = s.charAt(i);
      var isDigit = c >= '0' && c <= '9';
      if (!isDigit) {
        segment++;
        if (segment == k) {
          return c + "";
        }
      } else {
        var num = Integer.parseInt(c + "");
        if (segment * num >= k) {
          if (k % segment != 0) {
            return decodeStringAtIndex(s.substring(0, i), k % segment);
          }
          return decodeStringAtIndex(s.substring(0, i), segment);
        }
        segment = segment * num;
      }
    }

    return "";
  }

  public static void main(String[] args) {
    System.out.println(decodeStringAtIndex("leet2code3", 10));
    System.out.println(decodeStringAtIndex("ha22", 5));
    System.out.println(decodeStringAtIndex("a2345678999999999999999", 1));
    System.out.println(decodeStringAtIndex("n2f7x7bv4l", 110));
    // TODO this case fails
    System.out.println(decodeStringAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp", 976159153));
  }
}
