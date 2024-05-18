package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree_99 {
    public static void recoverTree(TreeNode root) {
        var candidates = new ArrayList<TreeNode[]>();  // list of (node, parent)
        var prev = new TreeNode[2];  // tuple of (node, parent)

        inorder(root, null, prev, candidates);

        var node1 = candidates.get(0)[0];
        var node2 = candidates.get(1)[0];
        var temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private static void inorder(TreeNode node, TreeNode parent, TreeNode[] prev, List<TreeNode[]> candidates) {
        if (node == null) {
            return;
        }
        inorder(node.left, node, prev, candidates);
        if (prev[0] != null && prev[0].val > node.val) {
            if (candidates.size() == 2) {
                candidates.removeLast();
            } else if (candidates.isEmpty()) {
                candidates.add(new TreeNode[]{prev[0], prev[1]});
            }
            candidates.add(new TreeNode[]{node, parent});
        }
        prev[0] = node;
        prev[1] = parent;
        inorder(node.right, node, prev, candidates);
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
