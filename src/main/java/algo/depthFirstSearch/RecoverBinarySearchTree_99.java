package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree_99 {
    public static void recoverTree(TreeNode root) {
        var candidates = new ArrayList<TreeNode>();
        var prev = new TreeNode[2];

        inorder(root, null, prev, candidates);

        var node1 = candidates.get(0);
        var node2 = candidates.get(2);
        var temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

        // recover nodes
//        var node1 = candidates.get(0);
//        var parent1 = candidates.get(1);
//        var node2 = candidates.get(2);
//        var parent2 = candidates.get(3);
//        swapNode(node1, parent1, node2, parent2);
//        if (node1 == root) {
//            root = node2;
//        } else if (node2 == root) {
//            root = node1;
//        }
    }

    private static void inorder(TreeNode node, TreeNode parent, TreeNode[] prev, List<TreeNode> candidates) {
        if (node == null) {
            return;
        }
        inorder(node.left, node, prev, candidates);
        if (prev[0] != null && node.val < prev[0].val) {
            // found the swapped node
            if (candidates.isEmpty()) {
                candidates.add(prev[0]);
                candidates.add(prev[1]);
                candidates.add(node);
                candidates.add(parent);
            } else {
                if (candidates.size() == 4) {
                    candidates.remove(3);
                    candidates.remove(2);
                }
                candidates.add(node);
                candidates.add(parent);
            }
        }
        prev[0] = node;
        prev[1] = parent;
        inorder(node.right, node, prev, candidates);
    }

    public static void swapNode(TreeNode node1, TreeNode parent1, TreeNode node2, TreeNode parent2) {
        TreeNode par = null, child = null;
        if (node1.left == node2 || node1.right == node2) {
            par = node1;
            child = node2;
        }
        if (node2.left == node1 || node2.right == node1) {
            par = node2;
            child = node1;
        }
        if (par != null && child != null) {
            if (par.left == child) {
                var right = par.right;
                par.left = child.left;
                child.left = par;
                par.right = child.right;
                child.right = right;
            }
            if (par.right == child) {
                var left = par.left;
                par.right = child.right;
                child.right = par;
                par.left = child;
                child.left = left;
            }
            return;
        }
        var left = node1.left;
        var right = node1.right;
        node1.left = node2.left;
        node1.right = node2.right;
        node2.left = left;
        node2.right = right;
        if (parent1 != null) {
            if (parent1.left == node1) {
                parent1.left = node2;
            } else {
                parent1.right = node2;
            }
        }
        if (parent2 != null) {
            if (parent2.left == node2) {
                parent2.left = node1;
            } else {
                parent2.right = node1;
            }
        }
    }

    public static void main(String[] args) {
//        var tree = Tree.fromHeap(new Integer[]{1,3,null,null,2});
        var tree = Tree.fromHeap(new Integer[]{3,1,4,null,null,2});
        recoverTree(tree);

        var nodes = new ArrayList<Integer>();
        Tree.inorder(tree, nodes);
        System.out.println(nodes);
    }
}
