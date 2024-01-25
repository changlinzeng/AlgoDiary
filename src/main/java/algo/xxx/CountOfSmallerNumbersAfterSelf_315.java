package algo.xxx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountOfSmallerNumbersAfterSelf_315 {
  public static List<Integer> countSmaller(int[] nums) {
    // build BST
    var len = nums.length;
    var count = new int[len];
    var root = new Node(nums[len - 1], 0, 1);
    for (var i = len - 2; i >= 0; i--) {
      count[i] = insert(root, nums[i]);
    }
    return Arrays.stream(count).boxed().collect(Collectors.toList());
  }

  private static int insert(Node root, int val) {
    // root is always non-null
    if (val < root.val)
    {
      root.lessCount++;
      if (root.left == null)
      {
        root.left = new Node(val, 0, 1);
        return 0;
      }
      return insert(root.left, val);
    }
    else if (root.val < val)
    {
      if (root.right == null)
      {
        root.right = new Node(val, 0, 1);
        return root.equalCount + root.lessCount;
      }
      return root.equalCount + root.lessCount + insert(root.right, val);
    }
    else
    {
      root.equalCount++;
      return root.lessCount;
    }
  }

  static class Node {
    public int val;
    public int lessCount;
    public int equalCount;
    public Node left;
    public Node right;
    public Node() {}
    public Node(int val, int lessCount, int equalCount) {
      this.val = val;
      this.lessCount = lessCount;
      this.equalCount = equalCount;
    }
  }

  public static void main(String[] args) {
    System.out.println(countSmaller(new int[]{5,2,6,1}));
    System.out.println(countSmaller(new int[]{-1}));
    System.out.println(countSmaller(new int[]{-1, -1}));
    System.out.println(countSmaller(new int[]{2,0,1}));
  }
}
