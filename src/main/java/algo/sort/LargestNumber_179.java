package algo.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber_179 {
  public static String largestNumber(int[] nums) {
    var arr = Arrays.stream(nums).boxed().toArray();
    Arrays.sort(arr, (n1, n2) -> {
      var s1 = n1 + String.valueOf(n2);
      var s2 = n2 + String.valueOf(n1);
      for (var i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          return s2.charAt(i) - s1.charAt(i);
        }
      }
      return 0;
    });
    var list = Arrays.stream(arr).map(String::valueOf).toList();
    if ("0".equals(list.getFirst()) && "0".equals(list.getLast())) {
      return "0";
    }

    return list.stream().reduce("", String::concat);
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new int[]{10,2}));
    System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    System.out.println(largestNumber(new int[]{111311, 1113}));
    System.out.println(largestNumber(new int[]{0, 0}));
  }
}
