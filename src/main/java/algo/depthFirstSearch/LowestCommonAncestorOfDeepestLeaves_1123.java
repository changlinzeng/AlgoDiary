package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves_1123 {
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        return findLeaves(root);
    }

    private static TreeNode findLeaves(TreeNode node) {
        if (node == null) {
            return null;
        }
        var leftMax = maxDepth(node.left);
        var rightMax = maxDepth(node.right);
        if (leftMax == rightMax) {
            return node;
        } else if (leftMax < rightMax) {
            return findLeaves(node.right);
        } else {
            return findLeaves(node.left);
        }
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public static void main(String[] args) {
//        var root = Tree.fromHeap(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
//        var root = Tree.fromHeap(new Integer[]{1});
        var root = Tree.fromHeap(new Integer[]{0,1,3,null,2});
        System.out.println(lcaDeepestLeaves(root).val);
    }
}
