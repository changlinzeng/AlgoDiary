package algo.binarySearch;

import java.util.Arrays;

public class KokoEatingBananas_875 {
  public int minEatingSpeed(int[] piles, int h) {
    int minSpeed = 0, maxSpeed = Arrays.stream(piles).max().getAsInt();
    while (minSpeed < maxSpeed) {
      var mid = minSpeed + (maxSpeed - minSpeed) / 2;
      if (mid == 0) {
        return 1;
      }
      // check if we can eat all bananas with speed mid within h hours
      if (tryEat(piles, h, mid)) {
        maxSpeed = mid;
      } else {
        minSpeed = mid + 1;
      }
    }
    return minSpeed;
  }

  private boolean tryEat(final int[] piles, final int h, final int speed) {
    var time = 0;
    for (var pile : piles) {
      if (time > h) {
        return false;
      }
      if (speed >= pile) {
        time++;
      } else {
        var t = pile / speed;
        if (pile % speed != 0) {
          t++;
        }
        time += t;
      }
    }
    return time <= h;
  }
}
