package algo.dp;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class HouseRobber_III_337 {
  public static int rob(TreeNode root) {
    return dfs(root);
  }

  private static int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    var sum = node.val;

    // rob root
    if (node.left != null) {
      sum += dfs(node.left.left) + dfs(node.left.right);
    }
    if (node.right != null) {
      sum += dfs(node.right.left) + dfs(node.right.right);
    }

    // do not rob root
    var sum1 = rob(node.left) + rob(node.right);

    return Math.max(sum, sum1);
  }

  public static void main(String[] args) {
//    var root = Tree.deserialize("3,2,null,3,null,null,3,null,1,null,null");
    var root = Tree.fromPreorder("3,4,1,null,null,3,null,null,5,null,1,null,null");
//    var root = Tree.deserialize("1,2,null,null,3,null,null");
    System.out.println(rob(root));
  }
}
