package data.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString_II_1209 {
  public static String removeDuplicates(String s, int k) {
    var stack = new Stack<CharCount>();
    for (var i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      if (!stack.isEmpty() && stack.peek().ch == ch) {
        var top = stack.peek();
        if (top.count == k - 1) {
          stack.pop();
        } else {
          top.count++;
        }
      } else {
        stack.push(new CharCount(ch, 1));
      }
    }

    return stack.stream().map(c -> String.valueOf(c.ch).repeat(c.count)).collect(Collectors.joining(""));
  }

  private static class CharCount {
    public char ch;
    public int count;
    public CharCount(char ch, int count) {
      this.ch = ch;
      this.count = count;
    }
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates("abcd", 2));
    System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
  }
}
