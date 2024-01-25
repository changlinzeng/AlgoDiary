package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeToGreaterSumTree_1038 {
    public static TreeNode bstToGst(TreeNode root) {
        var nodes = new ArrayList<TreeNode>();
        inorder(root, nodes);
        var sum = 0;
        for (var i = nodes.size() - 1; i >= 0; i--) {
            sum += nodes.get(i).val;
            nodes.get(i).val = sum;
        }
        return root;
    }

    private static void inorder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        inorder(node.left, nodes);
        nodes.add(node);
        inorder(node.right, nodes);
    }

    public static void main(String[] args) {
        var root = Tree.fromHeap(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        bstToGst(root);

        var nodes = new ArrayList<Integer>();
        Tree.inorder(root, nodes);
        nodes.forEach(System.out::println);
    }
}
