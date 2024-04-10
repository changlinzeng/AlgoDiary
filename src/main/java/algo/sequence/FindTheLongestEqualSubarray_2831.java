package algo.sequence;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class FindTheLongestEqualSubarray_2831 {
    public static int longestEqualSubarray2(List<Integer> nums, int k) {
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

    public static int longestEqualSubarray(List<Integer> nums, int k) {
        var count = new HashMap<Integer, Queue<Integer>>();  // number -> indices of number
        var longest = 0;
        for (var i = 0; i < nums.size(); i++) {
            var num = nums.get(i);
            count.computeIfAbsent(num, key -> new ArrayDeque<>()).offer(i);
            var q = count.get(num);
            // from the first index of num to current index i, there are i - q.peek() + 1 elements
            // we need to make sure there are no more than k numbers other than num in this range
            while (!q.isEmpty() && i - q.peek() + 1 - q.size() > k) {
                q.poll();
            }
            longest = Math.max(longest, q.size());
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestEqualSubarray(List.of(1,3,2,3,1,3), 3));
        System.out.println(longestEqualSubarray(List.of(1,1,2,2,1,1), 2));
        System.out.println(longestEqualSubarray(List.of(2,1), 0));
    }
}
