package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversalOfABinaryTree_987 {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        // inorder traversal and record nodes in each column
        var verticalOrder = new ArrayList<List<Integer>>();
        var columns = new HashMap<Integer, List<int[]>>();
        inorder(root, 0, 0, columns);
        columns.keySet().stream().sorted().forEach(k -> {
            var nodes = columns.get(k);
            nodes.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
            var list = new ArrayList<Integer>();
            nodes.forEach(n -> list.add(n[1]));
            verticalOrder.add(list);
        });
        return verticalOrder;
    }

    private static void inorder(TreeNode node, int row, int col, Map<Integer, List<int[]>> columns) {
        if (node == null) {
            return;
        }
        inorder(node.left, row + 1, col - 1, columns);
        if (columns.containsKey(col)) {
            columns.get(col).add(new int[]{row, node.val});
        } else {
            var column = new ArrayList<int[]>();
            column.add(new int[]{row, node.val});
            columns.put(col, column);
        }
        inorder(node.right, row + 1, col + 1, columns);
    }

    public static void main(String[] args) {
//        var root = Tree.fromHeap(new Integer[]{3,9,20,null,null,15,7});
        var root = Tree.fromHeap(new Integer[]{1,2,3,4,5,6,7});
        var result = verticalTraversal(root);
        result.forEach(System.out::println);
    }
}
