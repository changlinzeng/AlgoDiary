package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueriesInABinarySearchTree_2476 {
  public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
    var nodes = new ArrayList<Integer>();
    inorder(root, nodes);

    var result = new ArrayList<List<Integer>>();
    for (var num : queries) {
      // binary search
      result.add(search(num, nodes));
    }
    return result;
  }

  private static List<Integer> search(int val, List<Integer> nums) {
    var len = nums.size();
    int start = 0, end = len - 1, mid = 0;

    if (val == nums.getFirst() || val == nums.getLast()) {
      return List.of(val, val);
    }
    if (val > nums.getLast()) {
      return List.of(nums.getLast(), -1);
    }
    if (val < nums.getFirst()) {
      return List.of(-1, nums.getFirst());
    }
    while (start < end) {
      mid = start + (end - start) / 2;
      if (mid == start) {
        return List.of(nums.get(mid), nums.get(end));
      }
      if (nums.get(mid) == val) {
        return List.of(val, val);
      } else if (nums.get(mid) < val) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return List.of(-1, -1);
  }

  private static void inorder(TreeNode node, List<Integer> result) {
    if (node == null) {
      return;
    }
    inorder(node.left, result);
    result.add(node.val);
    inorder(node.right, result);
  }

  public static void main(String[] args) {
//    var root = Tree.deserialize("6,2,13,1,4,9,15,null,null,null,null,null,null,14");
//    closestNodes(root, List.of(2, 5, 16)).forEach(System.out::println);
    var root = Tree.deserialize("4,null,9");
    closestNodes(root, List.of(3)).forEach(System.out::println);
  }
}
