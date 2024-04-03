package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.*;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 {
  public static int[] treeQueries(TreeNode root, int[] queries) {
    var len = queries.length;
    var result = new int[len];

    for (var i = 0; i < len; i++) {
      result[i] = dfs(root, queries[i]);
    }
    return result;
  }

  private static int dfs(TreeNode node, int q) {
    if (node == null) {
      return 0;
    }
    var height = 0;
    if (node.left != null) {
      if (node.left.val != q) {
        height = 1 + dfs(node.left, q);
      }
    }
    if (node.right != null) {
      if (node.right.val != q) {
        height = Math.max(height, 1 + dfs(node.right, q));
      }
    }
    return height;
  }

  public static void main(String[] args) {
    // TODO timeout
    var root = Tree.fromPreorder("5,8,2,4,null,null,6,null,null,1,null,null,9,3,null,null,7,null,null");
    System.out.println(Arrays.toString(treeQueries(root, new int[]{3, 2, 4, 8})));
  }
}
