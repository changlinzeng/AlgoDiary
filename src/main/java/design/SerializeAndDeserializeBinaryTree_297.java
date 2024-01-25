package design;

import datautil.tree.Tree;
import datautil.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree_297 {
  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
//    var sb = new StringBuffer();
//    doSerialize(root, sb);
//    return sb.toString();
    return doSerializeBfs(root);
  }

  private static void doSerialize(TreeNode node, StringBuffer sb) {
    if (!sb.isEmpty()) {
      sb.append(",");
    }
    if (node == null) {
       sb.append("null");
       return;
    }
    sb.append(node.val);
    doSerialize(node.left, sb);
    doSerialize(node.right, sb);
  }

  private static String doSerializeBfs(TreeNode node) {
    var result = "";
    var q = new LinkedList<TreeNode>();
    q.offer(node);
    while (!q.isEmpty()) {
      if (!result.isEmpty()) {
        result += ",";
      }
      var n = q.poll();
      if (n == null) {
        result += "null";
        continue;
      }
      result += n.val;
      if (node.left == null && node.right == null) {
        continue;
      }
      q.offer(n.left);
      q.offer(n.right);
    }

    for (var i = result.length() - 1; i >= 0; i--) {
      if (result.charAt(i) >= '0' && result.charAt(i) <= '9') {
        return result.substring(0, i + 1);
      }
    }
    return result;
  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
//    return doDeserialize(data.split(","), new Index(0));
    return doDeserializeBfs(data.split(","));
  }


  private static TreeNode doDeserialize(String[] data, Index index) {
    var idx = index.val;
    if ("null".equals(data[idx])) {
      index.val++;
      return null;
    }
    var parent = new TreeNode(Integer.parseInt(data[idx]));
    index.val++;
    parent.left = doDeserialize(data, index);
    parent.right = doDeserialize(data, index);
    return parent;
  }

  private static TreeNode doDeserializeBfs(String[] data) {
    var val = data[0];
    if (val.equals("null")) {
      return null;
    }
    var root = new TreeNode(Integer.parseInt(val));
    var q = new ArrayDeque<TreeNode>();
    var index = 1;
    q.offer(root);
    while (!q.isEmpty() && index < data.length) {
      var node = q.poll();
      var leftVal = data[index++];
      if (!leftVal.equals("null")) {
        var left = new TreeNode(Integer.parseInt(leftVal));
        node.left = left;
        q.offer(left);
      }
      if (index < data.length) {
        var rightVal = data[index++];
        if (!rightVal.equals("null")) {
          var right = new TreeNode(Integer.parseInt(rightVal));
          node.right = right;
          q.offer(right);
        }
      }
    }

    return root;
  }

  private static class Index {
    public int val;
    public Index(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    //        1
    //    2       3
    //          4   5
    //  1,2,3,null,null,4,5
    //
    //        1
    //    2       3
    //      4   5
    //  1,2,3,null,4,5
    //
    //        1
    //               2
    //          3
    //             4
    //  1,null,2,3,null,null,4
//    var root = Tree.fromHeap(new Integer[]{1,2,3,null,null,4,5});
//    var root = Tree.fromHeap(new Integer[]{1,null,2,null,null,3});
//    var root = Tree.fromHeap(new Integer[]{1,2,3,null,null,4,5,null,null,null,null,6,7});
    var root = Tree.fromHeap(new Integer[]{1,2});
    var ser = serialize(root);
    System.out.println(ser);

    var newroot = deserialize(ser);
    var nodes = new ArrayList<Integer>();
    Tree.inorder(newroot, nodes);
    nodes.forEach(System.out::println);
  }
}
