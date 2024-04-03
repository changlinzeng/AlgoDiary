package algo.depthFirstSearch;

import java.util.Arrays;

public class NumbereOfWaysToReachAPositionAfterExactlyKSteps_2400 {
    private static int offset = 1000;
    private static final int mod = 1_000_000_007;
    public static int numberOfWays(int startPos, int endPos, int k) {
        var dp = new int[k + 1][3000];
        for (var arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(startPos, endPos, k, dp);
    }

    private static int dfs(int currentPos, int endPos, int k, int[][] dp) {
        if (k == endPos - currentPos) {
            return 1;
        }
        if (k == 0) {
            return currentPos == endPos ? 1 : 0;
        }
        if (dp[k][currentPos + offset] != -1) {
            return dp[k][currentPos + offset];
        }
        var s1 = dfs(currentPos + 1, endPos, k - 1, dp);
        var s2 = dfs(currentPos - 1, endPos, k - 1, dp);
        var sum = (s1 + s2) % mod;
        dp[k][currentPos + offset] = sum;
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(numberOfWays(1, 2, 3));
//        System.out.println(numberOfWays(2, 5, 10));
//        System.out.println(numberOfWays(989, 1000, 39));
        System.out.println(numberOfWays(270, 272, 6));
    }
}
