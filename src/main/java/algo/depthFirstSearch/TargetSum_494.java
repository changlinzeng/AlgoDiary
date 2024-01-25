package algo.depthFirstSearch;

public class TargetSum_494 {
    private static int ways = 0;
    public static int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return ways;
    }

    private static void dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) {
                ways++;
            }
            return;
        }
        dfs(nums, index + 1, target - nums[index]);
        dfs(nums, index + 1, target + nums[index]);
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
