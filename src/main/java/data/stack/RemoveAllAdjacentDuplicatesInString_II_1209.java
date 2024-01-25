package data.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_II_1209 {
  public static String removeDuplicates(String s, int k) {
    var stack = new Stack<Character>();   // store the letter
    var freq = new Stack<Integer>();  // store the frequency of the letter

    for (int i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (!stack.isEmpty() && stack.peek() == c && freq.peek() == k - 1) {
        // pop from stack
        stack.pop();
        freq.pop();
      } else {
        int count;
        if (stack.isEmpty() || stack.peek() != c) {
          count = 1;
          stack.push(c);
        } else {
          count = freq.pop() + 1;
        }
        freq.push(count);
      }
    }

    var result = "";
    for (int i = 0; i < stack.size(); i++) {
      result += (stack.elementAt(i) + "").repeat(freq.elementAt(i));
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates("abcd", 2));
    System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
  }
}
