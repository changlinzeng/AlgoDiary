package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes_865 {
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        return findNode(root);
    }

    private static TreeNode findNode(TreeNode node) {
        var leftDepth = maxDepth(node.left);
        var rightDepth = maxDepth(node.right);
        if (leftDepth == rightDepth) {
            return node;
        } else if (leftDepth < rightDepth) {
            return findNode(node.right);
        } else {
            return findNode(node.left);
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
        System.out.println(subtreeWithAllDeepest(root).val);
    }
}
