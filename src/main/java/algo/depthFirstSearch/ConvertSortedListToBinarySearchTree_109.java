package algo.depthFirstSearch;

import datautil.list.ListNode;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree_109 {
  public static TreeNode sortedListToBST(ListNode<Integer> head) {
    if (head == null) {
      return null;
    }
    var nodes = new ArrayList<Integer>();
    var cur = head;
    while (cur != null) {
      nodes.add(cur.val);
      cur = cur.next;
    }
    return buildTree(nodes, 0, nodes.size() - 1);
  }

  private static TreeNode buildTree(List<Integer> nodes, int start, int end) {
    if (start == end) {
      return new TreeNode(nodes.get(start));
    }
    var mid = start + (end - start) / 2;
    var root = new TreeNode(nodes.get(mid));
    if (start == mid) {
      root.right = new TreeNode(nodes.get(end));
    } else {
      root.left = buildTree(nodes, start, mid - 1);
      root.right = buildTree(nodes, mid + 1, end);
    }
    return root;
  }

  public static void main(String[] args) {
    sortedListToBST(datautil.list.List.fromArray(new Integer[]{-10,-3,0,5,9}).head);
    sortedListToBST(datautil.list.List.fromArray(new Integer[]{-10}).head);
  }
}
