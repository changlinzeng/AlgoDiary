package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LongestUnivaluePath_687 {
  private static int maxLen = 0;
  public static int longestUnivaluePath(TreeNode root) {
    dfs(root, new HashSet<>());
    return maxLen;
  }

  private static int dfs(TreeNode node, Set<TreeNode> visited) {
    if (node == null) {
      return 0;
    }
    if (visited.contains(node)) {
      return 0;
    }

    var leftVal = node.left == null ? Integer.MAX_VALUE : node.left.val;
    var rightVal = node.right == null ? Integer.MAX_VALUE : node.right.val;

    int leftLen = 0, rightLen = 0;
    if (leftVal == node.val) {
      leftLen += 1 + dfs(node.left, visited);
      visited.add(node.left);
    }
    if (rightVal == node.val) {
      rightLen += 1 + dfs(node.right, visited);
      visited.add(node.right);
    }
    var len = Math.max(leftLen, rightLen);
    maxLen = Math.max(len, maxLen);

    if (leftVal == node.val && rightVal == node.val) {
      maxLen = Math.max(maxLen, leftLen + rightLen);
    }

    dfs(node.left, visited);
    dfs(node.right, visited);

    return len;
  }

  public static void main(String[] args) {
//    var root = Tree.deserialize("5,4,1,null,null,1,null,null,5,null,5,null,null");
//    var root = Tree.deserialize("1,4,4,null,null,4,null,null,5,null,5,null,null");
    var root = Tree.fromPreorder("5,4,4,4,4,4,null,null,null,null,4,null,4,null,4,null,null,4,null,null,5,5,null,4,null,4,4,null,null,null,3,null,null");
    System.out.println(longestUnivaluePath(root));
  }
}
