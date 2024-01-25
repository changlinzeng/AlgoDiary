package algo.dp;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares_279 {
    private static int least = Integer.MAX_VALUE;
    public static int numSquares(int n) {
        least = Integer.MAX_VALUE;
        var roots = new ArrayList<Integer>();
        for (var i = 1; i * i <= n; i++) {
            roots.add(i * i);
        }
        var squares = new Integer[roots.size()];
        roots.toArray(squares);

        backtrack(squares, n, new ArrayList<>());
        return least;
    }

    private static void backtrack(Integer[] squares, int sum, List<Integer> path) {
        if (path.size() > least) {
            return;
        }
        // find the largest square root
        var max = squares.length - 1;
        while (squares[max] > sum) {
            max--;
        }
        for (var i = max; i >= 0; i--) {
            var left = sum - squares[i];
            path.add(squares[i]);
            if (left == 0) {
                least = Math.min(least, path.size());
                path.remove(path.size() - 1);
                return;
            }
            backtrack(squares, left, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(1));
        System.out.println(numSquares(61));
        System.out.println(numSquares(7168));
    }
}
