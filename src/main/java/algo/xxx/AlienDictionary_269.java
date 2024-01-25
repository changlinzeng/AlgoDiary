package algo.xxx;

import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionary_269 {
  public static String alienDictionary(String[] words) {
    // "wrt","wrf","er","ett","rftt"
    // t < f
    // w < e
    // r < t
    // e < r

    var relation = new HashMap<Character, Character>();
    var reverse = new HashMap<Character, Character>();
    var chars = new HashSet<Character>();
    for (var i = 0; i < words.length - 1; i++) {
      String w1 = words[i], w2 = words[i + 1];
      var len = Math.min(w1.length(), w2.length());
      for (var j = 0; j < len; j++) {
        char c1 = w1.charAt(j), c2 = w2.charAt(j);
        if (c1 != c2) {
          chars.add(c1);
          chars.add(c2);
          relation.put(c1, c2);
          reverse.put(c2, c1);
          break;
        }
      }
    }

    var dict = "";
    for (var c : chars) {
      if (!relation.containsKey(c)) {
        dict += c;
        while (reverse.containsKey(c)) {
          c = reverse.get(c);
          dict = c + dict;
        }
        break;
      }
    }

    return dict;
  }

  public static void main(String[] args) {
    System.out.println(alienDictionary(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    System.out.println(alienDictionary(new String[]{"z", "x"}));
    System.out.println(alienDictionary(new String[]{"z", "x", "z"}));
  }
}
