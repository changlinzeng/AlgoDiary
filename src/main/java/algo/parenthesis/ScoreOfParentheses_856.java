package algo.parenthesis;

import java.util.Stack;

public class ScoreOfParentheses_856 {
  public static int score(String s) {
    // record left parentheses as zero and right parentheses as 1
    var stack = new Stack<Integer>();
    for (int i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (c == '(') {
        stack.push(0);
      } else {
        // calculate the previous sum of score and double it
        var sum = 0;
        while (stack.peek() != 0) {
          sum += stack.pop();
        }

        // pop the left parentheses
        stack.pop();
        if (sum == 0) {
          stack.push(1);
        } else {
          stack.push(sum * 2);
        }
      }
    }

    var score = 0;
    while (!stack.empty()) {
      score += stack.pop();
    }

    return score;
  }

  public static void main(String[] args) {
    System.out.println(score("()"));
    System.out.println(score("(())"));
    System.out.println(score("()()"));
    System.out.println(score("()(())"));
    System.out.println(score("(()(()))"));
  }
}
