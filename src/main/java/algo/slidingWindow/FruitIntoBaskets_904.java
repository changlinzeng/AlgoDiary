package algo.slidingWindow;

import java.util.HashMap;

public class FruitIntoBaskets_904 {
  public static int totalFruit(int[] fruits) {
    var freq = new HashMap<Integer, Integer>();
    int left = 0, right = 0;

    int maxlen = 0;
    while (right < fruits.length) {
      freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);

      if (freq.size() <= 2) {
        maxlen = Math.max(maxlen, right - left + 1);
      } else if (freq.size() > 2) {
        // move left till freq size is 2
        while (left < right) {
          if (freq.containsKey(fruits[left])) {
            var count = freq.get(fruits[left]);
            if (count == 1) {
              freq.remove(fruits[left]);
              left++;
              if (freq.size() == 2) {
                break;
              }
            } else {
              freq.put(fruits[left], freq.get(fruits[left]) - 1);
              left++;
            }
          }
        }
      }
      right++;
    }

    return maxlen;
  }

  public static void main(String[] args) {
    System.out.println(totalFruit(new int[]{1,2,1}));
    System.out.println(totalFruit(new int[]{0,1,2,2}));
    System.out.println(totalFruit(new int[]{1,2,3,2,2}));
    System.out.println(totalFruit(new int[]{0}));
  }
}
