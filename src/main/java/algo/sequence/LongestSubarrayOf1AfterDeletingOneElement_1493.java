package algo.sequence;

import java.util.ArrayList;

public class LongestSubarrayOf1AfterDeletingOneElement_1493 {
    public static int longestSubarray(int[] nums) {
        // find positions of zero and calculate the length by removing zero one by one
        var zeroPosition = new ArrayList<Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPosition.add(i);
            }
        }

        if (zeroPosition.isEmpty() || zeroPosition.size() == 1) {
            return nums.length - 1;
        }

        var max = 0;
        var pos = new Integer[zeroPosition.size()];
        zeroPosition.toArray(pos);
        for (var i = 0; i < pos.length; i++) {
            if (i == 0) {
                // remove first
                max = pos[1] - 1;
            } else if (i == pos.length - 1) {
                // remove last
                max = Math.max(max, nums.length - pos[i - 1] - 2);
            } else {
                max = Math.max(max, pos[i + 1] - pos[i - 1] - 2);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,1}));
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
    }
}
