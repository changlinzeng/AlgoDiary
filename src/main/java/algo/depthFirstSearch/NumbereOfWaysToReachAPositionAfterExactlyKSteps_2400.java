package algo.depthFirstSearch;

public class NumbereOfWaysToReachAPositionAfterExactlyKSteps_2400 {
    private static long steps = 0L;
    private static long moreSteps = 0L;
    private static final long mod = (long) Math.pow(10, 9) + 7;
    public static int numberOfWays(int startPos, int endPos, int k) {
        if (startPos > endPos) {
            var tmp = startPos;
            startPos = endPos;
            endPos = tmp;
        }
        var distance = endPos - startPos;
        if (distance > k) {
            return 0;
        }
        if (distance == k) {
            return 1;
        }
        var more = k - distance;
        if (more % 2 != 0){
            return 0;
        }

        dfs(more / 2, more / 2);
        steps = 1;
        for (var i = 0; i < endPos - startPos; i++) {
            steps = (steps + 1 + moreSteps) % mod;
        }
        return (int)steps;
    }

    private static void dfs(int leftSteps, int rightSteps) {
        if (leftSteps == 0 && rightSteps == 0) {
            moreSteps = (moreSteps + 1) % mod;
        }
        if (leftSteps > 0) {
            dfs(leftSteps - 1, rightSteps);
        }
        if (rightSteps > 0) {
            dfs(leftSteps, rightSteps - 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(numberOfWays(1, 2, 3));
//        System.out.println(numberOfWays(2, 5, 10));
//        System.out.println(numberOfWays(989, 1000, 39));
        System.out.println(numberOfWays(270, 272, 6));
    }
}
