package design;

import datautil.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator_173 {
  static class BSTIterator {
    private List<Integer> vals;
    private int index;

    public BSTIterator(TreeNode root) {
      this.index = -1;
      vals = new ArrayList<>();
      init(root);
    }

    private void init(TreeNode root) {
      if (root == null) {
        return;
      }
      init(root.left);
      vals.add(root.val);
      init(root.right);
    }

    public int next() {
      if (index < 0) {
        index++;
        return vals.getFirst();
      }
      if (index < vals.size()) {
        return vals.get(++index);
      }
      return -1;
    }

    public boolean hasNext() {
      return index < vals.size() - 1;
    }
  }
}
