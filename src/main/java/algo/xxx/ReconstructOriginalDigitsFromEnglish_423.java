package algo.xxx;

import java.util.*;

public class ReconstructOriginalDigitsFromEnglish_423 {
  public static String originalDigits(String s) {
    // zero -> z
    // one
    // two -> w
    // three
    // four -> u
    // five
    // six -> x
    // seven
    // eight -> g
    // nine

    // pick up zero -> two -> four -> six -> eight -> one -> three -> five -> seven -> nine

    var freq = new HashMap<Character, Integer>();
    for (var i = 0; i < s.length(); i++) {
      freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
    }

    var ids = List.of('z', 'w', 'u', 'x', 'g', 'o', 't', 'f', 'v', 'i');
    var index = new HashMap<Integer, Character>() {
      {
        put(0, '0');
        put(1, '2');
        put(2, '4');
        put(3, '6');
        put(4, '8');
        put(5, '1');
        put(6, '3');
        put(7, '5');
        put(8, '7');
        put(9, '9');
      }
    };
    var chars = new ArrayList<Map<Character, Integer>>();
    chars.add(new HashMap<>() {
      {
        put('z', 1);
        put('e', 1);
        put('r', 1);
        put('o', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('t', 1);
        put('w', 1);
        put('o', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('f', 1);
        put('o', 1);
        put('u', 1);
        put('r', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('s', 1);
        put('i', 1);
        put('x', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('e', 1);
        put('i', 1);
        put('g', 1);
        put('h', 1);
        put('t', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('o', 1);
        put('n', 1);
        put('e', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('t', 1);
        put('h', 1);
        put('r', 1);
        put('e', 2);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('f', 1);
        put('i', 1);
        put('v', 1);
        put('e', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('s', 1);
        put('e', 2);
        put('v', 1);
        put('n', 1);
      }
    });
    chars.add(new HashMap<>() {
      {
        put('n', 2);
        put('i', 1);
        put('e', 1);
      }
    });

    var count = new TreeMap<Character, Integer>();
    for (var i = 0; i < 10; i++) {
      if (freq.containsKey(ids.get(i))) {
        var cnt = freq.get(ids.get(i));
        var cmap = chars.get(i);
        count.put(index.get(i), cnt);
        for (var entry : cmap.entrySet()) {
          var key = entry.getKey();
          var val = entry.getValue();
          freq.put(key, freq.get(key) - cnt * val);
          if (freq.get(key) == 0) {
            freq.remove(key);
          }
        }
      }
    }

    var digits = "";
    for (var entry : count.entrySet()) {
      digits = digits + String.valueOf(entry.getKey()).repeat(entry.getValue());
    }
    return digits;
  }

  public static void main(String[] args) {
    System.out.println(originalDigits("owoztneoer"));
    System.out.println(originalDigits("fviefuro"));
  }
}
