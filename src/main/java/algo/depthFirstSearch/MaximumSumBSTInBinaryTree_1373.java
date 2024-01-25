package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class MaximumSumBSTInBinaryTree_1373 {
  private static int maxSum = Integer.MIN_VALUE;
  private static boolean allNegative = true;

  public static int maxSumBST(TreeNode root) {
    dfs(root);
    return allNegative ? 0 : maxSum;
  }

  private static void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    var result = checkBST(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
    if (result.isBST()) {
      maxSum = Math.max(maxSum, result.sum());
    }
    dfs(node.left);
    dfs(node.right);
  }

  private static Result checkBST(TreeNode node, int maxVal, int minVal) {
    if (node == null) {
      return new Result(true, 0);
    }
    if (node.val > 0) {
      allNegative = false;
    }
    if (node.val <= minVal || node.val >= maxVal) {
      return new Result(false, 0);
    }
    if (node.left != null && node.left.val >= node.val ||
            node.right != null && node.right.val <= node.val) {
      return new Result(false, 0);
    }
    var lResult = checkBST(node.left, node.val, minVal);
    var rResult = checkBST(node.right, maxVal, node.val);
    if (!lResult.isBST() || !rResult.isBST()) {
      return new Result(false, 0);
    }
    return new Result(true, lResult.sum() + rResult.sum() + node.val);
  }

  private record Result(boolean isBST, int sum) {}

  public static void main(String[] args) {
    var root = Tree.fromHeap(new Integer[]{4,3,null,1,2});
//    var root = Tree.fromHeap(new Integer[]{-4,-2,-5});
//    var root = Tree.deserialize("1,null,10,-5,null,null,20,null,null");
    System.out.println(maxSumBST(root));
  }
}
