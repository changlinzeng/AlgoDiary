package algo.sort;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum_2195 {
    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        var len = nums.length;
        var start = 1;
        var pos = 0;
        long sum = 0L;
        while (pos < len) {
            for (var i = start; i < nums[pos] && k > 0; i++) {
                k--;
                sum += i;
            }
            start = nums[pos] + 1;
            pos++;
        }
        if (k > 0) {
            for (var i = nums[len - 1] + 1; k > 0; i++, k--) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minimalKSum(new int[]{5,6}, 6));
        System.out.println(minimalKSum(new int[]{1,4,25,10,25}, 2));
        System.out.println(minimalKSum(new int[]{2,3,3}, 2));
    }
}
