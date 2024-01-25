package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

public class KthSmallestElementInABST_230 {
  private static int kth = 0;
  public static int kthSmallest(TreeNode root, int k) {
    dfs(root, k);
    return kth;
  }

  private static int dfs(TreeNode node, int k) {
    if (node == null) {
      return k;
    }
    if (k < 1) {
      return 0;
    }
    var kk = dfs(node.left, k);
    if (kk == 1) {
      kth = node.val;
      return 0;
    }
    kk--;
    return dfs(node.right, kk);
  }

  public static void main(String[] args) {
    var root = Tree.fromPreorderAndInorderTraverse(new int[]{3,1,2,4}, new int[]{1,2,3,4});
//    var root = Tree.fromPreorderAndInorderTraverse(new int[]{5,3,2,1,4,6}, new int[]{1,2,3,4,5,6});
    System.out.println(kthSmallest(root, 2));
  }
}
