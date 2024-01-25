package data.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrimePairsWithTargetSum_2761 {
    public static List<List<Integer>> findPrimePairs(int n) {
        var complement = new HashMap<Integer, Integer>();
        var pairs = new ArrayList<List<Integer>>();
        for (var i = 2; i <= n - 2; i++) {
            if (i > 2 && i % 2 == 0) {
                continue;
            }
            if (isPrime(i)) {
                if (i == n / 2 && n % 2 == 0) {
                    pairs.add(List.of(i, i));
                } if (i <= n / 2) {
                    complement.put(i, n - i);
                } else if (i > n / 2) {
                    if (complement.containsKey(n - i)) {
                        pairs.add(0, List.of(n - i, i));
                    }
                }
            }
        }
        return pairs;
    }

    private static boolean isPrime(int p) {
        if (p == 2) {
            return true;
        }
        if (p % 2 == 0) {
            return false;
        }
        for (var i = 3; i * i <= p; i = i + 2) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        findPrimePairs(10).forEach(System.out::println);
//        findPrimePairs(2).forEach(System.out::println);
//        findPrimePairs(4).forEach(System.out::println);
//        findPrimePairs(5).forEach(System.out::println);
//        findPrimePairs(6).forEach(System.out::println);
//        findPrimePairs(999763).forEach(System.out::println);
        findPrimePairs(999162).forEach(System.out::println);
    }
}
