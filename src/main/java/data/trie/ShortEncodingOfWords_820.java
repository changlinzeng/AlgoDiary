package data.trie;

import java.util.Arrays;

public class ShortEncodingOfWords_820 {
  public static int minimumLengthEncoding(String[] words) {
    var root = new Node('\0');
    var len = 0;
    Arrays.sort(words, (a, b) -> b.length() - a.length());
    for (var word : words) {
      var wlen = insert(word, root);
      if (wlen != 0) {
        len += wlen + 1;
      }
    }
    return len;
  }

  private static int insert(String word, Node root) {
    var cur = root;
    var extended = false;
    for (var i = word.length() - 1; i >= 0; i--) {
      var c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        extended = true;
        cur.children[c - 'a'] = new Node(c);
      }
      cur = cur.children[c - 'a'];
    }
    return extended ? word.length() : 0;
  }

  static class Node {
    public char val;
    public Node[] children;

    public Node(char val) {
      this.val = val;
      this.children = new Node[26];
    }
  }

  public static void main(String[] args) {
    System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    System.out.println(minimumLengthEncoding(new String[]{"t"}));
    System.out.println(minimumLengthEncoding(new String[]{"me", "time"}));
  }
}
