package algo.depthFirstSearch;

import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees_894 {
  public static List<TreeNode> allPossibleFBT(int n) {
    // n should be odd to build full binary tree
    if (n % 2 == 0) {
      return List.of();
    }
    return dfs(n);
  }

  private static List<TreeNode> dfs(int n) {
    var nodes = new ArrayList<TreeNode>();
    if (n == 1) {
      nodes.add(new TreeNode(0));
      return nodes;
    }
    n--;
    for (var i = 1; i < n; i += 2) {
      var leftChildren = dfs(i);
      var rightChildren = dfs(n - i);
      for (var leftChild : leftChildren) {
        for (var rightChild : rightChildren) {
          var parent = new TreeNode(0);
          parent.left = leftChild;
          parent.right = rightChild;
          nodes.add(parent);
        }
      }
    }
    return nodes;
  }

  public static void main(String[] args) {
    allPossibleFBT(7).forEach(System.out::println);
  }
}
