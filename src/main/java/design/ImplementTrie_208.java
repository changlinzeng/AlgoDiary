package design;

public class ImplementTrie_208 {
  static class Trie {

    private final TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    public void insert(String word) {
      var cur = root;
      for (var i = 0; i < word.length(); i++) {
        var c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode(c, false);
        }
        cur = cur.children[c - 'a'];
      }
      cur.wordEnd = true;
    }

    public boolean search(String word) {
      var node = root;
      for (var i = 0; i < word.length(); i++) {
        var child = node.children[word.charAt(i) - 'a'];
        if (child == null) {
          return false;
        }
        node = child;
      }
      return node.wordEnd;
    }

    public boolean startsWith(String prefix) {
      var node = root;
      for (var i = 0; i < prefix.length(); i++) {
        var child = node.children[prefix.charAt(i) - 'a'];
        if (child == null) {
          return false;
        }
        node = child;
      }
      return true;
    }
  }

  static class TrieNode {
    public char val;
    public boolean wordEnd;
    public final TrieNode[] children;

    public TrieNode() {
      this.val = '\0';
      this.children = new TrieNode[26];
    }

    public TrieNode(char val, boolean wordEnd) {
      this.val = val;
      this.wordEnd = wordEnd;
      this.children = new TrieNode[26];
    }
  }

  public static void main(String[] args) {
    var trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
  }
}
