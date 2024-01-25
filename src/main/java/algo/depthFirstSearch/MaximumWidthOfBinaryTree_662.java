package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree_662 {
    public static int widthOfBinaryTree(TreeNode root) {
        var min = new HashMap<Integer, Long>();
        var max = new HashMap<Integer, Long>();
        findPosition(root, 1, 1, min, max);

        int diff = 0;
        for (var lvl : min.keySet()) {
            diff = (int) Math.max(diff, max.get(lvl) - min.get(lvl));
        }
        return diff + 1;
    }

    private static void findPosition(TreeNode node, long pos, int level, Map<Integer, Long> min, Map<Integer, Long> max) {
        if (node.left != null) {
            long newPos = pos * 2 - 1;
            min.put(level, Math.min(min.getOrDefault(level, Long.MAX_VALUE), newPos));
            max.put(level, Math.max(max.getOrDefault(level, Long.MIN_VALUE), newPos));
            findPosition(node.left, newPos, level + 1, min, max);
        }
        if (node.right != null) {
            long newPos = pos * 2;
            min.put(level, Math.min(min.getOrDefault(level, Long.MAX_VALUE), newPos));
            max.put(level, Math.max(max.getOrDefault(level, Long.MIN_VALUE), newPos));
            findPosition(node.right, newPos, level + 1, min, max);
        }
    }

    public static void main(String[] args) {
        var root = Tree.fromHeap(new Integer[]{1,3,2,5,3,null,9});
//        var root = Tree.fromHeap(new Integer[]{1,3,2,5,null,null,9,6,null,null,null,null,null,7});
        System.out.println(widthOfBinaryTree(root));
        System.out.println(Integer.MAX_VALUE);
    }
}
