package algo.twoPointers;

public class StringCompression_443 {
  public static int compress(char[] chars) {
    int len = chars.length, end = -1, i = 0, count = 0;
    var ch = chars[0];
    while (i <= len) {
      if (i < len && chars[i] == ch) {
        count++;
      } else {
        if (count == 1) {
          chars[++end] = ch;
        } else {
          chars[++end] = ch;
          var start = end + 1;
          while (count > 9) {
            var mod = count % 10;
            count = count / 10;
            chars[++end] = (char)(mod + '0');
          }
          chars[++end] = (char)(count + '0');
          // reverse the digits from start to end
          for (var j = 0; j <= (end - start) / 2; j++) {
            var tmp = chars[start + j];
            chars[start + j] = chars[end - j];
            chars[end - j] = tmp;
          }
        }
        count = 1;
        if (i < len) {
          ch = chars[i];
        }
      }
      i++;
    }
    return end + 1;
  }

  public static void main(String[] args) {
//    System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
//    System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
//    System.out.println(compress(new char[]{'a'}));
    System.out.println(compress(new char[]{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'}));
  }
}
