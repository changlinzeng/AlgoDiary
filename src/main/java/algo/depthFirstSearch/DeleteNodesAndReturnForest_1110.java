package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteNodesAndReturnForest_1110 {
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        var roots = new ArrayList<TreeNode>();
        var toDelete = new HashMap<Integer, Integer>();
        for (var d : to_delete) {
            toDelete.put(d, 1);
        }
        if (!toDelete.containsKey(root.val)) {
            roots.add(root);
        }
        delete(root, toDelete, null, roots);
        return roots;
    }

    private static void delete(TreeNode node, Map<Integer, Integer> toDelete, TreeNode parent, List<TreeNode> roots) {
        if (node == null) {
            return;
        }
        if (toDelete.containsKey(node.val)) {
            var left = node.left;
            var right = node.right;
            node.left = null;
            node.right = null;
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if (left != null) {
                if (!toDelete.containsKey(left.val)) {
                    roots.add(left);
                }
                delete(left, toDelete, node, roots);
            }
            if (right != null) {
                if (!toDelete.containsKey(right.val)) {
                    roots.add(right);
                }
                delete(right, toDelete, node, roots);
            }
        } else {
            delete(node.left, toDelete, node, roots);
            delete(node.right, toDelete, node, roots);
        }
    }

    public static void main(String[] args) {
//        var root = Tree.fromHeap(new Integer[]{1,2,3,4,5,6,7});
        var root = Tree.fromHeap(new Integer[]{1,2,4,null,3});
        var roots = delNodes(root, new int[]{3,5});
        roots.forEach(r -> System.out.println(r.val));
    }
}
