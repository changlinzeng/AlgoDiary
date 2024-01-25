package algo.breadthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_II_107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
//        var levels = new Stack<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        var result = new ArrayList<List<Integer>>();
        var nodeNum = 1;

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            var levelNodes = new ArrayList<Integer>();
            var childNum = 0;
            for (var i = 0; i < nodeNum; i++) {
                var node = queue.pop();
                levelNodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    childNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    childNum++;
                }
            }
//            levels.push(levelNodes);
            result.add(0, levelNodes);
            nodeNum = childNum;
        }

//        while (!levels.isEmpty()) {
//            result.add(levels.pop());
//        }
        return result;
    }

    public static List<List<Integer>> levelOrderBottomWithDfs(TreeNode root) {
        var levels = new TreeMap<Integer, List<Integer>>();
        dfs(root, 0, levels);
        return new ArrayList<>(levels.reversed().values());
    }

    private static void dfs(TreeNode node, int level, Map<Integer, List<Integer>> levels) {
        if (node == null) {
            return;
        }
        dfs(node.left, level + 1, levels);
        dfs(node.right, level + 1, levels);
        if (!levels.containsKey(level)) {
            levels.put(level, new ArrayList<>());
        }
        levels.get(level).add(node.val);
    }

    public static void main(String[] args) {
        var root = Tree.fromHeap(new Integer[]{3,9,20,null,null,15,7});
        var levels = levelOrderBottom(root);
//        var levels = levelOrderBottomWithDfs(root);
        levels.forEach(System.out::println);
    }
}
