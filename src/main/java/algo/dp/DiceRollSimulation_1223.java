package algo.dp;

import java.util.Arrays;

public class DiceRollSimulation_1223 {
    public static int dieSimulator(int n, int[] rollMax) {
        long mod = 1_000_000_007;
        var faces = rollMax.length;
        // the number of combinations of each face at every roll
        var dp = new long[n + 1][faces];
        // the total number of combinations (sum every face) of every roll
        var total = new long[n + 1];

        Arrays.fill(dp[0], 0);
        Arrays.fill(dp[1], 1);
        total[0] = 1;
        total[1] = faces;

        for (var i = 2; i <= n; i++) {
            for (var j = 0; j < faces; j++) {
                for (var k = 1; k <= rollMax[j] && k <= i; k++) {
                    // number of rolls not less than consecutive occurrence for this face, then we
                    var countExceptK = total[i - k] - dp[i - k][j];
                    if (countExceptK < 0) {
                        countExceptK += mod;
                    }
                    dp[i][j] = (dp[i][j] + countExceptK) % mod;
                }
            }
            for (var count : dp[i]) {
                total[i] = (total[i] + count) % mod;
            }
        }

        return (int)total[n];
    }

    public static void main(String[] args) {
        System.out.println(dieSimulator(2, new int[]{1,1,1,1,1,1}));
        System.out.println(dieSimulator(2, new int[]{1,1,1,2,2,3}));
        System.out.println(dieSimulator(3, new int[]{1,1,1,2,2,3}));
        System.out.println(dieSimulator(2, new int[]{1,1,2,2,2,3}));
        System.out.println(dieSimulator(30, new int[]{2,3,1,2,1,2}));
    }
}
