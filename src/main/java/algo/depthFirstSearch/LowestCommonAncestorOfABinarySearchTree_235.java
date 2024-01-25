package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree_235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        if (p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val) {
            return root;
        }
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        var root = Tree.fromHeap(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        var ancestor = lowestCommonAncestor(root, root.left.right.left, root.left.right.right);
        System.out.println(ancestor.val);
    }
}
