package algo.sequence;

import java.util.Comparator;
import java.util.HashMap;

public class FindLongestSpecialSubstringThatOccursThrice_I_2981 {
  public static int maximumLength(String s) {
    var freq = new HashMap<String, Integer>();  // substring -> freq
    for (var i = 0; i < s.length(); i++) {
      for (var j = i; j < s.length(); j++) {
        if (s.charAt(j) != s.charAt(i)) {
          break;
        }
        var str = s.substring(i, j + 1);
        freq.put(str, freq.getOrDefault(str, 0) + 1);
      }
    }
    return freq.entrySet().stream().filter(entry -> entry.getValue() >= 3)
            .map(e -> e.getKey().length()).max(Comparator.comparingInt(a -> a)).orElse(-1);
  }

  public static void main(String[] args) {
    System.out.println(maximumLength("aaaa"));
  }
}
