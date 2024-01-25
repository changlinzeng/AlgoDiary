package algo.backtrack;

public class PermutationSequence_60 {
  private static int count = 0;
  public static String getPermutation(int n, int k) {
    return backtrack(n, "", k, new boolean[n + 1]);
  }

  private static String backtrack(int n, String s, int k, boolean[] visited) {
    if (s.length() == n) {
      count++;
    }
    if (k == count) {
      return s;
    }
    for (var i = 1; i <= n; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      var next = backtrack(n, s + i, k, visited);
      if (!next.isEmpty()) {
        return next;
      }
      visited[i] = false;
    }
    return "";
  }

  public static void main(String[] args) {
    System.out.println(getPermutation(4, 9));
  }
}
