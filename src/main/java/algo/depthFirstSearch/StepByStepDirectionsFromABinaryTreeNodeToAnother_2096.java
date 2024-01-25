package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother_2096 {
  public static String getDirections(TreeNode root, int startValue, int destValue) {
    var pathToStart = new ArrayList<String>();
    var pathToDest = new ArrayList<String>();
    dfs(root, startValue, destValue, "", pathToStart, pathToDest);
    var parentIndex = 0;
    while (parentIndex < pathToStart.size() && parentIndex < pathToDest.size() &&
      pathToStart.get(parentIndex).split("\\.")[0].equals(pathToDest.get(parentIndex).split("\\.")[0])) {
      parentIndex++;
    }

    var startPath = "U".repeat(pathToStart.size() - parentIndex - 1);
    var destPath = new StringBuilder();
    for (var i = parentIndex; i < pathToDest.size() - 1; i++) {
      destPath.append(pathToDest.get(i).split("\\.")[1]);
    }

    return startPath + destPath;
  }

  private static void dfs(TreeNode node, int startValue, int destValue, String direction, List<String> pathToStart, List<String> pathToDest) {
    if (node == null) {
      return;
    }
    if (pathToStart.isEmpty() || !pathToStart.getLast().equals("-")) {
      pathToStart.add(node.val + "." + direction);
    }
    if (pathToDest.isEmpty() || !pathToDest.getLast().equals("-")) {
      pathToDest.add(node.val + "." + direction);
    }
    if (node.val == startValue) {
      pathToStart.add("-");
    }
    if (node.val == destValue) {
      pathToDest.add("-");
    }
    if (!pathToStart.isEmpty() && pathToStart.getLast().equals("-") &&
            !pathToDest.isEmpty() && pathToDest.getLast().equals("-")) {
      return;
    }
    dfs(node.left, startValue, destValue, "L", pathToStart, pathToDest);
    dfs(node.right, startValue, destValue, "R", pathToStart, pathToDest);
    if (!pathToStart.isEmpty() && !pathToStart.getLast().equals("-")) {
      pathToStart.removeLast();
    }
    if (!pathToDest.isEmpty() && !pathToDest.getLast().equals("-")) {
      pathToDest.removeLast();
    }
  }

  public static void main(String[] args) {
//    var root = Tree.fromPreorderAndInorderTraverse(new int[]{5,1,3,2,6,4}, new int[]{3,1,5,6,2,4});
    var root = Tree.fromPreorderAndInorderTraverse(new int[]{2,1}, new int[]{1,2});
    System.out.println(getDirections(root, 2, 1));
  }
}
