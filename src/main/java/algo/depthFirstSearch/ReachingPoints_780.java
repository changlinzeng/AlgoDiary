package algo.depthFirstSearch;

public class ReachingPoints_780 {
  public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
    return backtrack(sx, sy, tx, ty);
  }

  private static boolean backtrack(int sx, int sy, int tx, int ty) {
    if (sx == tx && sy == ty) {
      return true;
    }
    if (sx > tx || sy > ty) {
      return false;
    }
    if (backtrack(sx + sy, sy, tx, ty)) {
      return true;
    }
    if (backtrack(sx, sx + sy, tx, ty)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(reachingPoints(1, 1, 3, 5));
  }
}
