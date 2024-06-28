package algo.depthFirstSearch;

import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_II_113 {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    var paths = new ArrayList<List<Integer>>();
    dfs(root, targetSum, new ArrayList<>(), paths);
    return paths;
  }

  private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> paths) {
    if (node == null) {
      return;
    }
    if (target == node.val && node.left == null && node.right == null) {
      path.add(node.val);
      paths.add(new ArrayList<>(path));
      return;
    }
    path.add(node.val);
    dfs(node.left, target - node.val, new ArrayList<>(path), paths);
    dfs(node.right, target - node.val, new ArrayList<>(path), paths);
  }
}
