package algo.slidingWindow;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences_187 {
  public static List<String> findRepeatedDnaSequences(String s) {
    if (s.length() < 10) {
      return Collections.emptyList();
    }
    var result = new HashSet<String>();
    var uniq = new HashSet<String>();
    var dna = s.substring(0, 10);
    uniq.add(dna);
    for (var i = 10; i < s.length(); i++) {
      dna += s.charAt(i);
      dna = dna.substring(1);
      if (!uniq.add(dna)) {
        result.add(dna);
      }
    }
    return result.stream().toList();
  }
}
