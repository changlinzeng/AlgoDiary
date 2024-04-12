package algo.greedy;

import java.util.Arrays;

public class DestroyingAsteroids_2126 {

  public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
    Arrays.sort(asteroids);

    long weight = mass;
    for (var ast : asteroids) {
      if (weight >= ast) {
        weight += ast;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(asteroidsDestroyed(10, new int[]{3,9,19,5,21}));
    System.out.println(asteroidsDestroyed(5, new int[]{4,9,23,4}));
  }
}
