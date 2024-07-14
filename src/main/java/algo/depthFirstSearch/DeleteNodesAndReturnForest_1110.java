package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest_1110 {
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        var roots = new ArrayList<TreeNode>();
        var toDelete = new HashSet<Integer>();
        for (var d : to_delete) {
            toDelete.add(d);
        }
        if (!toDelete.contains(root.val)) {
            roots.add(root);
        }
        delete(root, toDelete, null, roots);
        return roots;
    }

    private static void delete(TreeNode node, Set<Integer> toDelete, TreeNode parent, List<TreeNode> roots) {
        if (node == null) {
            return;
        }
        if (toDelete.contains(node.val)) {
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
                if (!toDelete.contains(left.val)) {
                    roots.add(left);
                }
                delete(left, toDelete, node, roots);
            }
            if (right != null) {
                if (!toDelete.contains(right.val)) {
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
