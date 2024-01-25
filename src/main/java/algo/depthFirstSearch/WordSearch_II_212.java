package algo.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * DFS in the matrix causes timeout !!
 * Build Trie for words in dictionary and then DFS
 */
public class WordSearch_II_212 {
  public static List<String> findWords(char[][] board, String[] words) {
    int rows = board.length, cols = board[0].length;
    var all = new ArrayList<String>();
    var wordSet = new HashSet<>(List.of(words));
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        var c = board[i][j];
        var trie = trie(wordSet.stream().toList());
        if (trie.children[c - 'a'] != null) {
          var w = new ArrayList<String>();
          dfs(board, i, j, trie.children[c - 'a'], "", w, new boolean[rows][cols]);
          all.addAll(w);
          w.forEach(wordSet::remove);
          if (wordSet.isEmpty()) {
            return all;
          }
        }
      }
    }
    return all;
  }

  private static void dfs(char[][] board, int row, int col, TrieNode node,
                          String word, List<String> words, boolean[][] visited) {
    if (visited[row][col]) {
      return;
    }
    visited[row][col] = true;
    word += node.val;
    if (node.wordEnd) {
      words.add(word);
      // mark the word added to void duplications
      node.wordEnd = false;
    }

    if (row + 1 < board.length && node.children[board[row + 1][col] - 'a'] != null) {
      // use a copy visited so that each word has its own copy of visited
      // otherwise all words will share the same visited
      var newVisited = Arrays.stream(visited).map(a -> Arrays.copyOf(a, a.length)).toArray(boolean[][]::new);
      dfs(board, row + 1, col, node.children[board[row + 1][col] - 'a'], word, words, newVisited);
    }
    if (row - 1 >= 0 && node.children[board[row - 1][col] - 'a'] != null) {
      var newVisited = Arrays.stream(visited).map(a -> Arrays.copyOf(a, a.length)).toArray(boolean[][]::new);
      dfs(board, row - 1, col, node.children[board[row - 1][col] - 'a'], word, words, newVisited);
    }
    if (col + 1 < board[0].length && node.children[board[row][col + 1] - 'a'] != null) {
      var newVisited = Arrays.stream(visited).map(a -> Arrays.copyOf(a, a.length)).toArray(boolean[][]::new);
      dfs(board, row, col + 1, node.children[board[row][col + 1] - 'a'], word, words, newVisited);
    }
    if (col - 1 >= 0 && node.children[board[row][col - 1] - 'a'] != null) {
      var newVisited = Arrays.stream(visited).map(a -> Arrays.copyOf(a, a.length)).toArray(boolean[][]::new);
      dfs(board, row, col - 1, node.children[board[row][col - 1] - 'a'], word, words, newVisited);
    }
  }

  private static TrieNode trie(List<String> words) {
    var root = new TrieNode();
    words.forEach(root::insert);
    return root;
  }

  static class TrieNode {
    public char val;
    public boolean wordEnd;
    public TrieNode[] children;

    public TrieNode() {
      this.val = '\0';
      this.wordEnd = false;
      this.children = new TrieNode[26];
    }

    public TrieNode(char val, boolean wordEnd) {
      this.val = val;
      this.wordEnd = wordEnd;
      this.children = new TrieNode[26];
    }

    public void insert(String word) {
      var cur = this;
      for (var c : word.toCharArray()) {
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode(c, false);
        }
        cur = cur.children[c - 'a'];
      }
      cur.wordEnd = true;
    }
  }

  public static void main(String[] args) {
    var result = findWords(new char[][]{{'o','a','a','n'},
                                        {'e','t','a','e'},
                                        {'i','h','k','r'},
                                        {'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"});
//    var result = findWords(new char[][]{{'a','b'},
//                                        {'c','d'}}, new String[]{"abcd"});
//    var result = findWords(new char[][]{{'a'}}, new String[]{"a"});
//    var result = findWords(new char[][]{{'a','b','c'},
//                                        {'a','e','d'},
//                                        {'a','f','g'}}, new String[]{"eaabcdgfa"});
//    var result = findWords(new char[][]{{'a','a'},
//                                        {'a','a'}}, new String[]{"aaaaa"});
//    var result = findWords(new char[][]{{'o','a','a','n'},
//                                         {'e','t','a','e'},
//                                         {'i','h','k','r'},
//                                         {'i','f','l','v'}}, new String[]{"oath","pea","eat","rain","hklf", "hf"});
//    var result = findWords(new char[][]{{'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'},
//                                         {'a','a','a','a','a','a','a','a','a','a','a','a'}},
//                                         new String[]{"aaaaaaaaaa"});
    result.forEach(System.out::println);
  }
}
