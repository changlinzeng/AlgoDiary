package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class FlipEquivalentBinaryTrees_951 {
  public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
    return flip(root1, root2);
  }

  private static boolean flip(TreeNode node1, TreeNode node2) {
    int invalidVal = -1;
    if (node1 == null && node2 == null) {
      return true;
    }
    int val1 = node1 == null ? invalidVal : node1.val;
    int val2 = node2 == null ? invalidVal : node2.val;
    if (val1 != val2) {
      return false;
    }

    int leftVal1 = node1 == null ? -1 : (node1.left == null ? -1 : node1.left.val);
    int rightVal1 = node1 == null ? -1 : (node1.right == null ? -1 : node1.right.val);
    int leftVal2 = node2 == null ? -1 : (node2.left == null ? -1 : node2.left.val);
    int rightVal2 = node2 == null ? -1 : (node2.right == null ? -1 : node2.right.val);
    if (leftVal1 == leftVal2 && rightVal1 == rightVal2) {
      return flip(node1.left, node2.left) && flip(node1.right, node2.right);
    }
    if (leftVal1 == rightVal2 && leftVal2 == rightVal1) {
      return flip(node1.left, node2.right) && flip(node1.right, node2.left);
    }
    return false;
  }

  public static void main(String[] args) {
    var root1 = Tree.fromHeap(new Integer[]{1,2,3,4,5,6,null,null,7,8});
    var root2 = Tree.fromHeap(new Integer[]{1,3,2,null,6,4,5,null,null,null,null,null,null,8,7});
    System.out.println(flipEquiv(root1, root2));
  }
}
