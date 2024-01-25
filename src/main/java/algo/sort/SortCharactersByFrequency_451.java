package algo.sort;

import java.util.ArrayList;
import java.util.HashMap;

public class SortCharactersByFrequency_451 {
  public static String frequencySort(String s) {
    var freq = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
    }

    var list = new ArrayList<String[]>();
    for (var c : freq.keySet()) {
      list.add(new String[]{c + "", freq.get(c) + ""});
    }

    list.sort((a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));

    var result = "";
    for (var chars : list) {
      result += chars[0].repeat(Integer.parseInt(chars[1]));
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(frequencySort("tree"));
    System.out.println(frequencySort("cccaaa"));
    System.out.println(frequencySort("Aabb"));
  }
}
