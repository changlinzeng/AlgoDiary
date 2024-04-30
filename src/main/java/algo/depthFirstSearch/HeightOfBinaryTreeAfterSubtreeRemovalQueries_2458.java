package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.*;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 {
  private static final Map<Integer, List<Integer>> levelNodes = new HashMap<>();  // nodes at depth
  private static final Map<Integer, int[]> depthHeight = new HashMap<>();  // depth and height of subtree
  private static final Map<Integer, int[]> maxSubtree = new HashMap<>();  // subtree with max height at depth
  public static int[] treeQueries(TreeNode root, int[] queries) {
    // when we remove one node, then we need to search the deepest node from current level
    // so we find all the siblings of the node and calculate the depth and height of the node
    var len = queries.length;
    var result = new int[len];

    if (levelNodes.isEmpty()) {
      calculateDepthAndHeight(root, 0, depthHeight, levelNodes);
    }

    for (var i = 0; i < len; i++) {
      var q = queries[i];
      var depth = depthHeight.get(q)[0];
      var siblings = levelNodes.get(depth);
      if (siblings.size() == 1) {
        result[i] = depth - 1;
      } else {
        if (q != maxSubtree.get(depth)[0]) {
          // if we do not remove the node with the max height, then use the max height at that depth
          result[i] = maxSubtree.get(depth)[1] + depth;
        } else {
          // if we remove the subtree with the max height at depth, then we need to recalculate max height
          var maxHeight = 0;
          for (var n : siblings) {
            if (n != q) {
              maxHeight = Math.max(maxHeight, depthHeight.get(n)[1]);
            }
          }
          result[i] = maxHeight + depth;
        }
      }
    }
    return result;
  }

  // calculate the depth of node and height of subtree rooted at node
  private static int calculateDepthAndHeight(TreeNode root, int depth, Map<Integer, int[]> depthHeight, Map<Integer, List<Integer>> levelNodes) {
    int leftH = 0, rightH = 0;
    if (root.left != null) {
      leftH = 1 + calculateDepthAndHeight(root.left, depth + 1, depthHeight, levelNodes);
    }
    if (root.right != null) {
      rightH = 1 + calculateDepthAndHeight(root.right, depth + 1, depthHeight, levelNodes);
    }
    var height = Math.max(leftH, rightH);
    // record the node and its depth and the height of the subtree rooted at the node
    depthHeight.put(root.val, new int[]{depth, height});
    // record the depth and the node with max height subtree at depth
    maxSubtree.putIfAbsent(depth, new int[]{root.val, height});
    var subtreeRoot = maxSubtree.get(depth);
    if (subtreeRoot[1] < height) {
      subtreeRoot[0] = root.val;
      subtreeRoot[1] = height;
    }

    levelNodes.putIfAbsent(depth, new ArrayList<>());
    levelNodes.get(depth).add(root.val);

    return height;
  }

  public static void main(String[] args) {
    var root = Tree.fromPreorder("5,8,2,4,null,null,6,null,null,1,null,null,9,3,null,null,7,null,null");
    System.out.println(Arrays.toString(treeQueries(root, new int[]{3,2,4,8})));
  }
}
