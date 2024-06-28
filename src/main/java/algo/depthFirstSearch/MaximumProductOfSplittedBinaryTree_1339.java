package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfSplittedBinaryTree_1339 {
    private static final long mod = 1_000_000_007L;
    public static int maxProduct(TreeNode root) {
        long max = 0;
        var subTreeSum = new HashMap<TreeNode, Long>();
        long total = sum(root, subTreeSum);
        for (var kv : subTreeSum.entrySet()) {
            max = Math.max(max, kv.getValue() * (total - kv.getValue()));
        }
        return (int)(max % mod);
    }

    private static long sum(TreeNode node, Map<TreeNode, Long> subTreeSum) {
        if (node == null) {
            return 0;
        }
        long sum = node.val + sum(node.left, subTreeSum) + sum(node.right, subTreeSum);
        subTreeSum.put(node, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(Tree.fromHeap(new Integer[]{1,2,3,4,5,6})));
    }
}
