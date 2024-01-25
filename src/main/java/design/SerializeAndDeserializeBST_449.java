package design;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class SerializeAndDeserializeBST_449 {
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    var result = String.valueOf(root.val);
    if (root.left != null) {
      result += "," + serialize(root.left);
    }
    if (root.right != null) {
      result += "," + serialize(root.right);
    }
    return result;
  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    Integer[] vals = Arrays.stream(data.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
    return doDeserialize(vals, 0, vals.length - 1);
  }

  private static TreeNode doDeserialize(Integer[] vals, int from, int to) {
    var val = vals[from];
    var parent = new TreeNode(val);
    int idx = from + 1, len = vals.length;
    while (idx < len && vals[idx] < val) {
      idx++;
    }
    if (idx > from + 1) {
      // left child
      parent.left = doDeserialize(vals, from + 1, idx - 1);
    }
    if (idx <= to) {
      // right child
      parent.right = doDeserialize(vals, idx, to);
    }
    return parent;
  }

  public static void main(String[] args) {
    //        6
    //    4       9
    //  2   5   7
    var root = Tree.fromHeap(new Integer[]{6, 4, 9, 2, 5, 7});
    var ser = serialize(root);
    System.out.println(ser);

    var newRoot = deserialize(ser);
    var nodes = new ArrayList<Integer>();
    Tree.inorder(newRoot, nodes);
    nodes.forEach(System.out::println);
  }
}
