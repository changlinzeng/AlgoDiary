package algo.interval;

import java.util.*;

public class PartitionLabels_763 {
  public static List<Integer> partitionLabels(String s) {
    var len = s.length();
    var result = new ArrayList<Integer>();
    var freq = new HashMap<Character, Integer>();
    var visit = new int[26];
    Arrays.fill(visit, 0);

    for (int i = 0; i < len; i++) {
      var c = s.charAt(i);
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    int sum, last = 0;
    for (int i = 0; i < len; i++) {
      var ch = s.charAt(i);
      visit[ch - 'a'] = 1;
      // consume the char
      freq.put(ch, freq.get(ch) - 1);

      // calculate the total number of chars left
      sum = 0;
      for (int j = 0; j < visit.length; j++) {
        if (visit[j] == 1) {
          sum += freq.get((char)('a' + j));
        }
      }

      if (sum == 0) {
        var section = i - last + 1;
        last += section;
        result.add(section);
      }
    }

    return result;
  }

  public static List<Integer> partitionLabels2(String s) {
    var len = s.length();
    var result = new ArrayList<Integer>();
    var freq = new HashMap<Character, Integer>();
    var count = new HashMap<Character, Integer>();

    for (int i = 0; i < len; i++) {
      var c = s.charAt(i);
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < len; i++) {
      var ch = s.charAt(i);
      count.put(ch, count.getOrDefault(ch, 0) + 1);

      var cleared = true;
      var size = 0;
      for (var key : count.keySet()) {
        if (count.get(key).compareTo(freq.get(key)) != 0) {
          cleared = false;
          break;
        }
        size += count.get(key);
      }

      if (cleared) {
        result.add(size);
        count.clear();
      }
    }

    return result;
  }

  private static List<Integer> partitionLabels3(String s) {
    // record the first and last occurrence of each char and then we can transform to merge intervals
    var position = new HashMap<Character, int[]>();
    for (var i = 0; i < s.length(); i++) {
      var c = s.charAt(i);
      if (position.containsKey(c)) {
        position.get(c)[1] = i;
      } else {
        position.put(c, new int[]{i, i});
      }
    }
    var intervals = new int[position.size()][];
    position.values().toArray(intervals);
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    var partition = new ArrayList<Integer>();
    var part = intervals[0];
    for (var interval : intervals) {
      if (interval[0] <= part[1]) {
        part[1] = Math.max(part[1], interval[1]);
      } else {
        partition.add(part[1] - part[0] + 1);
        part = interval;
      }
    }
    partition.add(part[1] - part[0] + 1);

    return partition;
  }

  public static void main(String[] args) {
//    var partition = partitionLabels3("ababcbacadefegdehijhklij");
    var partition = partitionLabels("eccbbbbdec");
    for (var i : partition) {
      System.out.println(i);
    }
  }
}
