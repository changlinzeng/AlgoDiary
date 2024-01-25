package algo.backtrack;

import java.util.Arrays;

public class MatchsticksToSquare_473 {
    public static boolean makesquare(int[] matchsticks) {
        var len = matchsticks.length;
        var total = (int)Arrays.stream(matchsticks).asLongStream().sum();
        if (total % 4 != 0) {
            return false;
        }
        var edgeLen = total / 4;
        return backtrack(matchsticks, edgeLen, 4, edgeLen, 0, new int[5][1 << (len + 1)]);
    }

    private static boolean backtrack(final int[] matchsticks, final int edgeLen, int edgeNum, int leftLen, int bitmask, int[][] dp) {
        // we have matched all edges of the square
        if (leftLen == 0 && edgeNum == 1) {
            return true;
        }
        // bitmask is the binary representation of the state
        if (dp[edgeNum][bitmask] != 0) {
            return dp[edgeNum][bitmask] == 1;
        }
        if (leftLen == 0) {
            // matched one edge
            edgeNum--;
            leftLen = edgeLen;
        }
        var len = matchsticks.length;
        for (var i = 0; i < len; i++) {
            var pos = 1 << (len - i);
            if (matchsticks[i] > leftLen) {
                continue;
            }
            if ((bitmask & pos) != 0) {
                continue;
            }
            var mask = bitmask ^ pos;
            if (backtrack(matchsticks, edgeLen, edgeNum, leftLen - matchsticks[i], mask, dp)) {
                dp[edgeNum][mask] = 1;
                return true;
            }
            dp[edgeNum][mask] = -1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1,1,2,2,2}));
        System.out.println(makesquare(new int[]{3,3,3,3,4}));
        System.out.println(makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
        System.out.println(makesquare(new int[]{16,8,8,8,5,1,16,3,11,1,11,12,20,6,6}));
        System.out.println(makesquare(new int[]{99,37,37,37,37,37,37,37,37,5}));
        System.out.println(makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }
}
