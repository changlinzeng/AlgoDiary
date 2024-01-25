package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class LowestCommonAncestorOfABinaryTree_236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        var tp = findNode(root.left, p);
        var tq = findNode(root.left, q);
        if (tp == null && tq == null) {
            // both are on the right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        if (tp != null && tq != null) {
            // both are on the left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    private static TreeNode findNode(TreeNode node, TreeNode target) {
        if (node == null || node == target) {
            return node;
        }
        TreeNode nd = findNode(node.left, target);
        if (nd == null) {
            nd = findNode(node.right, target);
        }
        return nd;
    }

    public static void main(String[] args) {
        var root = Tree.fromHeap(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        var ancestor = lowestCommonAncestor(root, root.left.left, root.left.right);
        System.out.println(ancestor.val);
    }
}
