package algo.depthFirstSearch;

import datautil.tree.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees_652 {
  public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    var dup = new ArrayList<TreeNode>();
    dfs(root, new HashMap<String, TreeNode>(), dup, new HashSet<String>());
    return dup;
  }

  private static void dfs(TreeNode node, Map<String, TreeNode> inorderMap, List<TreeNode> dup, Set<String> roots) {
    if (node == null) {
      return;
    }

    var ser = inorder(node);
    if (inorderMap.containsKey(ser) && !roots.contains(ser)) {
      dup.add(node);
      roots.add(ser);
    } else {
      inorderMap.put(ser, node);
    }

    dfs(node.left, inorderMap, dup, roots);
    dfs(node.right, inorderMap, dup, roots);
  }

  private static String inorder(TreeNode node) {
    if (node == null) {
      return "#";
    }
    var ser = node.val + "";
    ser = ser + "," + inorder(node.left);
    ser = ser + "," + inorder(node.right);
    return ser;
  }
}
