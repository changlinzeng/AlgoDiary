package design;

public class ImplementMagicDictionary_676 {
  static class MagicDictionary {

    private String[] dictionary;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
      this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
      for (var word : dictionary) {
        if (word.length() == searchWord.length()) {
          var change = 0;
          var i = 0;
          while (i < word.length()) {
            if (word.charAt(i) != searchWord.charAt(i)) {
              if (change > 0) {
                break;
              }
              change++;
            }
            i++;
          }
          if (i == word.length() && change == 1) {
            return true;
          }
        }
      }
      return false;
    }

  }

  public static void main(String[] args) {
    var magic = new MagicDictionary();
    magic.buildDict(new String[]{"hello", "leetcode", "judge"});
//    System.out.println(magic.search("hello"));
//    System.out.println(magic.search("hhllo"));
//    System.out.println(magic.search("hell"));
    System.out.println(magic.search("judge"));
  }
}
