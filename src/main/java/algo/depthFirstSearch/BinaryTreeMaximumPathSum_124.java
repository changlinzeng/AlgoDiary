package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class BinaryTreeMaximumPathSum_124 {

  private static int maxSum = Integer.MIN_VALUE;

  public static int maxPathSum(TreeNode root) {
    findMaxPath(root);
    return maxSum;
  }

  private static void findMaxPath(TreeNode root) {
    var sum = root.val;
    int leftSum = 0, rightSum = 0;
    if (root.left != null) {
      leftSum = pathSum(root.left);
    }
    if (root.right != null) {
      rightSum = pathSum(root.right);
    }
    if (leftSum > 0) {
      sum += leftSum;
    }
    if (rightSum > 0) {
      sum += rightSum;
    }
    maxSum = Math.max(maxSum, sum);
    if (root.left != null) {
      findMaxPath(root.left);
    }
    if (root.right != null) {
      findMaxPath(root.right);
    }
  }

  /**
   * Find the max path sum from node to leaves
   */
  private static int pathSum(TreeNode node) {
    var sum = node.val;
    int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
    if (node.left != null) {
      leftSum = pathSum(node.left);
    }
    if (node.right != null) {
      rightSum = pathSum(node.right);
    }
    return sum + Math.max(0, Math.max(leftSum, rightSum));
  }

  public static void main(String[] args) {
//    var root = Tree.fromHeap(new Integer[]{1,2,3});
    var root = Tree.fromHeap(new Integer[]{-10,9,20,null,null,15,7});
    System.out.println(maxPathSum(root));
  }
}
