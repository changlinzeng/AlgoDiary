package algo.backtrack;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities_1079 {
  public static int numTilePossibilities(String tiles) {
    var chars = tiles.toCharArray();
    var possibilities = new HashSet<String>();
    backtrack(chars, possibilities, "", new boolean[chars.length]);
    return possibilities.size();
  }

  private static void backtrack(char[] chars, Set<String> possibilities, String seq, boolean[] visited) {
    for (var i = 0; i < chars.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        var newseq = seq + chars[i];
        possibilities.add(newseq);
        backtrack(chars, possibilities, newseq, visited);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(numTilePossibilities("AAB"));
  }
}
