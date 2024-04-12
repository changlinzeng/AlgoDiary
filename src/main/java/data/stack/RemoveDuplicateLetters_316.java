package data.stack;

import java.util.HashMap;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {
  public static String removeDuplicateLetters(String s) {
    var stack = new Stack<Character>();
    var freq = new HashMap<Character, Integer>();
    for (var c : s.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    for (var c : s.toCharArray()) {
      if (stack.contains(c)) {
        freq.put(c, freq.get(c) - 1);
        continue;
      }
      while (!stack.isEmpty() && stack.peek() >= c && freq.get(stack.peek()) > 1) {
        var ch = stack.pop();
        freq.put(ch, freq.get(ch) - 1);
      }
      stack.push(c);
    }

    return stack.stream().map(String::valueOf).reduce("", String::concat);
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicateLetters("bcabc"));
    System.out.println(removeDuplicateLetters("cbacdcbc"));
    System.out.println(removeDuplicateLetters("cbbbcaa"));
    System.out.println(removeDuplicateLetters("abacb"));
  }

}
