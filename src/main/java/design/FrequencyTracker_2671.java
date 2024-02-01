package design;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker_2671 {
  static class FrequencyTracker {
    private final Map<Integer, Integer> count;
    private final Map<Integer, Integer> freq;
    public FrequencyTracker() {
      count = new HashMap<>();
      freq = new HashMap<>();
    }

    public void add(int number) {
      var currentFreq = count.getOrDefault(number, 0);
      var newFreq = currentFreq + 1;
      count.put(number, newFreq);
      if (freq.containsKey(currentFreq)) {
        freq.put(currentFreq, freq.get(currentFreq) - 1);
        if (freq.get(currentFreq) == 0) {
          freq.remove(currentFreq);
        }
      }
      freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);
    }

    public void deleteOne(int number) {
      if (!count.containsKey(number)) {
        return;
      }
      var currentFreq = 0;
      if (count.get(number) == 1) {
        currentFreq = 1;
        count.remove(number);
      } else {
        currentFreq = count.get(number);
        count.put(number, currentFreq - 1);
      }
      freq.put(currentFreq, freq.get(currentFreq) - 1);
      if (freq.get(currentFreq) == 0) {
        freq.remove(currentFreq);
      }
      var newFreq = currentFreq - 1;
      freq.put(newFreq, freq.getOrDefault(newFreq, 0) + 1);
    }

    public boolean hasFrequency(int frequency) {
      return freq.containsKey(frequency);
    }
  }

  public static void main(String[] args) {
    var ft = new FrequencyTracker();
    ft.add(3);
    ft.add(6);
    ft.add(2);
    ft.add(6);
    ft.deleteOne(6);
    ft.deleteOne(6);
    ft.add(2);
    System.out.println(ft.hasFrequency(2));
    System.out.println(ft.hasFrequency(1));
  }
}
