package algo.depthFirstSearch;

import java.util.Arrays;

public class OnesAndZeroes_474 {
  public static int findMaxForm(String[] strs, int m, int n) {
    var dp = new int[strs.length][m + 1][n + 1];
    for (var s : dp) {
      for (var mm : s) {
        Arrays.fill(mm, -1);
      }
    }
    return dfs(strs, 0, m, n, dp);
  }

  private static int dfs(String[] strs, int index, int m, int n, int[][][] dp) {
    if (index >= strs.length) {
      return 0;
    }
    if (dp[index][m][n] >= 0) {
      return dp[index][m][n];
    }
    var count = getCount(strs[index]);
    int f1 = 0, f2 = 0;
    if (m - count[0] >= 0 && n - count[1] >= 0) {
      f1 = Math.max(1 + dfs(strs, index + 1, m - count[0], n - count[1], dp),
              dfs(strs, index + 1, m, n, dp));
    } else {
      f2 = dfs(strs, index + 1, m, n, dp);
    }
    dp[index][m][n] = Math.max(f1, f2);
    return dp[index][m][n];
  }

  private static int[] getCount(String s) {
    var cnt = new int[2];
    for (var i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        cnt[0]++;
      } else {
        cnt[1]++;
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
    System.out.println(findMaxForm(new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90, 66));
    System.out.println(findMaxForm(new String[]{"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"}, 44, 39));
  }
}
