package algo.sort;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum_2195 {
    public static long minimalKSum2(int[] nums, int k) {
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

    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        var count = k;  // numbers to consume
        long sum = 0;
        for (var i = 0; i < nums.length; i++) {
            var numsToConsume = i == 0 ? nums[i] - 1 : nums[i] - nums[i - 1] - 1;
            long start = i == 0 ? 1 : nums[i - 1] + 1;
            long end = nums[i] - 1;
            if (numsToConsume <= 0) {
                continue;
            }
            count -= numsToConsume;
            if (count < 0) {
                count += numsToConsume;
                end = i == 0 ? k : nums[i - 1] + count;
                count = 0;
            }
            sum += (start + end) * (end - start + 1) / 2;
        }

        for (var j = 1; j <= count; j++) {
            sum += nums[nums.length - 1] + j;

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minimalKSum(new int[]{5,6}, 6));
        System.out.println(minimalKSum(new int[]{1,4,25,10,25}, 2));
        System.out.println(minimalKSum(new int[]{2,3,3}, 2));
    }
}
