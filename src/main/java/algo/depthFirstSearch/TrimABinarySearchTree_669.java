package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;

public class TrimABinarySearchTree_669 {
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        // remove the left tree of low and right tree of high
        return dfs(root, null, low, high);
    }

    public static TreeNode dfs(TreeNode node, TreeNode parent, int low, int high) {
        if (node == null) {
            return null;
        }
        if (low == node.val) {
            node.left = null;
            dfs(node.right, node, low, high);
            return node;
        }
        if (high == node.val) {
            node.right = null;
            dfs(node.left, node, low, high);
            return node;
        }
        if (node.val < low && parent != null && parent.val >= low) {
            parent.left = node.right;
            dfs(parent.left, parent, low, high);
            return parent;
        }
        if (node.val > high && parent != null && parent.val <= high) {
            parent.right = node.left;
            dfs(parent.right, parent, low, high);
            return parent;
        }
        if (low > node.val) {
            return dfs(node.right, null, low, high);
        } else if (high < node.val) {
            return dfs(node.left, null, low, high);
        } else {
            dfs(node.left, node, low, high);
            dfs(node.right, node, low, high);
            return node;
        }
    }

    public static void main(String[] args) {
//        var bst = Tree.fromHeap(new Integer[]{1,0,2});
        var bst = Tree.fromHeap(new Integer[]{3,0,4,null,2,null,null,null,null,1});
        var root = trimBST(bst, 1, 3);
        var nodes = new ArrayList<Integer>();
        Tree.inorder(root, nodes);
        System.out.println(nodes);
    }
}
