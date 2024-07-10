package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {
  public List<String> letterCasePermutation(String s) {
    var result = new ArrayList<String>();
    backtrack(s, 0, "", result);
    return result;
  }

  private void backtrack(String s, int start, String path, List<String> result) {
    if (start == s.length()) {
      result.add(path);
      return;
    }
    var c = s.charAt(start);
    if (c >= '0' && c <= '9') {
      backtrack(s, start + 1, path + c, result);
    } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
      if (c >= 'a' && c <= 'z') {
        // lower case
        backtrack(s, start + 1, path + c, result);
        // upper case
        backtrack(s, start + 1, path + (char)(c - 32), result);
      } else {
        // upper case
        backtrack(s, start + 1, path + c, result);
        // lower case
        backtrack(s, start + 1, path + (char)(c + 32), result);
      }
    }
  }
}
