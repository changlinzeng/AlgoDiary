package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree_662 {
    private static int maxWidth = 0;
    public static int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0, new HashMap<>());
        return maxWidth;
    }

    private static void dfs(TreeNode node, int depth, int pos, Map<Integer, int[]> position) {
        if (node == null) {
            return;
        }
        position.putIfAbsent(depth, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
        var levelMinMax = position.get(depth);
        int min = levelMinMax[0], max = levelMinMax[1];
        levelMinMax[0] = Math.min(min, pos);
        levelMinMax[1] = Math.max(max, pos);
        maxWidth = Math.max(maxWidth, levelMinMax[1] - levelMinMax[0] +  1);
        dfs(node.left, depth + 1, pos * 2 + 1, position);
        dfs(node.right, depth + 1, pos * 2 + 2, position);
    }

    public static void main(String[] args) {
        var root = Tree.fromHeap(new Integer[]{1,3,2,5,3,null,9});
//        var root = Tree.fromHeap(new Integer[]{1,3,2,5,null,null,9,6,null,null,null,null,null,7});
        System.out.println(widthOfBinaryTree(root));
    }
}
