package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;

public class DeleteNodeInBST_450 {
  public static TreeNode deleteNode(TreeNode root, int key) {
    TreeNode par = new TreeNode(), cur = root;
    par.left = root;
    while (cur != null && cur.val != key) {
      par = cur;
      if (cur.val > key) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    // target node not found
    if (cur == null) {
      return root;
    }

    TreeNode left = cur.left, right = cur.right;
    cur.left = null;
    cur.right = null;

    if (right == null) {
      // right child of target node is null so replace target with its left child
      if (par.left == cur) {
        par.left = left;
      }
      if (par.right == cur) {
        par.right = left;
      }
      if (cur == root) {
        root = left;
      }
    } else {
      // replace target with its right child and then append left child to the left most child of right subtree
      if (par.left == cur) {
        par.left = right;
      }
      if (par.right == cur) {
        par.right = right;
      }
      if (cur == root) {
        root = right;
      }
      // append left to the left most child of the right subtree of target
      var leftMost = right;
      while (leftMost.left != null) {
        leftMost = leftMost.left;
      }
      leftMost.left = left;
    }

    return root;
  }

  public static void main(String[] args) {
//    var root = Tree.fromHeap(new Integer[]{5,2,6,null,4,null,7});
//    var root = Tree.fromHeap(new Integer[]{5,3,6,2,4,null,7});
//    var root = Tree.fromHeap(new Integer[]{5});
    var root = Tree.fromHeap(new Integer[]{1,null,3,null,null,4,5});
    var newroot = deleteNode(root, 1);
    var nodes = new ArrayList<Integer>();
    Tree.inorder(newroot, nodes);
    nodes.forEach(System.out::println);
  }
}
