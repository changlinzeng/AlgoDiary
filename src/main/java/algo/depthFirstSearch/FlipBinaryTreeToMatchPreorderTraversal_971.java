package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipBinaryTreeToMatchPreorderTraversal_971 {
    private static int index = 0;
    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        var flipping = new ArrayList<Integer>();
        var flipped = new HashMap<TreeNode, Boolean>();
        if (!travel(root, null, voyage, flipped, flipping)) {
            return List.of(-1);
        }
        return flipping;
    }

    private static boolean travel(TreeNode node, TreeNode parent, int[] voyage, Map<TreeNode, Boolean> flipped,
                                  List<Integer> flipping) {
        if (node == null) {
            return true;
        }

        // root
        if (parent == null && node.val != voyage[index]) {
            return false;
        }
        if (node.val != voyage[index]) {
            // we already flipped this node with its sibling
            if (flipped.containsKey(node)) {
                return false;
            }
            if (parent != null && node == parent.right) {
                return false;
            }
            // we can not make correct order by flipping
            if (node == parent.left && (parent.right == null || parent.right.val != voyage[index])) {
                return false;
            }
            // flip
            var left = parent.left;
            parent.left = parent.right;
            parent.right = left;
            flipping.add(parent.val);
            flipped.put(left, true);
            node = parent.left;
        }

        index++;
        if (!travel(node.left, node, voyage, flipped, flipping)) {
            return false;
        }
        if (!travel(node.right, node, voyage, flipped, flipping)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        var root = Tree.fromHeap(new Integer[]{1,2});
//        System.out.println(flipMatchVoyage(root, new int[]{2,1}));
//        var root = Tree.fromHeap(new Integer[]{1,2,3});
//        System.out.println(flipMatchVoyage(root, new int[]{1,3,2}));
//        var root = Tree.fromHeap(new Integer[]{1,2,3});
//        System.out.println(flipMatchVoyage(root, new int[]{1,2,3}));
        var root = Tree.fromHeap(new Integer[]{2,1,4,5,null,3});
        System.out.println(flipMatchVoyage(root, new int[]{2,4,3,1,5}));
    }
}
