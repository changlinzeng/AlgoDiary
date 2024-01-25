package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    public static List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        backtrack(n, n, "", result);
        return result;
    }

    private static void backtrack(int leftCount, int rightCount, String paren, List<String> result) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(paren);
            return;
        }
        if (leftCount > 0) {
            backtrack(leftCount - 1, rightCount, paren + "(", result);
        }
        if (rightCount > leftCount) {
            backtrack(leftCount, rightCount - 1, paren + ")", result);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }
}