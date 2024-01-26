package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares_279 {
    public static int numSquares(int n) {
        var dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (var i = 1; i <= n; i++) {
            for (var j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(1));
        System.out.println(numSquares(61));
        System.out.println(numSquares(7168));
    }
}
