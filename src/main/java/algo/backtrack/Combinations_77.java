package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public static List<List<Integer>> combine(int n, int k) {
        var combinations = new ArrayList<List<Integer>>();
        backtrack(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void backtrack(int n, int k, int start, List<Integer> path,
                                  List<List<Integer>> combinations) {
        if (k == 0) {
            combinations.add(new ArrayList<>(path));
            return;
        }
        for (var i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k - 1, i + 1, path, combinations);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        var combinations = combine(4, 2);
        combinations.forEach(System.out::println);
    }
}
