package design;

public class DesignAddAndSearchWordsDataStructure_211 {
  static class WordDictionary {
    private final TrieNode root;
    public WordDictionary() {
      root = new TrieNode('\0');
    }

    public void addWord(String word) {
      var cur = root;
      for (var i = 0; i < word.length(); i++) {
        var c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode(c);
        }
        cur = cur.children[c - 'a'];
      }
      cur.wordEnd = true;
    }

    public boolean search(String word) {
      return searchFrom(word, 0, root);
    }

    private boolean searchFrom(String word, int index, TrieNode node) {
      var cur = node;
      for (var i = index; i < word.length(); i++) {
        var c = word.charAt(i);
        if (c == '.') {
          for (var child : cur.children) {
            if (child != null) {
              if (searchFrom(word, i + 1, child)) {
                return true;
              }
            }
          }
          return false;
        } else {
          if (cur.children[c - 'a'] == null) {
            return false;
          }
          cur = cur.children[c - 'a'];
        }
      }
      return cur.wordEnd;
    }
  }

  static class TrieNode {
    public char val;
    public TrieNode[] children;
    public boolean wordEnd;
    public TrieNode(char val) {
      this.val = val;
      this.children = new TrieNode[26];
      this.wordEnd = false;
    }
  }

  public static void main(String[] args) {
    var wd = new WordDictionary();
    wd.addWord("bad");
    wd.addWord("dad");
    wd.addWord("mad");
    System.out.println(wd.search("pad"));
    System.out.println(wd.search("bad"));
    System.out.println(wd.search(".ad"));
    System.out.println(wd.search("b.."));

//    var wd = new WordDictionary();
//    wd.addWord("a");
//    System.out.println(wd.search(".a"));
  }
}
