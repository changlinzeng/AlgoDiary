package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class MaximumProductOfSplittedBinaryTree_1339 {
    private static final long mod = 1_000_000_007L;
    private static long max = 0;
    public static int maxProduct(TreeNode root) {
        long total = sum(root);
        product(root, total);
        return (int)(max % mod);
    }

    private static void product(TreeNode node, long total) {
        if (node == null) {
            return;
        }
        var nodeSum = sum(node);
        max = Math.max((total - nodeSum) * nodeSum, max);
        product(node.left, total);
        product(node.right, total);
    }

    private static long sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(Tree.fromHeap(new Integer[]{1,2,3,4,5,6})));
    }
}
