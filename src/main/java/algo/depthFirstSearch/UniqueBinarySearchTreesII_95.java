package algo.depthFirstSearch;

import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {
  public static List<TreeNode> generateTrees(int n) {
    return dfs(1, n);
  }

  // build BST with nodes in range [from, to]
  private static List<TreeNode> dfs(int from, int to) {
    if (from == to) {
      return List.of(new TreeNode(from));
    }
    var nodes = new ArrayList<TreeNode>();
    // use from as root node and the nodes in [from + 1, to] is the right subtree
    for (var node : dfs(from + 1, to)) {
      var root = new TreeNode(from);
      root.right = node;
      nodes.add(root);
    }
    // use to as root node and the nodes in [from, to - 1] is the left subtree
    for (var node : dfs(from, to - 1)) {
      var root = new TreeNode(to);
      root.left = node;
      nodes.add(root);
    }
    // use i in [from + 1, to - 1] as root and build left and right subtrees
    for (var i = from + 1; i < to; i++) {
      var leftChildren = dfs(from, i - 1);
      var rightChildren = dfs(i + 1, to);
      for (var l : leftChildren) {
        for (var r : rightChildren) {
          var root = new TreeNode(i);
          root.left = l;
          root.right = r;
          nodes.add(root);
        }
      }
    }
    return nodes;
  }

  public static void main(String[] args) {
    var nodes = generateTrees(3);
    System.out.println(nodes);
  }
}
