package data.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StepsToMakeArrayNonDecreasing_2289 {
    private static int steps = 0;
    public static int totalSteps(int[] nums) {
        var list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        makeStepRecursive(list);
        return steps;
    }

    private static int makeStep(int[] nums) {
        var steps = 0;
        var removed = new boolean[nums.length];
        for (;;) {
            var canRemove = false;
            int i = 0, j = 0;
            while (i < nums.length) {
                while (i < nums.length && removed[i]) {
                    i++;
                }
                j = i;
                while (j < nums.length - 1) {
                    var n = next(nums, j, removed);
                    if (nums[n] < nums[j]) {
                        j = n;
                    } else {
                        break;
                    }
                }
                // remove from i + 1 to j
                i++;
                while (i <= j) {
                    if (!removed[i]) {
                        removed[i] = true;
                        canRemove = true;
                    }
                    i++;
                }
            }
            if (!canRemove) {
                break;
            }
            steps++;
        }
        return steps;
    }

    private static int next(int[] nums, int cur, boolean[] removed) {
        var k = cur + 1;
        while (k < nums.length && removed[k]) {
            k++;
        }
        return k > nums.length - 1 ? cur : k;
    }

    private static void makeStepRecursive(List<Integer> nums) {
        var canRemove = false;
        int i = 0, j = 0, len = nums.size();
        var left = new ArrayList<Integer>();
        while (i < len - 1) {
            if (nums.get(i) > nums.get(i + 1)) {
                canRemove = true;
                j = i + 1;
                while (j < len - 1 && nums.get(j) > nums.get(j + 1)) {
                    j++;
                }
                // remove from i + 1 to j
                for (var k = i + 1; k <= j; k++) {
                }
                left.add(nums.get(i));
                i = j + 1;
            } else {
                left.add(nums.get(i++));
            }
        }
        while (i < len) {
            left.add(nums.get(i++));
        }
        if (canRemove) {
            steps++;
            makeStepRecursive(left);
        }
    }

    public static void main(String[] args) {
        System.out.println(totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11}));
        System.out.println(totalSteps(new int[]{4,5,7,7,13}));
        System.out.println(totalSteps(new int[]{10,1,2,3,4,5,6,1,2,3}));
    }
}
