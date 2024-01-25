package algo.breadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder_127 {
  /**
   *  Same as SlidingPuzzle
   */
  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    var words = new LinkedList<String>();
    var visited = new HashSet<String>();
    words.offer(beginWord);
    visited.add(beginWord);
    var num = 1;
    while (!words.isEmpty()) {
      var size = words.size();
      while (size-- > 0) {
        var word = words.poll();
        if (word.equals(endWord)) {
          return num;
        }
        for (var w : next(wordList, word)) {
          if (visited.add(w)) {
            words.offer(w);
          }
        }
      }
      num++;
    }
    return 0;
  }

  private static List<String> next(List<String> wordList, String word) {
    var result = new ArrayList<String>();
    for (var w : wordList) {
      var diff = 0;
      for (var i = 0; i < w.length(); i++) {
        if (w.charAt(i) != word.charAt(i)) {
          diff++;
        }
      }
      if (diff == 1) {
        result.add(w);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
    System.out.println(ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log")));
  }
}
