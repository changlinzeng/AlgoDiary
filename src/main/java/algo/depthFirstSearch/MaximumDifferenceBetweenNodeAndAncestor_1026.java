package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor_1026 {

    private static int maxDiff = 0;

    public static int maxAncestorDiff(TreeNode root) {
        findMinMax(root);
        return maxDiff;
    }

    private static MinMax findMinMax(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new MinMax(node.val, node.val);
        }

        MinMax leftMinMax = new MinMax(), rightMinMax = new MinMax();
        if (node.left != null) {
            leftMinMax = findMinMax(node.left);
        }
        if (node.right != null) {
            rightMinMax = findMinMax(node.right);
        }
        var min = Math.min(node.val, Math.min(leftMinMax.min, rightMinMax.min));
        var max = Math.max(node.val, Math.max(leftMinMax.max, rightMinMax.max));
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
        return new MinMax(min, max);
    }

    static class MinMax {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        public MinMax() {}
        public MinMax(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
//        var root = Tree.fromHeap(new Integer[]{1,null,2,null,null,null,0,null,null,null,null,null,null,3});
        var root = Tree.fromHeap(new Integer[]{8,3,10,1,6,null,14,null,null,4,7,null,null,13});
        System.out.println(maxAncestorDiff(root));
    }
}
