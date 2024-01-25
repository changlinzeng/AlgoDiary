package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree_366 {
    public static List<List<Integer>> findLeaves(TreeNode root) {
        var allLeaves = new ArrayList<List<Integer>>();
        var isRoot = false;
        while (!isRoot) {
            var leaves = new ArrayList<Integer>();
            isRoot = dfs(root, leaves);
            allLeaves.add(new ArrayList<>(leaves));
        }
        return allLeaves;
    }

    private static boolean dfs(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return false;
        }
        if (isLeaf(node)) {
            leaves.add(node.val);
            // we are now at root
            return true;
        }
        if (isLeaf(node.left)) {
            leaves.add(node.left.val);
            node.left = null;
        } else {
            dfs(node.left, leaves);
        }
        if (isLeaf(node.right)) {
            leaves.add(node.right.val);
            node.right = null;
        } else {
            dfs(node.right, leaves);
        }
        return false;
    }

    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        var root = Tree.fromHeap(new Integer[]{1,2,3,4,5});
        findLeaves(root).forEach(System.out::println);
    }
}
