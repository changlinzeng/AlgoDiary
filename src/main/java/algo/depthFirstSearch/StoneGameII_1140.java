package algo.depthFirstSearch;

public class StoneGameII_1140 {
  public static int stoneGameII(int[] piles) {
    return dfs(piles, 0, 1, true, new int[piles.length + 1][100][2]);
  }

  private static int dfs(int[] piles, int start, int m, boolean aliceTurn, int[][][] dp) {
    if (start == piles.length) {
      return 0;
    }
    // state of stones at start index with m for alice 1 and bob 0
    if (aliceTurn && dp[start][m][1] != 0) {
      return dp[start][m][1];
    }
    if (!aliceTurn && dp[start][m][0] != 0) {
      return dp[start][m][0];
    }
    var maxStones = aliceTurn ? 0 : Integer.MAX_VALUE;
    var stones = 0;
    for (var x = 1; x <= m * 2 && start + x - 1 < piles.length; x++) {
      stones += piles[start + x - 1];
      if (aliceTurn) {
        maxStones = Math.max(maxStones, stones + dfs(piles, start + x, Math.max(x, m), false, dp));
      } else {
        // bob needs to get min stones so alice can get max
        maxStones = Math.min(maxStones, dfs(piles, start + x, Math.max(x, m), true, dp));
      }
    }
    if (aliceTurn) {
      dp[start][m][1] = maxStones;
    } else {
      dp[start][m][0] = maxStones;
    }
    return maxStones;
  }

  public static void main(String[] args) {
    System.out.println(stoneGameII(new int[]{2,7,9,4,4}));
  }
}
