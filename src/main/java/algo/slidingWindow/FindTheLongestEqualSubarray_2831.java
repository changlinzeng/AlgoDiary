package algo.slidingWindow;

import java.util.HashMap;
import java.util.List;

public class FindTheLongestEqualSubarray_2831 {
    public static int longestEqualSubarray(List<Integer> nums, int k) {
        var len = nums.size();
        var freq = new HashMap<Integer, Integer>();
        int i = 0, j = 0, longest = 0, max = -1;
        while (j < len) {
            var wlen = j - i + 1;
            int left = nums.get(i), right = nums.get(j);

            freq.put(right, freq.getOrDefault(right, 0) + 1);
            if (max == -1 || freq.get(max) < freq.get(right)) {
                max = right;
            }

            if (wlen - freq.get(max) <= k) {
                longest = Math.max(longest, freq.get(max));
                j++;
            } else {
                freq.put(left, freq.get(left) - 1);
                i++;
                j++;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestEqualSubarray(List.of(1,3,2,3,1,3), 3));
        System.out.println(longestEqualSubarray(List.of(1,1,2,2,1,1), 2));
        System.out.println(longestEqualSubarray(List.of(2,1), 0));
    }
}
