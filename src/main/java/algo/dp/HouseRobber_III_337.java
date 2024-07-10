package algo.dp;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber_III_337 {
  public static int rob(TreeNode root) {
    return dfs(root, new HashMap<>());
  }

  private static int dfs(TreeNode node, Map<TreeNode, Integer> dp) {
    if (node == null) {
      return 0;
    }

    if (dp.containsKey(node)) {
      return dp.get(node);
    }

    var sum1 = node.val;

    // rob root
    if (node.left != null) {
      sum1 += dfs(node.left.left, dp) + dfs(node.left.right, dp);
    }
    if (node.right != null) {
      sum1 += dfs(node.right.left, dp) + dfs(node.right.right, dp);
    }

    // do not rob root
    var sum2 = dfs(node.left, dp) + dfs(node.right, dp);

    var maxSum = Math.max(sum1, sum2);
    dp.putIfAbsent(node, maxSum);
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(rob(Tree.deserialize("3,2,null,3,null,null,3,null,1,null,null")));
    System.out.println(rob(Tree.fromPreorder("3,4,1,null,null,3,null,null,5,null,1,null,null")));
    System.out.println(rob(Tree.deserialize("1,2,null,null,3,null,null")));
  }
}
