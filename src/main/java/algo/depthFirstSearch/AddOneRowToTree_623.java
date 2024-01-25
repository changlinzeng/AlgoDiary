package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;

public class AddOneRowToTree_623 {
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            var newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        dfs(root, val, depth - 1, 0);
        return root;
    }

    private static void dfs(TreeNode node, int val, int depth, int currentDepth) {
        if (node == null) {
            return;
        }
        var level = currentDepth + 1;
        if (level == depth) {
            // insert row under level
            var newLeft = new TreeNode(val);
            newLeft.left = node.left;
            node.left = newLeft;

            var newRight = new TreeNode(val);
            newRight.right = node.right;
            node.right = newRight;
            return;
        }
        dfs(node.left, val, depth, level);
        dfs(node.right, val, depth, level);
    }

    public static void main(String[] args) {
//        var root = Tree.fromHeap(new Integer[]{4,2,6,3,1,5});
//        addOneRow(root, 1, 2);

        var root = Tree.fromHeap(new Integer[]{1,2,3,4});
        addOneRow(root, 5, 4);

        var nodes = new ArrayList<Integer>();
        Tree.inorder(root, nodes);
        System.out.println(nodes);
    }
}
