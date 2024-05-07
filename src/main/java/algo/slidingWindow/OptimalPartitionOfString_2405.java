package algo.slidingWindow;

import java.util.Arrays;

public class OptimalPartitionOfString_2405 {
  public static int partitionString(String s) {
    var len = s.length();
    var partition = 0;
    var count = new int[26];
    var i = 0;
    while (i < len) {
      var ch = s.charAt(i);
      if (count[ch - 'a'] == 0) {
        count[ch - 'a']++;
      } else {
        Arrays.fill(count, 0);
        count[ch - 'a']++;
        partition++;
      }
      i++;
    }
    return partition + 1;
  }

  public static void main(String[] args) {
    System.out.println(partitionString("abacaba"));
    System.out.println(partitionString("ssssss"));
  }
}
