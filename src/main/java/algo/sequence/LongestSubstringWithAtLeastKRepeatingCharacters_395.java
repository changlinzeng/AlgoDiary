package algo.sequence;

import java.util.HashMap;

public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {
  public static int longestSubstring(String s, int k) {
    // calculate frequency
    var freq = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
    }

    // find the character whose presents are less than k
    var delimeter = "";
    for (var entry : freq.entrySet()) {
      if (entry.getValue() < k) {
        delimeter = entry.getKey() + "";
      }
    }

    // we find a qualified string and return the length
    if ("".equals(delimeter)) {
      return s.length();
    }

    var max = 0;
    for (var segment : s.split(delimeter)) {
      max = Math.max(max, longestSubstring(segment, k));
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestSubstring("aaabb", 3));
    System.out.println(longestSubstring("ababbc", 2));
  }
}
