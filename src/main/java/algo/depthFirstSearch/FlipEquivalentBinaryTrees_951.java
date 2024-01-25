package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class FlipEquivalentBinaryTrees_951 {
  public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
    return flip(root1, root2);
  }

  private static boolean flip(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null && node2 != null || node1 != null && node2 == null) {
      return false;
    }
    if (node1 != null && node2 != null && node1.val != node2.val) {
      return false;
    }
    if ((node1.left == null && node2.left == null ||
            node1.left != null && node2.left != null && node1.left.val == node2.left.val) &&
            (node1.right == null && node2.right == null ||
                    node1.right != null && node2.right != null && node1.right.val == node2.right.val)) {
      // do nothing
    } else {
      // flip
      var tmp = node1.left;
      node1.left = node1.right;
      node1.right = tmp;
    }

    return flip(node1.left, node2.left) && flip(node1.right, node2.right);
  }

  public static void main(String[] args) {
    var root1 = Tree.fromHeap(new Integer[]{1,2,3,4,5,6,null,null,7,8});
    var root2 = Tree.fromHeap(new Integer[]{1,3,2,null,6,4,5,null,null,null,null,null,null,8,7});
    System.out.println(flipEquiv(root1, root2));
  }
}
