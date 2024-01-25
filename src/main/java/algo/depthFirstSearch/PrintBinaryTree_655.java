package algo.depthFirstSearch;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree_655 {
  public static List<List<String>> printTree(TreeNode root) {
    var height = height(root);
    int col = (int)(Math.pow(2, height) - 1);
    var matrix = new String[height][];
    for (var i = 0; i < height; i++) {
      matrix[i] = new String[col];
      Arrays.fill(matrix[i], "");
    }

    print(root, matrix, 0, col - 1, 0);

    var result = new ArrayList<List<String>>();
    for (var row : matrix) {
      result.add(new ArrayList<>(List.of(row)));
    }
    return result;
  }

  private static void print(TreeNode node, String[][] matrix, int start, int end, int level) {
    if (node == null) {
      return;
    }
    var mid = start + (end - start) / 2;
    matrix[level][mid] = String.valueOf(node.val);
    print(node.left, matrix, start, mid - 1, level + 1);
    print(node.right , matrix, mid + 1, end, level + 1);
  }

  private static int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }

  public static void main(String[] args) {
//    var root = Tree.fromPreorderAndInorderTraverse(new int[]{1,2}, new int[]{2,1});
    var root = Tree.fromPreorderAndInorderTraverse(new int[]{1,2,4,3}, new int[]{2,4,1,3});
    printTree(root).forEach(System.out::println);
  }
}
